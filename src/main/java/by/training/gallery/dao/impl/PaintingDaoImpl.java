package by.training.gallery.dao.impl;

import by.training.gallery.dao.PaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Painting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaintingDaoImpl extends PaintingDao {

    private static final String PAINTING_ID_LABEL = "id";
    private static final String TITLE_LABEL = "title";
    private static final String STYLE_LABEL = "style";
    private static final String SIZE_LABEL = "size";
    private static final String MATERIAL_LABEL = "material";
    private static final String DATE_LABEL = "date";

    private static final String SQL_SELECT_ALL_PAINTINGS
            = "SELECT id, title, style, size, material, date FROM paintings";
    private static final String SQL_FIND_PAINTING_BY_ID
            = "SELECT id, title, style, size, material, date FROM paintings WHERE id = ?";
    private static final String SQL_DELETE_FROM_PAINTINGS_BY_ID
            = "DELETE FROM paintings WHERE id = ?";
    private static final String SQL_DELETE_FROM_PAINTINGS_BY_TITLE
            = "DELETE FROM paintings WHERE title = ?";
    private static final String SQL_CREATE_PAINTING
            = "INSERT INTO paintings(id, title, style, size, material, date) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_FIND_PAINTINGS_BY_TITLE
            = "SELECT id, title, style, size, material, date FROM paintings WHERE title = ?";
    private static final String SQL_FIND_PAINTINGS_BY_STYLE
            = "SELECT id, title, style, size, material, date FROM paintings WHERE style = ?";
    private static final String SQL_FIND_PAINTINGS_BY_SIZE
            = "SELECT id, title, style, size, material, date FROM paintings WHERE size = ?";
    private static final String SQL_FIND_PAINTINGS_BY_MATERIAL
            = "SELECT id, title, style, size, material, date FROM paintings WHERE material = ?";
    private static final String SQL_FIND_PAINTINGS_BY_DATE
            = "SELECT id, title, style, size, material, date FROM paintings WHERE date = ?";

    @Override
    public List<Painting> findAll() throws DAOException {
        List<Painting> paintings = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PAINTINGS);
            while (resultSet.next()) {
                Painting painting = new Painting();
                painting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                painting.setTitle(resultSet.getString(TITLE_LABEL));
                painting.setStyle(resultSet.getString(STYLE_LABEL));
                painting.setSize(resultSet.getString(SIZE_LABEL));
                painting.setMaterial(resultSet.getString(MATERIAL_LABEL));
                painting.setDate(resultSet.getDate(DATE_LABEL));
                paintings.add(painting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintings;
    }

    @Override
    public Painting findEntityById(Integer id) throws DAOException {
        Painting painting = new Painting();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_FIND_PAINTING_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                painting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                painting.setTitle(resultSet.getString(TITLE_LABEL));
                painting.setStyle(resultSet.getString(STYLE_LABEL));
                painting.setSize(resultSet.getString(SIZE_LABEL));
                painting.setMaterial(resultSet.getString(MATERIAL_LABEL));
                painting.setDate(resultSet.getDate(DATE_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return painting;
    }

    @Override
    public void delete(Integer id) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_FROM_PAINTINGS_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(Painting entity) throws DAOException {
        String title = entity.getTitle();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_FROM_PAINTINGS_BY_TITLE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, title);
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public Painting create(Painting entity) throws DAOException {
        Painting createdPainting = new Painting();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CREATE_PAINTING, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(entity.getPaintingId()));
            statement.setString(2, entity.getTitle());
            statement.setString(3, entity.getStyle());
            statement.setString(4, entity.getSize());
            statement.setString(5, entity.getMaterial());
            statement.setString(6, String.valueOf(entity.getDate()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                createdPainting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                createdPainting.setTitle(resultSet.getString(TITLE_LABEL));
                createdPainting.setStyle(resultSet.getString(STYLE_LABEL));
                createdPainting.setSize(resultSet.getString(SIZE_LABEL));
                createdPainting.setMaterial(resultSet.getString(MATERIAL_LABEL));
                createdPainting.setDate(resultSet.getDate(DATE_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return createdPainting;
    }

    @Override
    public List<Painting> findPaintingsByTitle(String patternTitle) throws DAOException {
        List<Painting> paintings = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_FIND_PAINTINGS_BY_TITLE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternTitle);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Painting painting = new Painting();
                painting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                painting.setTitle(resultSet.getString(TITLE_LABEL));
                painting.setStyle(resultSet.getString(STYLE_LABEL));
                painting.setSize(resultSet.getString(SIZE_LABEL));
                painting.setMaterial(resultSet.getString(MATERIAL_LABEL));
                painting.setDate(resultSet.getDate(DATE_LABEL));
                paintings.add(painting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintings;
    }

    @Override
    public List<Painting> findPaintingsByStyle(String patternStyle) throws DAOException {
        List<Painting> paintings = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_FIND_PAINTINGS_BY_STYLE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternStyle);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Painting painting = new Painting();
                painting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                painting.setTitle(resultSet.getString(TITLE_LABEL));
                painting.setStyle(resultSet.getString(STYLE_LABEL));
                painting.setSize(resultSet.getString(SIZE_LABEL));
                painting.setMaterial(resultSet.getString(MATERIAL_LABEL));
                painting.setDate(resultSet.getDate(DATE_LABEL));
                paintings.add(painting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintings;
    }

    @Override
    public List<Painting> findPaintingsBySize(String patternSize) throws DAOException {
        List<Painting> paintings = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_FIND_PAINTINGS_BY_SIZE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternSize);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Painting painting = new Painting();
                painting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                painting.setTitle(resultSet.getString(TITLE_LABEL));
                painting.setStyle(resultSet.getString(STYLE_LABEL));
                painting.setSize(resultSet.getString(SIZE_LABEL));
                painting.setMaterial(resultSet.getString(MATERIAL_LABEL));
                painting.setDate(resultSet.getDate(DATE_LABEL));
                paintings.add(painting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintings;
    }

    @Override
    public List<Painting> findPaintingsByMaterial(String patternMaterial) throws DAOException {
        List<Painting> paintings = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_FIND_PAINTINGS_BY_MATERIAL, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternMaterial);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Painting painting = new Painting();
                painting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                painting.setTitle(resultSet.getString(TITLE_LABEL));
                painting.setStyle(resultSet.getString(STYLE_LABEL));
                painting.setSize(resultSet.getString(SIZE_LABEL));
                painting.setMaterial(resultSet.getString(MATERIAL_LABEL));
                painting.setDate(resultSet.getDate(DATE_LABEL));
                paintings.add(painting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintings;
    }

    @Override
    public List<Painting> findPaintingsByDate(String patternDate) throws DAOException {
        List<Painting> paintings = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_FIND_PAINTINGS_BY_DATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Painting painting = new Painting();
                painting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                painting.setTitle(resultSet.getString(TITLE_LABEL));
                painting.setStyle(resultSet.getString(STYLE_LABEL));
                painting.setSize(resultSet.getString(SIZE_LABEL));
                painting.setMaterial(resultSet.getString(MATERIAL_LABEL));
                painting.setDate(resultSet.getDate(DATE_LABEL));
                paintings.add(painting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintings;
    }
}
