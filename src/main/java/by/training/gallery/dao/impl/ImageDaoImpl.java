package by.training.gallery.dao.impl;

import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.ImageDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageDaoImpl implements ImageDao {

    private static final String SQL_SELECT_ALL_IMAGES_BY_MAIN_IMAGE
            = "SELECT image_id, first_image, second_image, third_image, fourth_image, fifth_image FROM images WHERE main_image=?";
    private static final String SQL_SELECT_ALL_IMAGES
            = "SELECT image_id, main_image, first_image, second_image, third_image, fourth_image, fifth_image FROM images";

    @Override
    public List<Image> findImageByMainImage(String patternMainImage) throws DAOException {
        List<Image> images = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_IMAGES_BY_MAIN_IMAGE);
            statement.setString(1, patternMainImage);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Image image = new Image();
                image.setImageId(resultSet.getInt("image_id"));
                image.setMainImage(resultSet.getString("main_image"));
                image.setFirstImage(resultSet.getString("first_image"));
                image.setSecondImage(resultSet.getString("second_image"));
                image.setThirdImage(resultSet.getString("third_image"));
                image.setFourthImage(resultSet.getString("fourth_image"));
                image.setFifthImage(resultSet.getString("fifth_image"));
                images.add(image);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return images;
    }

    @Override
    public List<Image> findAll() throws DAOException {
        List<Image> images = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_IMAGES);
            while (resultSet.next()) {
                Image image = new Image();
                image.setImageId(resultSet.getInt("image_id"));
                image.setMainImage(resultSet.getString("main_image"));
                image.setFirstImage(resultSet.getString("first_image"));
                image.setSecondImage(resultSet.getString("second_image"));
                image.setThirdImage(resultSet.getString("third_image"));
                image.setFourthImage(resultSet.getString("fourth_image"));
                image.setFifthImage(resultSet.getString("fifth_image"));
                images.add(image);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return images;
    }

    @Override
    public Image findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Image image) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Image image) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Image update(Image image) throws DAOException {
        throw new UnsupportedOperationException();
    }

}
