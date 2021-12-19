package co.com.pruebatecnica.exceptions;

public class WebActionsException extends Exception{
    public WebActionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebActionsException(String message) {
        super(message);
    }
}
