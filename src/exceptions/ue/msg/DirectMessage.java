package exceptions.ue.msg;

public class DirectMessage extends Message {

  private User from;
  private User to;

  public DirectMessage(User from, User to, String text) throws MessageToSelfException {
    super(text);
    if(from.equals(to)) {
      throw new MessageToSelfException("error: direct message to yourself forbidden!");
    }
    this.from = from;
    this.to = to;
  }

  public User getFrom() {
    return from;
  }

  public User getTo() {
    return to;
  }

  @Override
  public String toString() {
    return "DirectMessage{" +
        "from=" + from +
        ", to=" + to +
        "} " + super.toString();
  }
}
