package by.training.gallery.dao;

import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.Sketch;

import java.util.List;

public abstract class SketchDao extends AbstractDao<Integer, Sketch> {

    public abstract List<Sketch> findSketchesByTitle(String patternTitle) throws DAOException;
    public abstract List<Sketch> findSketchesByDate(String patternDate) throws DAOException;

}
