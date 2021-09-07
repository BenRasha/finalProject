package by.training.gallery.service.impl;

import by.training.gallery.dao.ImageDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.Image;
import by.training.gallery.service.ImageService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class ImageServiceImpl implements ImageService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Image> findAll() throws ServiceException {
        List<Image> images = new ArrayList<>();
        ImageDao image = (ImageDao) daoFactory.getImages();
        try {
            images.addAll(image.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return images;
    }

    @Override
    public Image findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Image> findImagesByMainImage(String patternMainImage) throws ServiceException {
        List<Image> images = new ArrayList<>();
        ImageDao image = (ImageDao) daoFactory.getImages();
        try {
            images.addAll(image.findImageByMainImage(patternMainImage));
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return images;
    }
}
