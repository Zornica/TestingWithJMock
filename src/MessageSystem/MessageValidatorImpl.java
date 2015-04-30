package MessageSystem;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class MessageValidatorImpl implements MessageValidator {

  @Override
  public boolean validate(Message message) {
    if ("".equals(message.name) || "".equals(message.title) || "".equals(message.body) || message.body.length() > 120) {
      return false;
    }
    return true;
  }
}
