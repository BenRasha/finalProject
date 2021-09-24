package by.training.gallery.dao.impl;

import by.training.gallery.dao.UserInfoDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.UserInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDaoImpl extends UserInfoDao {

    private static final String USER_ID_LABEL = "user_id";
    private static final String EMAIL_LABEL = "email";
    private static final String NAME_LABEL = "name";
    private static final String SURNAME_LABEL = "surname";
    private static final String CITY_LABEL = "city";
    private static final String STREET_LABEL = "street";
    private static final String PHONE_LABEL = "phone";

    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS
            = "SELECT user_id, email, name, surname, city, street, phone FROM users_info";
    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_ID
            = "SELECT user_id, email, name, surname, city, street, phone FROM users_info WHERE user_id = ?";
    private static final String SQL_DELETE_INFO_ABOUT_USERS_BY_ID
            = "DELETE FROM users_info WHERE user_id = ?";
    private static final String SQL_DELETE_INFO_ABOUT_USERS_BY_NAME
            = "DELETE FROM users_info WHERE name = ?";
    private static final String SQL_INSERT_INTO_USERS_INFO
            = "INSERT INTO users_info(user_id, email, name, surname, city, street, phone) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_EMAIL
            = "SELECT user_id, email, name, surname, city, street, phone FROM users_info WHERE email = ?";
    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_NAME
            = "SELECT user_id, email, name, surname, city, street, phone FROM users_info WHERE name = ?";
    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_SURNAME
            = "SELECT user_id, email, name, surname, city, street, phone FROM users_info WHERE surname = ?";
    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_CITY
            = "SELECT user_id, email, name, surname, city, street, phone FROM users_info WHERE city = ?";
    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_STREET
            = "SELECT user_id, email, name, surname, city, street, phone FROM users_info WHERE street = ?";
    private static final String SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_PHONE
            = "SELECT user_id, email, name, surname, city, street, phone FROM users_info WHERE phone = ?";

    @Override
    public List<UserInfo> findAll() throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_INFO_ABOUT_USERS);
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt(USER_ID_LABEL));
                userInfo.setEmail(resultSet.getString(EMAIL_LABEL));
                userInfo.setName(resultSet.getString(NAME_LABEL));
                userInfo.setSurname(resultSet.getString(SURNAME_LABEL));
                userInfo.setCity(resultSet.getString(CITY_LABEL));
                userInfo.setStreet(resultSet.getString(STREET_LABEL));
                userInfo.setPhone(resultSet.getString(PHONE_LABEL));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return userInfos;
    }

    @Override
    public UserInfo findEntityById(Integer id) throws DAOException {
        UserInfo userInfo = new UserInfo();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userInfo.setUserId(resultSet.getInt(USER_ID_LABEL));
                userInfo.setEmail(resultSet.getString(EMAIL_LABEL));
                userInfo.setName(resultSet.getString(NAME_LABEL));
                userInfo.setSurname(resultSet.getString(SURNAME_LABEL));
                userInfo.setCity(resultSet.getString(CITY_LABEL));
                userInfo.setStreet(resultSet.getString(STREET_LABEL));
                userInfo.setPhone(resultSet.getString(PHONE_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return userInfo;
    }

    @Override
    public void delete(Integer id) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_INFO_ABOUT_USERS_BY_ID, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(id));
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public void delete(UserInfo entity) throws DAOException {
        String userName = entity.getName();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_INFO_ABOUT_USERS_BY_NAME, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userName);
            statement.executeQuery();
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
    }

    @Override
    public UserInfo create(UserInfo entity) throws DAOException {
        UserInfo createdInfoAboutUser = new UserInfo();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_INTO_USERS_INFO, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(entity.getUserId()));
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getName());
            statement.setString(4, entity.getSurname());
            statement.setString(5, entity.getCity());
            statement.setString(6, entity.getStreet());
            statement.setString(7, entity.getPhone());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                createdInfoAboutUser.setUserId(resultSet.getInt(USER_ID_LABEL));
                createdInfoAboutUser.setEmail(resultSet.getString(EMAIL_LABEL));
                createdInfoAboutUser.setName(resultSet.getString(NAME_LABEL));
                createdInfoAboutUser.setSurname(resultSet.getString(SURNAME_LABEL));
                createdInfoAboutUser.setCity(resultSet.getString(CITY_LABEL));
                createdInfoAboutUser.setStreet(resultSet.getString(STREET_LABEL));
                createdInfoAboutUser.setPhone(resultSet.getString(PHONE_LABEL));
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return createdInfoAboutUser;
    }

    @Override
    public List<UserInfo> findInfoAboutUsersByEmail(String patternEmail) throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_EMAIL, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternEmail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt(USER_ID_LABEL));
                userInfo.setEmail(resultSet.getString(EMAIL_LABEL));
                userInfo.setName(resultSet.getString(NAME_LABEL));
                userInfo.setSurname(resultSet.getString(SURNAME_LABEL));
                userInfo.setCity(resultSet.getString(CITY_LABEL));
                userInfo.setStreet(resultSet.getString(STREET_LABEL));
                userInfo.setPhone(resultSet.getString(PHONE_LABEL));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        }  finally {
            close(statement);
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> findInfoAboutUsersByName(String patternName) throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_NAME, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt(USER_ID_LABEL));
                userInfo.setEmail(resultSet.getString(EMAIL_LABEL));
                userInfo.setName(resultSet.getString(NAME_LABEL));
                userInfo.setSurname(resultSet.getString(SURNAME_LABEL));
                userInfo.setCity(resultSet.getString(CITY_LABEL));
                userInfo.setStreet(resultSet.getString(STREET_LABEL));
                userInfo.setPhone(resultSet.getString(PHONE_LABEL));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        }  finally {
            close(statement);
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> findInfoAboutUsersBySurname(String patternSurname) throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_SURNAME, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternSurname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt(USER_ID_LABEL));
                userInfo.setEmail(resultSet.getString(EMAIL_LABEL));
                userInfo.setName(resultSet.getString(NAME_LABEL));
                userInfo.setSurname(resultSet.getString(SURNAME_LABEL));
                userInfo.setCity(resultSet.getString(CITY_LABEL));
                userInfo.setStreet(resultSet.getString(STREET_LABEL));
                userInfo.setPhone(resultSet.getString(PHONE_LABEL));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> findInfoAboutUsersByCity(String patternCity) throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_CITY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternCity);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt(USER_ID_LABEL));
                userInfo.setEmail(resultSet.getString(EMAIL_LABEL));
                userInfo.setName(resultSet.getString(NAME_LABEL));
                userInfo.setSurname(resultSet.getString(SURNAME_LABEL));
                userInfo.setCity(resultSet.getString(CITY_LABEL));
                userInfo.setStreet(resultSet.getString(STREET_LABEL));
                userInfo.setPhone(resultSet.getString(PHONE_LABEL));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> findInfoAboutUsersByStreet(String patternStreet) throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_STREET, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternStreet);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt(USER_ID_LABEL));
                userInfo.setEmail(resultSet.getString(EMAIL_LABEL));
                userInfo.setName(resultSet.getString(NAME_LABEL));
                userInfo.setSurname(resultSet.getString(SURNAME_LABEL));
                userInfo.setCity(resultSet.getString(CITY_LABEL));
                userInfo.setStreet(resultSet.getString(STREET_LABEL));
                userInfo.setPhone(resultSet.getString(PHONE_LABEL));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> findInfoAboutUsersByPhone(String patternPhone) throws DAOException {
        List<UserInfo> userInfos = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_INFO_ABOUT_USERS_BY_PHONE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patternPhone);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt(USER_ID_LABEL));
                userInfo.setEmail(resultSet.getString(EMAIL_LABEL));
                userInfo.setName(resultSet.getString(NAME_LABEL));
                userInfo.setSurname(resultSet.getString(SURNAME_LABEL));
                userInfo.setCity(resultSet.getString(CITY_LABEL));
                userInfo.setStreet(resultSet.getString(STREET_LABEL));
                userInfo.setPhone(resultSet.getString(PHONE_LABEL));
                userInfos.add(userInfo);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
        }
        return userInfos;
    }
}
