package by.training.gallery.dao.impl;

import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.SketchDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Sketch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SketchDaoImpl implements SketchDao {

    private static final String SQL_SELECT_ALL_SKETCHES_BY_TITLE
            = "SELECT sketch_id, sketch_description, sketch_size, image_id, sketch_date FROM sketches WHERE sketch_title=?";
    private static final String SQL_SELECT_ALL_SKETCHES
            = "SELECT sketch_id, sketch_title, sketch_description, sketch_size, image_id, sketch_date FROM sketches";

    @Override
    public List<Sketch> findSketchByTitle(String patternTitle) throws DAOException {
        List<Sketch> sketches = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_SKETCHES_BY_TITLE);
            statement.setString(1, patternTitle);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sketch sketch = new Sketch();
                sketch.setSketchId(resultSet.getInt("sketch_id"));
                sketch.setTitle(resultSet.getString("sketch_title"));
                sketch.setDescription(resultSet.getString("sketch_description"));
                sketch.setSize(resultSet.getString("sketch_size"));
                sketch.setImageId(resultSet.getInt("image_id"));
                sketch.setDate(resultSet.getDate("sketch_date"));
                sketches.add(sketch);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return sketches;
    }

    @Override
    public List<Sketch> findAll() throws DAOException {
        List<Sketch> sketches = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SKETCHES);
            while (resultSet.next()) {
                Sketch sketch = new Sketch();
                sketch.setSketchId(resultSet.getInt("sketch_id"));
                sketch.setTitle(resultSet.getString("sketch_title"));
                sketch.setDescription(resultSet.getString("sketch_description"));
                sketch.setSize(resultSet.getString("sketch_size"));
                sketch.setImageId(resultSet.getInt("image_id"));
                sketch.setDate(resultSet.getDate("sketch_date"));
                sketches.add(sketch);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return sketches;
    }

    @Override
    public Sketch findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Sketch sketch) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Sketch sketch) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Sketch update(Sketch sketch) throws DAOException {
        throw new UnsupportedOperationException();
    }

}
