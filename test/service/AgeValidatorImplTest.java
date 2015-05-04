package service;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class AgeValidatorImplTest {
  AgeValidatorImpl service = new AgeValidatorImpl();

  @Test
  public void validate() {
    User user = new User("12");
    assertThat(service.validate(user), is(true));
  }

  @Test
  public void validateToYoung() {
    User user = new User("9");
    assertThat(service.validate(user), is(false));
  }

  @Test
  public void validateTooOld() {
    User user = new User("102");
    assertThat(service.validate(user), is(false));
  }
}
