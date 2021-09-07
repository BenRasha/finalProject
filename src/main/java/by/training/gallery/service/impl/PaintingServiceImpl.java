package by.training.gallery.service.impl;

import by.training.gallery.dao.PaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.Painting;
import by.training.gallery.service.PaintingService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class PaintingServiceImpl implements PaintingService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Painting> findAll() throws ServiceException {
        List<Painting> paintings = new ArrayList<>();
        PaintingDao painting = (PaintingDao) daoFactory.getPaintings();
        try {
            paintings.addAll(painting.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return paintings;
    }

    @Override
    public Painting findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Painting> findPaintingByTitle(String patternTitle) throws ServiceException {
        List<Painting> paintings = new ArrayList<>();
        PaintingDao painting = (PaintingDao) daoFactory.getPaintings();
        try {
            paintings.addAll(painting.findPaintingByTitle(patternTitle));
        } catch (DAOException exception) {
            throw new ServiceException();
        }
        return paintings;
    }
}
