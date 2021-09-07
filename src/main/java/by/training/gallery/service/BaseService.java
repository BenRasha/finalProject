package by.training.gallery.service;

import by.training.gallery.entity.Entity;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface BaseService <K, T extends Entity> {

    List<T> findAll() throws ServiceException;
    T findEntityById(K id) throws ServiceException;

}
