package by.training.gallery.service.impl;

import by.training.gallery.dao.ContemporaryPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.ContemporaryPainting;
import by.training.gallery.service.ContemporaryPaintingService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class ContemporaryPaintingServiceImpl implements ContemporaryPaintingService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<ContemporaryPainting> findAll() throws ServiceException {
        List<ContemporaryPainting> contemporaryPaintings = new ArrayList<>();
        ContemporaryPaintingDao contemporaryPainting = (ContemporaryPaintingDao) daoFactory.getContemporaryPainting();
        try {
            contemporaryPaintings.addAll(contemporaryPainting.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return contemporaryPaintings;
    }

    @Override
    public ContemporaryPainting findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ContemporaryPainting> findContemporaryPaintingByDate(String patternDate) throws ServiceException {
        List<ContemporaryPainting> contemporaryPaintings = new ArrayList<>();
        ContemporaryPaintingDao contemporaryPainting = (ContemporaryPaintingDao) daoFactory.getContemporaryPainting();
        try {
            contemporaryPaintings.addAll(contemporaryPainting.findContemporaryPaintingByDate(patternDate));
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return contemporaryPaintings;
    }
}
