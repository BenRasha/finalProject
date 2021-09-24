package by.training.gallery.dao.impl;

import by.training.gallery.dao.SketchPhotoDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.SketchPhoto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SketchPhotoDaoImpl extends SketchPhotoDao {

    private static final String SKETCH_ID_LABEL = "sketch_id";
    private static final String PHOTO_LABEL = "photo_path";

    private static final String SQL_SELECT_ALL_SKETCHES_PHOTOS
            = "SELECT sketch_id, photo_path FROM sketches_photos";
    private static final String SQL_SELECT_SKETCHES_PHOTOS_BY_ID
            = "SELECT sketch_id, photo_path FROM sketches_photos WHERE sketch_id = ?";
    private static final String SQL_CREATE_SKETCH_PHOTO
            = "INSERT INTO sketches_photos(sketch_id, photo_path) VALUES(?, ?)";

    @Override
    public List<SketchPhoto> findAll() throws DAOException {
        List<SketchPhoto> sketchPhotos = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SKETCHES_PHOTOS);
            while (resultSet.next()) {
                SketchPhoto sketchPhoto = new SketchPhoto();
                sketchPhoto.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                sketchPhoto.setPhotoPath(resultSet.getString(PHOTO_LABEL));
                sketchPhotos.add(sketchPhoto);
            }
        } catch (SQLException exception) {
            throw new DAOException( exception);
        } finally {
            close(statement);
        }
        return sketchPhotos;
    }

    @Override
    public SketchPhoto findEntityById(Integer id) throws DAOException {
        SketchPhoto sketchPhoto = new SketchPhoto();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_SKETCHES_PHOTOS_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                sketchPhoto.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                sketchPhoto.setPhotoPath(resultSet.getString(PHOTO_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return sketchPhoto;
    }

    @Override
    public void delete(Integer id) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_SKETCHES_PHOTOS_BY_ID);
            statement.setString(1, String.valueOf(id));
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(SketchPhoto entity) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public SketchPhoto create(SketchPhoto entity) throws DAOException {
        SketchPhoto sketchPhoto = new SketchPhoto();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CREATE_SKETCH_PHOTO, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(entity.getSketchId()));
            statement.setString(2, entity.getPhotoPath());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                sketchPhoto.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                sketchPhoto.setPhotoPath(resultSet.getString(PHOTO_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return sketchPhoto;
    }

    @Override
    public List<SketchPhoto> findAllSketchesPhotosById(Integer id) throws DAOException {
        List<SketchPhoto> sketchPhotos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_SKETCHES_PHOTOS_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SketchPhoto sketchPhoto = new SketchPhoto();
                sketchPhoto.setSketchId(resultSet.getInt(SKETCH_ID_LABEL));
                sketchPhoto.setPhotoPath(resultSet.getString(PHOTO_LABEL));
                sketchPhotos.add(sketchPhoto);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return sketchPhotos;
    }
}
