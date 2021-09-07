package by.training.gallery.dao.factory;

import by.training.gallery.dao.BaseDao;
import by.training.gallery.dao.impl.*;

public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();
    private final BaseDao abstractPainting = new AbstractPaintingDaoImpl();
    private final BaseDao contemporaryPainting = new ContemporaryPaintingDaoImpl();
    private final BaseDao graphicPainting = new GraphicPaintingDaoImpl();
    private final BaseDao images = new ImageDaoImpl();
    private final BaseDao likePaintings = new LikedPaintingDaoImpl();
    private final BaseDao paintings = new PaintingDaoImpl();
    private final BaseDao realismPainting = new RealismPaintingDaoImpl();
    private final BaseDao sketches = new SketchDaoImpl();
    private final BaseDao users = new UserDaoImpl();
    private final BaseDao userInfo = new UserInfoDaoImpl();

    private DaoFactory() {}

    public static DaoFactory getInstance() {
        return instance;
    }

    public BaseDao getAbstractPainting() {
        return abstractPainting;
    }

    public BaseDao getContemporaryPainting() {
        return contemporaryPainting;
    }

    public BaseDao getGraphicPainting() {
        return graphicPainting;
    }

    public BaseDao getImages() {
        return images;
    }

    public BaseDao getLikePaintings() {
        return likePaintings;
    }

    public BaseDao getPaintings() {
        return paintings;
    }

    public BaseDao getRealismPainting() {
        return realismPainting;
    }

    public BaseDao getSketches() {
        return sketches;
    }

    public BaseDao getUsers() {
        return users;
    }

    public BaseDao getUserInfo() {
        return userInfo;
    }
}
