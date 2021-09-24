package by.training.gallery.dao.impl;

import by.training.gallery.dao.LikedPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.LikedPainting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LikedPaintingDaoImpl extends LikedPaintingDao {

    private static final String USER_ID_LABEL = "user_id";
    private static final String PAINTING_ID_LABEL = "painting_id";

    private static final String SQL_SELECT_ALL_LIKED_PAINTINGS
            = "SELECT user_id, painting_id FROM liked_paintings";
    private static final String SQL_SELECT_LIKED_PAINTINGS_BY_USER_ID
            = "SELECT user_id, painting_id FROM liked_paintings WHERE user_id = ?";
    private static final String SQL_DELETE_FROM_TABLE_BY_PAINTING_ID
            = "DELETE FROM liked_paintings WHERE painting_id = ?";
    private static final String SQL_CREATE_LIKED_PAINTING
            = "INSERT INTO liked_paintings(user_id, painting_id) VALUES(?, ?)";

    @Override
    public List<LikedPainting> findAll() throws DAOException {
        List<LikedPainting> likedPaintings = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_LIKED_PAINTINGS);
            while (resultSet.next()) {
                LikedPainting likedPainting = new LikedPainting();
                likedPainting.setUserId(resultSet.getInt(USER_ID_LABEL));
                likedPainting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
                likedPaintings.add(likedPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException();
        } finally {
            close(statement);
        }
        return likedPaintings;
    }

    @Override
    public LikedPainting findEntityById(Integer id) throws DAOException {
       LikedPainting likedPainting = new LikedPainting();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_LIKED_PAINTINGS_BY_USER_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                likedPainting.setUserId(resultSet.getInt(USER_ID_LABEL));
                likedPainting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return likedPainting;
    }

    @Override
    public void delete(Integer id) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_FROM_TABLE_BY_PAINTING_ID);
            statement.setString(1, String.valueOf(id));
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(LikedPainting entity) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public LikedPainting create(LikedPainting entity) throws DAOException {
        LikedPainting createdLikedPainting = new LikedPainting();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CREATE_LIKED_PAINTING, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(entity.getUserId()));
            statement.setString(2, String.valueOf(entity.getPaintingId()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                createdLikedPainting.setUserId(resultSet.getInt(USER_ID_LABEL));
                createdLikedPainting.setPaintingId(resultSet.getInt(PAINTING_ID_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return createdLikedPainting;
    }

}
