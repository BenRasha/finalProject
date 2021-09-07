package by.training.gallery.service;

import by.training.gallery.entity.User;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface UserService extends BaseService<Integer, User> {

    public List<User> findUserByLogin(String patternLogin) throws ServiceException;

}
