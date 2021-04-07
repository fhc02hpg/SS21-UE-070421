package exceptions.ue.msg;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessengerService {

    private Map<String,User> users = new HashMap<>();
    private List<Message> history = new ArrayList<>();

    public void registerUser(User user) throws UserAlreadyExistsException {
        if(users.containsKey(user.getName())) {
            throw new UserAlreadyExistsException("error: duplicate user");
        }
        users.put(user.getName(),user);
    }

    public void unregisterUser(User user) throws UserNotFoundException {
        if(!users.containsKey(user.getName())) {
            throw new UserNotFoundException("error: user unknown");
        }
        users.remove(user.getName());
    }

    public void sendDirectMessage(DirectMessage message)
        throws UserNotFoundException, UserOfflineException {

        if(!users.containsKey(message.getFrom().getName()) ||
            !users.containsKey(message.getTo().getName())) {
            throw new UserNotFoundException("error: either form or to user not present");
        }

        if(message.getTo().getStatus().equals(User.STATUS_OFFLINE)) {
            throw new UserOfflineException("error: recipient is currently offline!");
        }

        System.out.println("sending direct message: "+message);
        history.add(message);
    }

    public void sendBroadcastMessage(BroadcastMessage message) throws UserNotAdminException {
        if(!message.getFrom().isAdmin()) {
            throw new UserNotAdminException("error: broadcast message only possible for admin users");
        }

        System.out.println("sending broadcast message from "
            +message.getFrom() + " with text: "+message.getText());
        System.out.println("recipients:");
        for(User u : users.values()) {
            if (!u.equals(message.getFrom())) {
                System.out.println(" -> "+u.getName());
            }
        }
    }




}
