package by.training.gallery.service.impl;

import by.training.gallery.dao.UserDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.User;
import by.training.gallery.service.UserService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<User> findAll() throws ServiceException {
        List<User> users = new ArrayList<>();
        UserDao user = (UserDao) daoFactory.getUsers();
        try {
            users.addAll(user.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return users;
    }

    @Override
    public User findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findUserByLogin(String patternLogin) throws ServiceException {
        List<User> users = new ArrayList<>();
        UserDao user = (UserDao) daoFactory.getUsers();
        try {
            users.addAll(user.findUserByLogin(patternLogin));
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return users;
    }
}
