package by.training.gallery.service;

import by.training.gallery.entity.ContemporaryPainting;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface ContemporaryPaintingService extends BaseService<Integer, ContemporaryPainting> {

    List<ContemporaryPainting> findContemporaryPaintingByDate(String patternDate) throws ServiceException;

}
