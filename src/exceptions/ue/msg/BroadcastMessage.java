package exceptions.ue.msg;

public class BroadcastMessage extends Message {

  private User from;

  public BroadcastMessage(User from,String text ) {
    super(text);
    this.from = from;
  }

  public User getFrom() {
    return from;
  }

}
