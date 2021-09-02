package by.training.gallery.dao.impl;

import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.LikedPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.LikedPainting;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LikedPaintingDaoImpl implements LikedPaintingDao {

    private static final String SQL_SELECT_ALL_LIKED_PAINTINGS
            = "SELECT liked_id, user_id, painting_id FROM liked_paintings";

    @Override
    public List<LikedPainting> findAll() throws DAOException {
        List<LikedPainting> likedPaintings = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_LIKED_PAINTINGS);
            while (resultSet.next()) {
                LikedPainting likedPainting = new LikedPainting();
                likedPainting.setLikedId(resultSet.getInt("liked_id"));
                likedPainting.setUserId(resultSet.getInt("user_id"));
                likedPainting.setPaintingId(resultSet.getInt("painting_id"));
                likedPaintings.add(likedPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return likedPaintings;
    }

    @Override
    public LikedPainting findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(LikedPainting likedPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(LikedPainting likedPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public LikedPainting update(LikedPainting likedPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

}
