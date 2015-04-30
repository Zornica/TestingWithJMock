package MessageSystem;


/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class Publisher {
  private Receiver receiver;
  private MessageValidator validator;

  public Publisher(Receiver receiver, MessageValidator validator) {
    this.receiver = receiver;
    this.validator = validator;
  }

  public void send(Message message) {
    if (!validator.validate(message)) {
      return;
    }
    receiver.send(message);
  }
}
