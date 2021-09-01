package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.User;

import java.util.List;

public interface UserDao extends BaseDao <Integer, User> {

    List<User> findUserByLogin(String patternLogin) throws DAOException;

}
