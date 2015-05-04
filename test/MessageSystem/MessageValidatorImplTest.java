package MessageSystem;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class MessageValidatorImplTest {
  MessageValidatorImpl validator = new MessageValidatorImpl();

  @Test
  public void validate() {

    Message message = new Message("ime", "title", "body");
    assertThat(validator.validate(message), is(true));

  }

  @Test
  public void validateWithOutName() {

    Message message = new Message("", "title", "body");
    assertThat(validator.validate(message), is(false));

  }

  @Test
  public void validateWithOutTitle() {

    Message message = new Message("ime", "", "body");
    assertThat(validator.validate(message), is(false));

  }

  @Test
  public void validateWithOutBody() {

    Message message = new Message("ime", "title", "");
    assertThat(validator.validate(message), is(false));

  }

  @Test
  public void validateWithTooBigBody() {

    Message message = new Message("", "title", "bodyhcfduos;djfckpsdkkl;kmjks;jk'vfop'aklsdkfksopaf'kaop'kad,lcvdfkvmopadfjkbvkdavjdf'pjbvko'[dfbofjjbk'fjbgi[gb'jofpdkmladp");
    assertThat(validator.validate(message), is(false));

  }
}
