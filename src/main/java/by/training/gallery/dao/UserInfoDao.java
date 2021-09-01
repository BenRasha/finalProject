package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.UserInfo;

import java.util.List;

public interface UserInfoDao extends BaseDao <Integer, UserInfo> {

    List<UserInfo> findInfoAboutUserByName(String patternName) throws DAOException;

}
