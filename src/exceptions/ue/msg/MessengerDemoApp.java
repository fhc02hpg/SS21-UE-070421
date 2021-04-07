package exceptions.ue.msg;


import java.util.ArrayList;
import java.util.List;

public class MessengerDemoApp {

	public static void main(String[] args) {

		User u1 = new User("max", User.STATUS_ONLINE, true);
		System.out.println(u1);

		User u2 = new User("susi", User.STATUS_OFFLINE, true);
		System.out.println(u2);

		User u3 = new User("john", User.STATUS_ONLINE, false);
		System.out.println(u3);

		User u4 = new User("vera", User.STATUS_ONLINE, false);
		System.out.println(u4);

		MessengerService msgs = new MessengerService();

		//demo case 1: try user registrations
		try {
			msgs.registerUser(u1);
			msgs.registerUser(u2);
			msgs.registerUser(u3);
			//msgs.registerUser(u3);
			msgs.registerUser(u4);
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		}

		//demo case 2: message creation & sending
		try {
			Message m1 = new DirectMessage(u1, u3, "hi! how're u doing?");
			Message m2 = new DirectMessage(u3, u2, "can you help me please?");
			Message m3 = new DirectMessage(u4, u1, "Hast du einen Filmtipp für mich?");

			Message m4 = new BroadcastMessage(u2, "Java ist cool und macht Spaß");
			Message m5 = new BroadcastMessage(u3, "Ich bin hungrig und möchte nach Hause :)");
			//Message m6 = new DirectMessage(u4, u4, "Treffen wir aus auf virtuellen Kaffeetratsch?");

			//demo case 3: send all created messages
			List<Message> toSend = new ArrayList<>();
			toSend.add(m1);
			toSend.add(m2);
			toSend.add(m3);
			toSend.add(m4);
			toSend.add(m5);

			for(Message m : toSend) {
				try {
					if(m instanceof DirectMessage) {
						msgs.sendDirectMessage((DirectMessage) m);
					}
					if(m instanceof BroadcastMessage) {
						msgs.sendBroadcastMessage((BroadcastMessage)m);
					}
				} catch(MessengerException e) {
					System.out.println("error when sending message: "+e.getMessage());
				}
			}
		} catch (MessageToSelfException e) {
			e.printStackTrace();
		}

	}

}
