package MessageSystem;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class MessageTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  Receiver receiver;

  @Mock
  MessageValidator validator;

  //Test method where everything is ok
  @Test
  public void HappyPath() {
    final Message message = new Message("ime", "title", "body");
    final Publisher publish = new Publisher(receiver, validator);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(message);
        will(returnValue(true));

        oneOf(receiver).send(message);
        will(returnValue(true));
      }
    });

    publish.send(message);
  }

  //Test method without parameter name
  @Test
  public void messageWithoutName() {
    final Message message = new Message("", "title", "body");
    final Publisher publish = new Publisher(receiver, validator);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(message);
        will(returnValue(false));

        never(receiver).send(message);
      }
    });

    publish.send(message);
  }

  //Test method without parameter title
  @Test
  public void messageWithoutTitle() {
    final Message message = new Message("ime", "", "body");
    final Publisher publish = new Publisher(receiver, validator);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(message);
        will(returnValue(false));

        never(receiver).send(message);
      }
    });

    publish.send(message);
  }

  // //Test method without parameter body
  @Test
  public void messageWithoutBody() {
    final Message message = new Message("ime", "title", "");
    final Publisher publish = new Publisher(receiver, validator);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(message);
        will(returnValue(false));

        never(receiver).send(message);
      }
    });

    publish.send(message);
  }

  //Test method with too large parameter body
  @Test
  public void messageWithTooBigBody() {
    final Message message = new Message("", "title", "bodyhcfduos;djfckpsdkkl;kmjks;jk'vfop'aklsdkfksopaf'kaop'kad,lcvdfkvmopadfjkbvkdavjdf'pjbvko'[dfbofjjbk'fjbgi[gb'jofpdkmladp");
    final Publisher publish = new Publisher(receiver, validator);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(message);
        will(returnValue(false));

        never(receiver).send(message);
      }
    });

    publish.send(message);
  }
}


