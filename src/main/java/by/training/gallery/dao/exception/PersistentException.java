package by.training.gallery.dao.exception;

public class PersistentException extends Exception {

    public PersistentException() {}

    public PersistentException(String message) {
        super(message);
    }

    public PersistentException(Exception exception) {
        super(exception);
    }

    public PersistentException(String message, Exception exception) {
        super(message, exception);
    }

}
