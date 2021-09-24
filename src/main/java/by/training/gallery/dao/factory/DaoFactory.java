package by.training.gallery.dao.factory;

import by.training.gallery.dao.*;
import by.training.gallery.dao.impl.*;

public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();
    private final UserDao userDao = new UserDaoImpl();
    private final UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private final PaintingDao paintingDao = new PaintingDaoImpl();
    private final SketchDao sketchDao = new SketchDaoImpl();
    private final SketchPhotoDao sketchPhotoDao = new SketchPhotoDaoImpl();
    private final PaintingPhotoDao paintingPhotoDao = new PaintingPhotoDaoImpl();
    private final LikedPaintingDao likedPaintingDao = new LikedPaintingDaoImpl();

    private DaoFactory() {}

    public static DaoFactory getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        return  userDao;
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public PaintingDao getPaintingDao() {
        return paintingDao;
    }

    public SketchDao getSketchDao() {
        return sketchDao;
    }

    public SketchPhotoDao getSketchPhotoDao() {
        return sketchPhotoDao;
    }

    public PaintingPhotoDao getPaintingPhotoDao() {
        return paintingPhotoDao;
    }

    public LikedPaintingDao getLikedPaintingDao() {
        return likedPaintingDao;
    }
}
