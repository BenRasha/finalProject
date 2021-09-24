package by.training.gallery.dao.impl;

import by.training.gallery.dao.SketchDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Sketch;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SketchDaoImpl extends SketchDao {

    private static final String SKETCH_ID_LABEL = "id";
    private static final String TITLE_LABEL = "title";
    private static final String DATE_LABEL = "date";

    private static final String SQL_SELECT_ALL_SKETCHES
            = "SELECT id, title, date FROM sketches";
    private static final String SQL_SELECT_ALL_SKETCHES_BY_ID
            = "SELECT id, title, date FROM sketches WHERE id = ?";
    private static final String SQL_DELETE_SKETCH_BY_ID
            = "DELETE FROM sketches WHERE id = ?";
    private static final String SQL_DELETE_SKETCH_BY_TITLE
            = "DELETE FROM sketches WHERE title = ?";
    private static final String SLQ_CREATE_SKETCH
            = "INSERT INTO sketches(id, title, date) VALUES(?, ?, ?)";
    private static final String SQL_SELECT_ALL_SKETCHES_BY_TITLE
            = "SELECT id, title, date FROM sketches WHERE title = ?";
    private static final String SQL_SELECT_ALL_SKETCHES_BY_DATE
            = "SELECT id, title, date FROM sketches WHERE date = ?";

    @Override
    public List<Sketch> findAll() throws DAOException {
        List<Sketch> sketches = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SKETCHES);
            while (resultSet.next()) {
                Sketch sketch = new Sketch();
                sketch.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                sketch.setTitle(resultSet.getString(TITLE_LABEL));
                sketch.setDate(resultSet.getDate(DATE_LABEL));
                sketches.add(sketch);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return sketches;
    }

    @Override
    public Sketch findEntityById(Integer id) throws DAOException {
        Sketch sketch = new Sketch();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_SKETCHES_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                sketch.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                sketch.setTitle(resultSet.getString(TITLE_LABEL));
                sketch.setDate(resultSet.getDate(DATE_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return sketch;
    }

    @Override
    public void delete(Integer id) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_SKETCH_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException();
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(Sketch entity) throws DAOException {
        String title = entity.getTitle();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_SKETCH_BY_TITLE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, title);
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public Sketch create(Sketch entity) throws DAOException {
        Sketch createdSketch = new Sketch();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SLQ_CREATE_SKETCH, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(entity.getSketchId()));
            statement.setString(2, entity.getTitle());
            statement.setString(3, String.valueOf(entity.getDate()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                createdSketch.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                createdSketch.setTitle(resultSet.getString(TITLE_LABEL));
                createdSketch.setDate(resultSet.getDate(DATE_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return createdSketch;
    }

    @Override
    public List<Sketch> findSketchesByTitle(String patternTitle) throws DAOException {
        List<Sketch> sketches = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_SKETCHES_BY_TITLE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternTitle);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sketch sketch = new Sketch();
                sketch.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                sketch.setTitle(resultSet.getString(TITLE_LABEL));
                sketch.setDate(resultSet.getDate(DATE_LABEL));
                sketches.add(sketch);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return sketches;
    }

    @Override
    public List<Sketch> findSketchesByDate(String patternDate) throws DAOException {
        List<Sketch> sketches = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_SKETCHES_BY_DATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sketch sketch = new Sketch();
                sketch.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                sketch.setTitle(resultSet.getString(TITLE_LABEL));
                sketch.setDate(resultSet.getDate(DATE_LABEL));
                sketches.add(sketch);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return sketches;
    }

}
