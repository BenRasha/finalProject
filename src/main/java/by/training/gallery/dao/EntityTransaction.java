package by.training.gallery.dao;

import by.training.gallery.dao.connectionpool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityTransaction {

    static final Logger entityTransactionLogger = LogManager.getLogger(EntityTransaction.class.getName());
    private Connection connection;

    public void initTransaction(AbstractDao dao, AbstractDao ... daos) {
        try {
            if (connection == null) {
                connection = ConnectionPool.getInstance().getConnection();
            }
            connection.setAutoCommit(false);
        } catch (SQLException exception) {
            entityTransactionLogger.error(exception);
        }
        dao.setConnection(connection);
        for (AbstractDao daoElement : daos) {
            daoElement.setConnection(connection);
        }
    }

    public void endTransaction() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException exception) {
            entityTransactionLogger.error(exception);
        }
        try {
            connection.close();
        } catch (SQLException exception) {
            entityTransactionLogger.error(exception);
        }
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException exception) {
            entityTransactionLogger.error(exception);
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException exception) {
            entityTransactionLogger.error(exception);
        }
    }

    public void init(AbstractDao dao) {
        if (connection == null) {
            connection = ConnectionPool.getInstance().getConnection();
            }
        dao.setConnection(connection);
    }

    public void end() {
        try {
            connection.close();
        } catch (SQLException exception) {
            entityTransactionLogger.error(exception);
        }
    }

}
