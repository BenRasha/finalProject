package by.training.gallery.service.impl;

import by.training.gallery.dao.UserInfoDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.UserInfo;
import by.training.gallery.service.UserInfoService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<UserInfo> findAll() throws ServiceException {
        List<UserInfo> userInfos = new ArrayList<>();
        UserInfoDao userInfo = (UserInfoDao) daoFactory.getUserInfo();
        try {
            userInfos.addAll(userInfo.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return userInfos;
    }

    @Override
    public UserInfo findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<UserInfo> findInfoAboutUserByName(String patternName) throws ServiceException {
        List<UserInfo> userInfos = new ArrayList<>();
        UserInfoDao userInfo = (UserInfoDao) daoFactory.getUserInfo();
        try {
            userInfos.addAll(userInfo.findInfoAboutUserByName(patternName));
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return userInfos;
    }
}
