package by.training.gallery.service.factory;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }
}
