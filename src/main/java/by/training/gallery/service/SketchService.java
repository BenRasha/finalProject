package by.training.gallery.service;

import by.training.gallery.entity.Sketch;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface SketchService extends BaseService<Integer, Sketch> {

    public List<Sketch> findSketchByTitle(String patternTitle) throws ServiceException;

}
