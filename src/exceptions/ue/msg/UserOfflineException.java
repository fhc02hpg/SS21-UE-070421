package exceptions.ue.msg;

public class UserOfflineException extends  MessengerException{

    public UserOfflineException(String message) {
        super(message);
    }

    public UserOfflineException(String message, Throwable cause) {
        super(message, cause);
    }

}
