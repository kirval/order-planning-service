package orderplanning.application.service;

public class OrderPlacingException extends Exception {

    public OrderPlacingException() {
        super();
    }

    public OrderPlacingException(String message) {
        super(message);
    }

    public OrderPlacingException(String message, Throwable cause) {
        super(message, cause);
    }

}
