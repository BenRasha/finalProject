package by.training.gallery.service;

import by.training.gallery.entity.GraphicPainting;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface GraphicPaintingService extends BaseService<Integer, GraphicPainting> {

    public List<GraphicPainting> findGraphicPaintingByDate(String patternDate) throws ServiceException;

}
