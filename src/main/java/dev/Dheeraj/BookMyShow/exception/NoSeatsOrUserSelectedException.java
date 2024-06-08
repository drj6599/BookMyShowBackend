package dev.Dheeraj.BookMyShow.exception;

public class NoSeatsOrUserSelectedException extends RuntimeException {
    public NoSeatsOrUserSelectedException() {
    }

    public NoSeatsOrUserSelectedException(String message) {
        super(message);
    }

    public NoSeatsOrUserSelectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSeatsOrUserSelectedException(Throwable cause) {
        super(cause);
    }

    public NoSeatsOrUserSelectedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
