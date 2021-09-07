package by.training.gallery.service;

import by.training.gallery.entity.RealismPainting;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface RealismPaintingService extends BaseService<Integer, RealismPainting> {

    public List<RealismPainting> findRealismPaintingByDate(String patternDate) throws ServiceException;

}
