package by.training.gallery.dao.impl;

import by.training.gallery.dao.ConnectionCreator;
import by.training.gallery.dao.GraphicPaintingDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.entity.GraphicPainting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicPaintingDaoImpl implements GraphicPaintingDao {

    private static final String SQL_SELECT_ALL_GRAPHIC_PAINTINGS_BY_DATE
            = "SELECT painting_id, gr_size, image_id, gr_material FROM graphic_paintings WHERE gr_date=?";
    private static final String SQL_SELECT_ALL_GRAPHIC_PAINTINGS
            = "SELECT painting_id, gr_size, image_id, gr_material, gr_date FROM graphic_paintings";

    @Override
    public List<GraphicPainting> findGraphicPaintingByDate(String patternDate) throws DAOException {
        List<GraphicPainting> graphicPaintings = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_GRAPHIC_PAINTINGS_BY_DATE);
            statement.setString(1, patternDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                GraphicPainting graphicPainting = new GraphicPainting();
                graphicPainting.setPaintingId(resultSet.getInt("painting_id"));
                graphicPainting.setSize(resultSet.getString("gr_size"));
                graphicPainting.setImageId(resultSet.getInt("image_id"));
                graphicPainting.setMaterial(resultSet.getString("gr_material"));
                graphicPainting.setDate(resultSet.getDate("gr_date"));
                graphicPaintings.add(graphicPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return graphicPaintings;
    }

    @Override
    public List<GraphicPainting> findAll() throws DAOException {
        List<GraphicPainting> graphicPaintings = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_GRAPHIC_PAINTINGS);
            while (resultSet.next()) {
                GraphicPainting graphicPainting = new GraphicPainting();
                graphicPainting.setPaintingId(resultSet.getInt("painting_id"));
                graphicPainting.setSize(resultSet.getString("gr_size"));
                graphicPainting.setImageId(resultSet.getInt("image_id"));
                graphicPainting.setMaterial(resultSet.getString("gr_material"));
                graphicPainting.setDate(resultSet.getDate("gr_date"));
                graphicPaintings.add(graphicPainting);
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        } finally {
            close(statement);
            close(connection);
        }
        return graphicPaintings;
    }

    @Override
    public GraphicPainting findEntityById(Integer id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(GraphicPainting graphicPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(GraphicPainting graphicPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public GraphicPainting update(GraphicPainting graphicPainting) throws DAOException {
        throw new UnsupportedOperationException();
    }

}
