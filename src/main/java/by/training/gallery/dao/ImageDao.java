package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Image;

import java.util.List;

public interface ImageDao extends BaseDao<Integer, Image> {

    public List<Image> findImageByMainImage(String patternMainImage) throws DAOException;

}
