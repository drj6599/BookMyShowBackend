package dev.Dheeraj.BookMyShow.exception;

public class InvalidCityNameException extends RuntimeException {
    public InvalidCityNameException() {
    }

    public InvalidCityNameException(String message) {
        super(message);
    }

    public InvalidCityNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCityNameException(Throwable cause) {
        super(cause);
    }

    public InvalidCityNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
