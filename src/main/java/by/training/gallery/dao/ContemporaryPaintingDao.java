package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.ContemporaryPainting;

import java.util.List;

public interface ContemporaryPaintingDao extends BaseDao<Integer, ContemporaryPainting> {

    public List<ContemporaryPainting> findContemporaryPaintingByDate(String patternDate) throws DAOException;

}
