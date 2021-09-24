package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.SketchPhoto;

import java.util.List;

public abstract class SketchPhotoDao extends AbstractDao<Integer, SketchPhoto> {

    public abstract List<SketchPhoto> findAllSketchesPhotosById(Integer id) throws DAOException;

}
