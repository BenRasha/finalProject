package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.AbstractPainting;

import java.util.List;

public interface AbstractPaintingDao extends BaseDao<Integer, AbstractPainting> {

    public List<AbstractPainting> findAbstractPaintingByDate(String patternDate) throws DAOException;

}
