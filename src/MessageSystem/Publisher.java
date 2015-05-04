package MessageSystem;


/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class Publisher {
  private Receiver receiver;
  private MessageValidator validator;

  //Constructor
  public Publisher(Receiver receiver, MessageValidator validator) {
    this.receiver = receiver;
    this.validator = validator;
  }

  //Checks is the sms is send
  public void send(Message message) {
    if (!validator.validate(message)) {
      return;
    }
    receiver.send(message);
  }
}
