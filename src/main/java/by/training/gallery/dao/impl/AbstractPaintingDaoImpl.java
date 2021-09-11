package by.training.gallery.dao.impl;

import by.training.gallery.dao.AbstractPaintingDao;
import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.AbstractPainting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractPaintingDaoImpl implements AbstractPaintingDao {

    private static final String SQL_SELECT_ALL_ABSTRACT_PAINTINGS_BY_DATE
            = "SELECT painting_id, ab_size, ab_material FROM abstract_paintings WHERE ab_date=?";
    private static final String SQL_SELECT_ALL_ABSTRACT_PAINTINGS
            = "SELECT painting_id, ab_size, ab_material, ab_date FROM abstract_paintings";

    @Override
    public List<AbstractPainting> findAbstractPaintingByDate(String patterDate) throws DAOException {
        List<AbstractPainting> abstractPaintings = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_ABSTRACT_PAINTINGS_BY_DATE);
            statement.setString(1, patterDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AbstractPainting abstractPainting = new AbstractPainting();
                abstractPainting.setPaintingId(resultSet.getInt("painting_id"));
                abstractPainting.setSize(resultSet.getString("ab_size"));
                abstractPainting.setMaterial(resultSet.getString("ab_material"));
                abstractPainting.setDate(resultSet.getDate("ab_date"));
                abstractPaintings.add(abstractPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return abstractPaintings;
    }

    @Override
    public List<AbstractPainting> findAll() throws DAOException {
        List<AbstractPainting> abstractPaintings = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ABSTRACT_PAINTINGS);
            while (resultSet.next()) {
                AbstractPainting abstractPainting = new AbstractPainting();
                abstractPainting.setPaintingId(resultSet.getInt("painting_id"));
                abstractPainting.setSize(resultSet.getString("ab_size"));
                abstractPainting.setMaterial(resultSet.getString("ab_material"));
                abstractPainting.setDate(resultSet.getDate("ab_date"));
                abstractPaintings.add(abstractPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return abstractPaintings;
    }

    @Override
    public AbstractPainting findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(AbstractPainting abstractPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(AbstractPainting abstractPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractPainting update(AbstractPainting abstractPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

}
