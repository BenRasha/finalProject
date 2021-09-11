package by.training.gallery.dao.impl;

import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.PaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Painting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaintingDaoImpl implements PaintingDao {

    private static final String SQL_SELECT_ALL_PAINTINGS = "SELECT painting_id, image_id, title, description, style FROM paintings";
    private static final String SQL_SELECT_ALL_PAINTINGS_BY_TITLE
            = "SELECT painting_id, image_id, description, style FROM paintings WHERE title=?";

    @Override
    public List<Painting> findPaintingByTitle(String patternTitle) throws DAOException {
        List<Painting> paintings = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_PAINTINGS_BY_TITLE);
            statement.setString(1, patternTitle);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Painting painting = new Painting();
                painting.setPaintingId(resultSet.getInt("painting_id"));
                painting.setImageId(resultSet.getInt("image_id"));
                painting.setTitle(resultSet.getString("title"));
                painting.setDescription(resultSet.getString("description"));
                painting.setStyle(resultSet.getString("style"));
                paintings.add(painting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return paintings;
    }

    @Override
    public List<Painting> findAll() throws DAOException {
        List<Painting> paintings = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PAINTINGS);
            while (resultSet.next()) {
                Painting painting = new Painting();
                painting.setPaintingId(resultSet.getInt("painting_id"));
                painting.setImageId(resultSet.getInt("image_id"));
                painting.setTitle(resultSet.getString("title"));
                painting.setDescription(resultSet.getString("description"));
                painting.setStyle(resultSet.getString("style"));
                paintings.add(painting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return paintings;
    }

    @Override
    public Painting findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Painting painting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Painting painting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Painting update(Painting painting) throws DAOException {
        throw new UnsupportedOperationException();
    }
}
