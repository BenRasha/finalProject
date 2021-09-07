package by.training.gallery.service;

import by.training.gallery.entity.AbstractPainting;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface AbstractPaintingService extends BaseService<Integer, AbstractPainting> {

    List<AbstractPainting> findAbstractPaintingByDate(String patternDate) throws ServiceException;

}
