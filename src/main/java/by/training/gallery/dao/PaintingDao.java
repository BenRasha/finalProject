package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Painting;

import java.util.List;

public abstract class PaintingDao extends AbstractDao<Integer, Painting> {

    public abstract List<Painting> findPaintingsByTitle(String patternTitle) throws DAOException;
    public abstract List<Painting> findPaintingsByStyle(String patternStyle) throws DAOException;
    public abstract List<Painting> findPaintingsBySize(String patternSize) throws DAOException;
    public abstract List<Painting> findPaintingsByMaterial(String patternMaterial) throws DAOException;
    public abstract List<Painting> findPaintingsByDate(String patternDate) throws DAOException;

}
