package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao <K, T extends Entity> {

    static final Logger baseDaoLogger = LogManager.getLogger(BaseDao.class.getName());

    List<T> findAll() throws DAOException;
    T findEntityById(K id) throws DAOException;
    boolean delete(T t) throws DAOException;
    boolean delete(K k) throws DAOException;
    boolean create(T t) throws DAOException;
    T update(T t) throws DAOException;

    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException exception) {
            baseDaoLogger.error(exception);
        }
    }

    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            baseDaoLogger.error(exception);
        }
    }

}
