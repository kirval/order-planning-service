package orderplanning.application.service;

public class AddingCustomerException extends Exception {

    public AddingCustomerException() {
        super();
    }

    public AddingCustomerException(String message) {
        super(message);
    }

    public AddingCustomerException(String message, Throwable cause) {
        super(message, cause);
    }

}
