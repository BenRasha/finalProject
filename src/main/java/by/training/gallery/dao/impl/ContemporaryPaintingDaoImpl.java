package by.training.gallery.dao.impl;

import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.ContemporaryPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.ContemporaryPainting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContemporaryPaintingDaoImpl implements ContemporaryPaintingDao {

    private static final String SQL_SELECT_ALL_CONTEMPORARY_PAINTINGS_BY_DATE
            = "SELECT painting_id, con_size, image_id, con_material FROM contemporary_paintings WHERE con_date=?";
    private static final String SQL_SELECT_ALL_CONTEMPORARY_PAINTINGS
            = "SELECT painting_id, con_size, image_id, con_material, con_date FROM contemporary_paintings";

    @Override
    public List<ContemporaryPainting> findContemporaryPaintingByDate(String patternDate) throws DAOException {
        List<ContemporaryPainting> contemporaryPaintings = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_CONTEMPORARY_PAINTINGS_BY_DATE);
            statement.setString(1, patternDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ContemporaryPainting contemporaryPainting = new ContemporaryPainting();
                contemporaryPainting.setPaintingId(resultSet.getInt("painting_id"));
                contemporaryPainting.setSize(resultSet.getString("con_size"));
                contemporaryPainting.setImageId(resultSet.getInt("image_id"));
                contemporaryPainting.setMaterial(resultSet.getString("con_material"));
                contemporaryPainting.setDate(resultSet.getDate("con_date"));
                contemporaryPaintings.add(contemporaryPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return contemporaryPaintings;
    }

    @Override
    public List<ContemporaryPainting> findAll() throws DAOException {
        List<ContemporaryPainting> contemporaryPaintings = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CONTEMPORARY_PAINTINGS);
            while (resultSet.next()) {
                ContemporaryPainting contemporaryPainting = new ContemporaryPainting();
                contemporaryPainting.setPaintingId(resultSet.getInt("painting_id"));
                contemporaryPainting.setSize(resultSet.getString("con_size"));
                contemporaryPainting.setImageId(resultSet.getInt("image_id"));
                contemporaryPainting.setMaterial(resultSet.getString("con_material"));
                contemporaryPainting.setDate(resultSet.getDate("con_date"));
                contemporaryPaintings.add(contemporaryPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return contemporaryPaintings;
    }

    @Override
    public ContemporaryPainting findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(ContemporaryPainting contemporaryPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(ContemporaryPainting contemporaryPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ContemporaryPainting update(ContemporaryPainting contemporaryPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

}
