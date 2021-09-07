package by.training.gallery.service.impl;

import by.training.gallery.dao.GraphicPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.GraphicPainting;
import by.training.gallery.service.GraphicPaintingService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class GraphicPaintingServiceImpl implements GraphicPaintingService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<GraphicPainting> findAll() throws ServiceException {
        List<GraphicPainting> graphicPaintings = new ArrayList<>();
        GraphicPaintingDao graphicPainting = (GraphicPaintingDao) daoFactory.getGraphicPainting();
        try {
            graphicPaintings.addAll(graphicPainting.findAll());
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return graphicPaintings;
    }

    @Override
    public GraphicPainting findEntityById(Integer id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<GraphicPainting> findGraphicPaintingByDate(String patternDate) throws ServiceException {
        List<GraphicPainting> graphicPaintings = new ArrayList<>();
        GraphicPaintingDao graphicPainting = (GraphicPaintingDao) daoFactory.getContemporaryPainting();
        try {
            graphicPaintings.addAll(graphicPainting.findGraphicPaintingByDate(patternDate));
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return graphicPaintings;
    }
}
