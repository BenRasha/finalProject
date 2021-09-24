package by.training.gallery.service;

import by.training.gallery.entity.FullPainting;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface PaintingService extends BaseService<Integer, FullPainting> {

    List<FullPainting> findPaintingsByTitle(String patternTitle) throws ServiceException;
    List<FullPainting> findPaintingsByStyle(String patternStyle) throws ServiceException;
    List<FullPainting> findPaintingsBySize(String patternSize) throws ServiceException;
    List<FullPainting> findPaintingsByMaterial(String patternMaterial) throws ServiceException;
    List<FullPainting> findPaintingsByDate(String patternDate) throws ServiceException;
}
