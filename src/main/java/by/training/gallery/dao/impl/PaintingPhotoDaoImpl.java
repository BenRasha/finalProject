package by.training.gallery.dao.impl;

import by.training.gallery.dao.PaintingPhotoDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.PaintingPhoto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaintingPhotoDaoImpl extends PaintingPhotoDao {

    private static final String PAINTING_ID_LABEL = "painting_id";
    private static final String PHOTO_LABEL = "photo_path";

    private static final String SQL_SELECT_ALL_PHOTOS
            = "SELECT painting_id, photo_path FROM painting_photos";
    private static final String SQL_SELECT_PHOTOS_BY_PAINTING_ID
            = "SELECT painting_id, photo_path FROM painting_photos WHERE painting_id = ?";
    private static final String SQL_DELETE_PAINTING_PHOTO_BY_PAINTING_ID
            = "DELETE FROM painting_photos WHERE painting_id = ?";
    private static final String SQL_CREATE_PAINTING_PHOTO
            = "INSERT INTO painting_photos(painting_id, photo_path) VALUES(?, ?)";

    @Override
    public List<PaintingPhoto> findAll() throws DAOException {
        List<PaintingPhoto> paintingPhotos = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PHOTOS);
            while (resultSet.next()) {
                PaintingPhoto paintingPhoto = new PaintingPhoto();
                paintingPhoto.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                paintingPhoto.setPhotoPath(resultSet.getString(PHOTO_LABEL));
                paintingPhotos.add(paintingPhoto);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintingPhotos;
    }

    @Override
    public PaintingPhoto findEntityById(Integer id) throws DAOException {
        PaintingPhoto paintingPhoto = new PaintingPhoto();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_PHOTOS_BY_PAINTING_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                paintingPhoto.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                paintingPhoto.setPhotoPath(resultSet.getString(PHOTO_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintingPhoto;
    }

    @Override
    public void delete(Integer id) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_PAINTING_PHOTO_BY_PAINTING_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(PaintingPhoto entity) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PaintingPhoto create(PaintingPhoto entity) throws DAOException {
        PaintingPhoto createdPaintingPhoto = new PaintingPhoto();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CREATE_PAINTING_PHOTO, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(entity.getPaintingId()));
            statement.setString(2, entity.getPhotoPath());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                createdPaintingPhoto.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                createdPaintingPhoto.setPhotoPath(resultSet.getString(PHOTO_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return createdPaintingPhoto;
    }

    @Override
    public List<PaintingPhoto> findAllPaintingsPhotosByPaintingId(Integer id) throws DAOException {
        List<PaintingPhoto> paintingPhotos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_PHOTOS_BY_PAINTING_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PaintingPhoto paintingPhoto = new PaintingPhoto();
                paintingPhoto.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                paintingPhoto.setPhotoPath(resultSet.getString(PHOTO_LABEL));
                paintingPhotos.add(paintingPhoto);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return paintingPhotos;
    }
}
