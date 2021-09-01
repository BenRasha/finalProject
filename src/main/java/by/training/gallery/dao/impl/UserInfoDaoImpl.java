package by.training.gallery.dao.impl;

import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.UserInfoDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {

    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS
            = "SELECT user_id, email, name, surname, address, phone FROM users_info";
    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_NAME
            = "SELECT user_id, email, surname, address, phone FROM users_info WHERE name=?";

    @Override
    public List<UserInfo> findInfoAboutUserByName(String patternName) throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_NAME);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt("user_id"));
                userInfo.setEmail(resultSet.getString("email"));
                userInfo.setName(resultSet.getString("name"));
                userInfo.setSurname(resultSet.getString("surname"));
                userInfo.setAddress(resultSet.getString("address"));
                userInfo.setPhone(resultSet.getString("phone"));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> findAll() throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_INFO_ABOUT_USERS);
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt("user_id"));
                userInfo.setEmail(resultSet.getString("email"));
                userInfo.setName(resultSet.getString("name"));
                userInfo.setSurname(resultSet.getString("surname"));
                userInfo.setAddress(resultSet.getString("address"));
                userInfo.setPhone(resultSet.getString("phone"));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return userInfos;
    }

    @Override
    public UserInfo findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(UserInfo userInfo) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(UserInfo userInfo) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserInfo update(UserInfo userInfo) throws DAOException {
        throw new UnsupportedOperationException();
    }

}
