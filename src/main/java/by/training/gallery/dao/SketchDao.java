package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Sketch;

import java.util.List;

public interface SketchDao extends BaseDao<Integer, Sketch> {

    public List<Sketch> findSketchByTitle(String patternTitle) throws DAOException;

}
