package by.epam.training.exception;

/**
 * The type User exists exception.
 */
public class UserExistsException extends Exception {

    /**
     * Instantiates a new User exists exception.
     *
     * @param message the message
     */
    public UserExistsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new User exists exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new User exists exception.
     *
     * @param cause the cause
     */
    public UserExistsException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new User exists exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public UserExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
