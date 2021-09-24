package by.training.gallery.service;

import by.training.gallery.entity.FullSketch;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface SketchService extends BaseService<Integer, FullSketch> {

    List<FullSketch> findSketchesByTitle(String patternTitle) throws ServiceException;
    List<FullSketch> findSketchesByDate(String patternDate) throws ServiceException;

}
