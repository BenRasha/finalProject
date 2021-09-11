package by.training.gallery.dao.impl;

import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.RealismPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.RealismPainting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RealismPaintingDaoImpl implements RealismPaintingDao {

    private static final String SQL_SELECT_ALL_REALISM_PAINTINGS_BY_DATE
            = "SELECT painting_id, rls_size, rls_material FROM realism_paintings WHERE rls_date=?";
    private static final String SQL_SELECT_ALL_REALISM_PAINTINGS
            = "SELECT painting_id, rls_size, rls_material, rls_date FROM realism_paintings";

    @Override
    public List<RealismPainting> findRealismPaintingByDate(String patternDate) throws DAOException {
        List<RealismPainting> realismPaintings = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_REALISM_PAINTINGS_BY_DATE);
            statement.setString(1, patternDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RealismPainting realismPainting = new RealismPainting();
                realismPainting.setPaintingId(resultSet.getInt("painting_id"));
                realismPainting.setSize(resultSet.getString("rls_size"));
                realismPainting.setMaterial(resultSet.getString("rls_material"));
                realismPainting.setDate(resultSet.getDate("rls_date"));
                realismPaintings.add(realismPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return realismPaintings;
    }

    @Override
    public List<RealismPainting> findAll() throws DAOException {
        List<RealismPainting> realismPaintings = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_REALISM_PAINTINGS);
            while (resultSet.next()) {
                RealismPainting realismPainting = new RealismPainting();
                realismPainting.setPaintingId(resultSet.getInt("painting_id"));
                realismPainting.setSize(resultSet.getString("rls_size"));
                realismPainting.setMaterial(resultSet.getString("rls_material"));
                realismPainting.setDate(resultSet.getDate("rls_date"));
                realismPaintings.add(realismPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return realismPaintings;
    }

    @Override
    public RealismPainting findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(RealismPainting realismPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(RealismPainting realismPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public RealismPainting update(RealismPainting realismPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

}
