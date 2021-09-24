package by.training.gallery.service.impl;

import by.training.gallery.dao.EntityTransaction;
import by.training.gallery.dao.UserDao;
import by.training.gallery.dao.UserInfoDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.FullUser;
import by.training.gallery.entity.User;
import by.training.gallery.entity.UserInfo;
import by.training.gallery.service.UserService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<FullUser> findAll() throws ServiceException {
        List<FullUser> fullUsers = new ArrayList<>();
        List<User> users = new ArrayList<>();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            users.addAll(userDao.findAll());
            for (User user : users) {
                int userId = user.getUserId();
                UserInfo userInfo = userInfoDao.findEntityById(userId);
                fullUsers.add(new FullUser(user, userInfo));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullUsers;
    }

    @Override
    public FullUser findEntityById(Integer id) throws ServiceException {
        FullUser fullUser;
        User user;
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            user = userDao.findEntityById(id);
            int userId = user.getUserId();
            UserInfo userInfo = userInfoDao.findEntityById(userId);
            fullUser = new FullUser(user, userInfo);
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullUser;
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(userDao);
        try {
            userDao.delete(id);
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.end();
        }
    }

    @Override
    public void delete(FullUser entity) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(userDao);
        try {
            userDao.delete(entity.getUser());
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.end();
        }
    }

    @Override
    public FullUser create(FullUser entity) throws ServiceException {
        FullUser fullUser;
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            User user = userDao.create(entity.getUser());
            UserInfo userInfo = userInfoDao.create(entity.getUserInfo());
            fullUser = new FullUser(user, userInfo);
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullUser;
    }

    @Override
    public List<FullUser> findUsersByLogin(String patternLogin) throws ServiceException {
        List<FullUser> fullUsers = new ArrayList<>();
        List<User> users = new ArrayList<>();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            users.addAll(userDao.findUserByLogin(patternLogin));
            for (User user : users) {
                int userId = user.getUserId();
                UserInfo userInfo = userInfoDao.findEntityById(userId);
                fullUsers.add(new FullUser(user, userInfo));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullUsers;
    }

    @Override
    public List<FullUser> findUsersByEmail(String patternEmail) throws ServiceException {
        List<FullUser> fullUsers = new ArrayList<>();
        List<UserInfo> userInfos = new ArrayList<>();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            userInfos.addAll(userInfoDao.findInfoAboutUsersByEmail(patternEmail));
            for (UserInfo userInfo : userInfos) {
                int userId = userInfo.getUserId();
                User user = userDao.findEntityById(userId);
                fullUsers.add(new FullUser(user, userInfo));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        }
        return fullUsers;
    }

    @Override
    public List<FullUser> findUsersByName(String patternName) throws ServiceException {
        List<FullUser> fullUsers = new ArrayList<>();
        List<UserInfo> userInfos = new ArrayList<>();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            userInfos.addAll(userInfoDao.findInfoAboutUsersByName(patternName));
            for (UserInfo userInfo : userInfos) {
                int userId = userInfo.getUserId();
                User user = userDao.findEntityById(userId);
                fullUsers.add(new FullUser(user, userInfo));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        }
        return fullUsers;
    }

    @Override
    public List<FullUser> findUsersBySurname(String patternSurname) throws ServiceException {
        List<FullUser> fullUsers = new ArrayList<>();
        List<UserInfo> userInfos = new ArrayList<>();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            userInfos.addAll(userInfoDao.findInfoAboutUsersBySurname(patternSurname));
            for (UserInfo userInfo : userInfos) {
                int userId = userInfo.getUserId();
                User user = userDao.findEntityById(userId);
                fullUsers.add(new FullUser(user, userInfo));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        }
        return fullUsers;
    }

    @Override
    public List<FullUser> findUsersByCity(String patternCity) throws ServiceException {
        List<FullUser> fullUsers = new ArrayList<>();
        List<UserInfo> userInfos = new ArrayList<>();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            userInfos.addAll(userInfoDao.findInfoAboutUsersByCity(patternCity));
            for (UserInfo userInfo : userInfos) {
                int userId = userInfo.getUserId();
                User user = userDao.findEntityById(userId);
                fullUsers.add(new FullUser(user, userInfo));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        }
        return fullUsers;
    }

    @Override
    public List<FullUser> findUsersByStreet(String patternStreet) throws ServiceException {
        List<FullUser> fullUsers = new ArrayList<>();
        List<UserInfo> userInfos = new ArrayList<>();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            userInfos.addAll(userInfoDao.findInfoAboutUsersByStreet(patternStreet));
            for (UserInfo userInfo : userInfos) {
                int userId = userInfo.getUserId();
                User user = userDao.findEntityById(userId);
                fullUsers.add(new FullUser(user, userInfo));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        }
        return fullUsers;
    }

    @Override
    public List<FullUser> findUsersByPhone(String patternPhone) throws ServiceException {
        List<FullUser> fullUsers = new ArrayList<>();
        List<UserInfo> userInfos = new ArrayList<>();
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(userDao, userInfoDao);
        try {
            userInfos.addAll(userInfoDao.findInfoAboutUsersByPhone(patternPhone));
            for (UserInfo userInfo : userInfos) {
                int userId = userInfo.getUserId();
                User user = userDao.findEntityById(userId);
                fullUsers.add(new FullUser(user, userInfo));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        }
        return fullUsers;
    }
}
