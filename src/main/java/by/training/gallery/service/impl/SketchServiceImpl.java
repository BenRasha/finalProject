package by.training.gallery.service.impl;

import by.training.gallery.dao.SketchDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.Sketch;
import by.training.gallery.service.SketchService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class SketchServiceImpl implements SketchService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Sketch> findAll() throws ServiceException {
        List<Sketch> sketches = new ArrayList<>();
        SketchDao sketch = (SketchDao) daoFactory.getSketches();
        try {
            sketches.addAll(sketch.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return sketches;
    }

    @Override
    public Sketch findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Sketch> findSketchByTitle(String patternTitle) throws ServiceException {
        List<Sketch> sketches = new ArrayList<>();
        SketchDao sketch = (SketchDao) daoFactory.getSketches();
        try {
            sketches.addAll(sketch.findSketchByTitle(patternTitle));
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return sketches;
    }
}
