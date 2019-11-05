package by.epam.training.exception;

public class ComandException extends Exception {
    public ComandException() {
    }

    public ComandException(String message) {
        super(message);
    }

    public ComandException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComandException(Throwable cause) {
        super(cause);
    }
}
