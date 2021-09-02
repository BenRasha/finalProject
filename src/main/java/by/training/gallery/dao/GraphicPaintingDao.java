package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.GraphicPainting;

import java.util.List;

public interface GraphicPaintingDao extends BaseDao<Integer, GraphicPainting> {

    public List<GraphicPainting> findGraphicPaintingByDate(String patternDate) throws DAOException;

}
