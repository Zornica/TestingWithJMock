package MessageSystem;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class MessageValidatorImplTest {
  @Test
  public void Validate() {
    MessageValidatorImpl validator = new MessageValidatorImpl();
    Message message = new Message("ime", "title", "body");
    assertThat(validator.validate(message), is(true));

  }

  @Test
  public void ValidateWithOutName() {
    MessageValidatorImpl validator = new MessageValidatorImpl();
    Message message = new Message("", "title", "body");
    assertThat(validator.validate(message), is(false));

  }

  @Test
  public void ValidateWithOutTitle() {
    MessageValidatorImpl validator = new MessageValidatorImpl();
    Message message = new Message("ime", "", "body");
    assertThat(validator.validate(message), is(false));

  }

  @Test
  public void ValidateWithOutBody() {
    MessageValidatorImpl validator = new MessageValidatorImpl();
    Message message = new Message("ime", "title", "");
    assertThat(validator.validate(message), is(false));

  }

  @Test
  public void ValidateWithTooBigBody() {
    MessageValidatorImpl validator = new MessageValidatorImpl();
    Message message = new Message("", "title", "bodyhcfduos;djfckpsdkkl;kmjks;jk'vfop'aklsdkfksopaf'kaop'kad,lcvdfkvmopadfjkbvkdavjdf'pjbvko'[dfbofjjbk'fjbgi[gb'jofpdkmladp");
    assertThat(validator.validate(message), is(false));

  }
}
