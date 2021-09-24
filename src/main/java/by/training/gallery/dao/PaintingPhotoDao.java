package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.PaintingPhoto;

import java.util.List;

public abstract class PaintingPhotoDao extends AbstractDao<Integer, PaintingPhoto> {

    public abstract List<PaintingPhoto> findAllPaintingsPhotosByPaintingId(Integer id) throws DAOException;
}
