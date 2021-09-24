package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.User;

import java.util.List;

public abstract class UserDao extends AbstractDao<Integer, User> {

    public abstract List<User> findUserByLogin(String patternLogin) throws DAOException;

}
