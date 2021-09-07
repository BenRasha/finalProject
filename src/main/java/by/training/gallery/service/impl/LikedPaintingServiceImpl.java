package by.training.gallery.service.impl;

import by.training.gallery.dao.LikedPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.LikedPainting;
import by.training.gallery.service.LikedPaintingService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class LikedPaintingServiceImpl implements LikedPaintingService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<LikedPainting> findAll() throws ServiceException {
        List<LikedPainting> likedPaintings = new ArrayList<>();
        LikedPaintingDao likedPainting = (LikedPaintingDao) daoFactory.getLikePaintings();
        try {
            likedPaintings.addAll(likedPainting.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return likedPaintings;
    }

    @Override
    public LikedPainting findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}
