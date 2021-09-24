package by.training.gallery.dao.connectionpool;

import by.training.gallery.dao.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    private static final Logger connectionPoolLogger = LogManager.getLogger(ConnectionPool.class.getName());

    private String url;
    private String user;
    private String password;
    private int maxSize;
    private int checkConnectionTimeout;

    private BlockingQueue<PooledConnection> freeConnections = new LinkedBlockingQueue<>();
    private Set<PooledConnection> usedConnections = new ConcurrentSkipListSet<>();

    private ConnectionPool() {}

    public synchronized Connection getConnection() {
        PooledConnection connection = null;
        while (connection == null) {
            try {
                if (!freeConnections.isEmpty()) {
                    connection = freeConnections.take();
                    if (!connection.isValid(checkConnectionTimeout)) {
                        try {
                            connection.getConnection().close();
                        } catch (SQLException exception) {
                            connection = null;
                        }
                    } else if (usedConnections.size() < maxSize) {
                        connection = createConnection();
                    } else {
                        connectionPoolLogger.error("The limit of number of database connections is exceeded");
                    }
                }
            } catch (InterruptedException | SQLException exception) {
                connectionPoolLogger.error("It is impossible to connect to a database", exception);
            }
        }
        usedConnections.add(connection);
        connectionPoolLogger.debug("Connection was received from pool. Current pool size:" +
                " %d used connections; %d free connection", usedConnections.size(), freeConnections.size());
        return connection;
    }

    synchronized void freeConnection(PooledConnection connection) {
        try {
            if (connection.isValid(checkConnectionTimeout)) {
                connection.clearWarnings();
                connection.setAutoCommit(true);
                usedConnections.remove(connection);
                freeConnections.put(connection);
                connectionPoolLogger.debug("Connection was returned into pool. Current pool size:" +
                        " %d used connections; %d free connection", usedConnections.size(), freeConnections.size());
            }
        } catch (SQLException | InterruptedException exception1) {
            connectionPoolLogger.warn("It is impossible to return database connection into pool", exception1);
            try {
                connection.getConnection().close();
            } catch (SQLException exception2) {
            }
        }
    }

    public synchronized void init(String driverClass, String url, String user, String password, int startSize, int maxSize, int checkConnectionTimeout) throws PersistentException {
        try {
            destroy();
            Class.forName(driverClass);
            this.url = url;
            this.user = user;
            this.password = password;
            this.maxSize = maxSize;
            this.checkConnectionTimeout = checkConnectionTimeout;
            for (int counter = 0; counter < startSize; counter++) {
                freeConnections.put(createConnection());
            }
        } catch (ClassNotFoundException | SQLException | InterruptedException exception) {
            connectionPoolLogger.fatal("It is impossible to initialize connection pool", exception);
            throw new PersistentException(exception);
        }
    }

    private static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return instance;
    }

    private PooledConnection createConnection() throws SQLException {
        return new PooledConnection(DriverManager.getConnection(url, user, password));
    }

    public synchronized void destroy() {
        usedConnections.addAll(freeConnections);
        freeConnections.clear();
        for (PooledConnection connection : usedConnections) {
            try {
                connection.getConnection().close();
            } catch (SQLException exception) {}
        }
        usedConnections.clear();
    }

    @Override
    protected void finalize() throws Throwable {
        destroy();
    }

}
