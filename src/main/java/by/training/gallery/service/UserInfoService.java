package by.training.gallery.service;

import by.training.gallery.entity.UserInfo;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface UserInfoService extends BaseService<Integer, UserInfo> {

    public List<UserInfo> findInfoAboutUserByName(String patternName) throws ServiceException;

}
