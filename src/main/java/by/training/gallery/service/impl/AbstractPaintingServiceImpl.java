package by.training.gallery.service.impl;

import by.training.gallery.dao.AbstractPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.AbstractPainting;
import by.training.gallery.service.AbstractPaintingService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class AbstractPaintingServiceImpl implements AbstractPaintingService {

    private DaoFactory daoFactory = DaoFactory.getInstance();


    @Override
    public List<AbstractPainting> findAbstractPaintingByDate(String patternDate) throws ServiceException {
        List<AbstractPainting> abstractPaintings = new ArrayList<>();
        AbstractPaintingDao abstractPainting = (AbstractPaintingDao) daoFactory.getAbstractPainting();
        try {
            abstractPaintings.addAll(abstractPainting.findAbstractPaintingByDate(patternDate));
        } catch (DAOException exception) {
            throw new ServiceException();
        }
        return abstractPaintings;
    }

    @Override
    public List<AbstractPainting> findAll() throws ServiceException {
        List<AbstractPainting> abstractPaintings = new ArrayList<>();
        AbstractPaintingDao abstractPainting = (AbstractPaintingDao) daoFactory.getAbstractPainting();
        try {
            abstractPaintings.addAll(abstractPainting.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return abstractPaintings;
    }

    @Override
    public AbstractPainting findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}
