package by.training.gallery.service;

import by.training.gallery.entity.FullUser;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface UserService extends BaseService<Integer, FullUser> {

    List<FullUser> findUsersByLogin(String patternLogin) throws ServiceException;
    List<FullUser> findUsersByEmail(String patternEmail) throws ServiceException;
    List<FullUser> findUsersByName(String patternName) throws ServiceException;
    List<FullUser> findUsersBySurname(String patternSurname) throws ServiceException;
    List<FullUser> findUsersByCity(String patternCity) throws ServiceException;
    List<FullUser> findUsersByStreet(String patternStreet) throws ServiceException;
    List<FullUser> findUsersByPhone(String patternPhone) throws ServiceException;

}
