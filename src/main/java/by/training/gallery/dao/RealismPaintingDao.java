package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.RealismPainting;

import java.util.List;

public interface RealismPaintingDao extends BaseDao<Integer, RealismPainting> {

    public List<RealismPainting> findRealismPaintingByDate(String patternDate) throws DAOException;

}
