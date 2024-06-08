package dev.Dheeraj.BookMyShow.exception;

public class SeatNotAvailableException extends RuntimeException {
    public SeatNotAvailableException() {
    }

    public SeatNotAvailableException(String message) {
        super(message);
    }

    public SeatNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeatNotAvailableException(Throwable cause) {
        super(cause);
    }

    public SeatNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
