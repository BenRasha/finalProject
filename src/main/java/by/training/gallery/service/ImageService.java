package by.training.gallery.service;

import by.training.gallery.entity.Image;
import by.training.gallery.service.exception.ServiceException;

import java.util.List;

public interface ImageService extends BaseService<Integer, Image> {

    public List<Image> findImagesByMainImage(String patternMainImage) throws ServiceException;

}
