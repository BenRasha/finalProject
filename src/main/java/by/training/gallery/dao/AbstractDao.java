package by.training.gallery.dao;

import by.training.gallery.dao.connectionpool.ConnectionPool;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao <K, T extends Entity> {

    static final Logger abstractDaoLogger = LogManager.getLogger(AbstractDao.class.getName());
    protected Connection connection = ConnectionPool.getInstance().getConnection();

    public abstract List<T> findAll() throws DAOException;
    public abstract T findEntityById(K id) throws DAOException;
    public abstract void delete(K id) throws DAOException;
    public abstract void delete(T entity) throws DAOException;
    public abstract T create(T entity) throws DAOException;
    public void close(Statement statement) {
        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException exception) {
            abstractDaoLogger.error(exception);
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
