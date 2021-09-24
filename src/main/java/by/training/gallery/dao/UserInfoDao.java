package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.UserInfo;

import java.util.List;

public abstract class UserInfoDao extends AbstractDao<Integer, UserInfo> {

    public abstract List<UserInfo> findInfoAboutUsersByEmail(String patternEmail) throws DAOException;
    public abstract List<UserInfo> findInfoAboutUsersByName(String patternName) throws DAOException;
    public abstract List<UserInfo> findInfoAboutUsersBySurname(String patternSurname) throws DAOException;
    public abstract List<UserInfo> findInfoAboutUsersByCity(String patternCity) throws DAOException;
    public abstract List<UserInfo> findInfoAboutUsersByStreet(String patternStreet) throws DAOException;
    public abstract List<UserInfo> findInfoAboutUsersByPhone(String patternPhone) throws DAOException;

}
