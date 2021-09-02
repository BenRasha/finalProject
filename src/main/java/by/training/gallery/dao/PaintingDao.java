package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Painting;

import java.util.List;

public interface PaintingDao extends BaseDao<Integer, Painting> {

    public List<Painting> findPaintingByTitle(String patternTitle) throws DAOException;

}
