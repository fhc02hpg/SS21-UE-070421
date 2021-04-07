package exceptions.ue.msg;

public class UserNotAdminException extends MessengerException {

    public UserNotAdminException(String message) {
        super(message);
    }

    public UserNotAdminException(String message, Throwable cause) {
        super(message, cause);
    }

}
