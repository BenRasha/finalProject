package by.training.gallery.service;

import by.training.gallery.entity.Painting;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface PaintingService extends BaseService<Integer, Painting> {

    public List<Painting> findPaintingByTitle(String patternTitle) throws ServiceException;

}
