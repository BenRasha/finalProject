package by.training.gallery.service.factory;

import by.training.gallery.service.BaseService;
import by.training.gallery.service.impl.*;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final BaseService abstractPainting = new AbstractPaintingServiceImpl();
    private final BaseService contemporaryPainting = new ContemporaryPaintingServiceImpl();
    private final BaseService graphicPainting = new GraphicPaintingServiceImpl();
    private final BaseService image = new ImageServiceImpl();
    private final BaseService likedPainting = new LikedPaintingServiceImpl();
    private final BaseService painting = new PaintingServiceImpl();
    private final BaseService realismPainting = new RealismPaintingServiceImpl();
    private final BaseService sketch = new SketchServiceImpl();
    private final BaseService user = new UserServiceImpl();
    private final BaseService userInfo = new UserInfoServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public BaseService getAbstractPainting() {
        return abstractPainting;
    }

    public BaseService getContemporaryPainting() {
        return contemporaryPainting;
    }

    public BaseService getGraphicPainting() {
        return graphicPainting;
    }

    public BaseService getImage() {
        return image;
    }

    public BaseService getLikedPainting() {
        return likedPainting;
    }

    public BaseService getPainting() {
        return painting;
    }

    public BaseService getRealismPainting() {
        return realismPainting;
    }

    public BaseService getSketch() {
        return sketch;
    }

    public BaseService getUser() {
        return user;
    }

    public BaseService getUserInfo() {
        return userInfo;
    }
}
