package by.training.gallery.dao.impl;

import by.training.gallery.dao.UserDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends UserDao {

    private static final String USER_ID_LABEL = "id";
    private static final String LOGIN_LABEL = "login";
    private static final String PASSWORD_LABEL = "password";
    private static final String ROLE_LABEL = "role";

    private static final String SQL_SELECT_ALL_USERS =
            "SELECT id, login, password, role FROM users";
    private static final String SQL_SELECT_ALL_USERS_BY_ID =
            "SELECT id, login, password, role FROM users WHERE id = ?";
    private static final String SQL_SELECT_ALL_USERS_BY_LOGIN =
            "SELECT id, login, password, role FROM users WHERE login=?";
    private static final String SQL_DELETE_USER_BY_ID =
            "DELETE FROM users WHERE id = ?";
    private static final String SQL_INSERT_INTO_USERS =
            "INSERT INTO users(id, login, password, role) VALUES(?, ?, ?, ?)";


    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt(USER_ID_LABEL));
                user.setLogin(resultSet.getString(LOGIN_LABEL));
                user.setPassword(resultSet.getString(PASSWORD_LABEL));
                user.setRole(resultSet.getInt(ROLE_LABEL));
                users.add(user);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return users;
    }

    @Override
    public User findEntityById(Integer id) throws DAOException {
        User user = new User();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_USERS_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt(USER_ID_LABEL));
                user.setLogin(resultSet.getString(LOGIN_LABEL));
                user.setPassword(resultSet.getString(PASSWORD_LABEL));
                user.setRole(resultSet.getInt(ROLE_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return user;
    }

    @Override
    public void delete(User entity) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer id) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setString(1, String.valueOf(id));
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public User create(User user) throws DAOException {
        User createdUser = new User();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(user.getUserId()));
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, String.valueOf(user.getRole().getValue()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                createdUser.setUserId(resultSet.getInt(USER_ID_LABEL));
                createdUser.setLogin(resultSet.getString(LOGIN_LABEL));
                createdUser.setPassword(resultSet.getString(PASSWORD_LABEL));
                createdUser.setRole(resultSet.getInt(ROLE_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return createdUser;
    }

    @Override
    public List<User> findUserByLogin(String patternLogin) throws DAOException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_USERS_BY_LOGIN, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternLogin);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt(USER_ID_LABEL));
                user.setLogin(resultSet.getString(LOGIN_LABEL));
                user.setPassword(resultSet.getString(PASSWORD_LABEL));
                user.setRole(resultSet.getInt(ROLE_LABEL));
                users.add(user);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return users;
    }
}
