package by.training.gallery.service.impl;

import by.training.gallery.dao.RealismPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.RealismPainting;
import by.training.gallery.service.RealismPaintingService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class RealismPaintingServiceImpl implements RealismPaintingService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<RealismPainting> findAll() throws ServiceException {
        List<RealismPainting> realismPaintings = new ArrayList<>();
        RealismPaintingDao realismPainting = (RealismPaintingDao) daoFactory.getRealismPainting();
        try {
            realismPaintings.addAll(realismPainting.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return realismPaintings;
    }

    @Override
    public RealismPainting findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<RealismPainting> findRealismPaintingByDate(String patternDate) throws ServiceException {
        List<RealismPainting> realismPaintings = new ArrayList<>();
        RealismPaintingDao realismPainting = (RealismPaintingDao) daoFactory.getRealismPainting();
        try {
            realismPaintings.addAll(realismPainting.findRealismPaintingByDate(patternDate));
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return realismPaintings;
    }
}
