package exceptions.ue.msg;

public class UserAlreadyExistsException extends MessengerException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
