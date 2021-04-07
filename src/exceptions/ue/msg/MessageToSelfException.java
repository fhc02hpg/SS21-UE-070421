package exceptions.ue.msg;

public class MessageToSelfException extends  MessengerException {

    public MessageToSelfException(String message) {
        super(message);
    }

    public MessageToSelfException(String message, Throwable cause) {
        super(message, cause);
    }
}
