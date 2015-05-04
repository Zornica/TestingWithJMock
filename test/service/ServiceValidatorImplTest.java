package service;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class ServiceValidatorImplTest {


  @Test
  public void Validate() {
    ServiceValidatorImpl service = new ServiceValidatorImpl();
    Service age = new Service("12");
    assertThat(service.validate(age.age), is(true));
  }

  @Test
  public void ValidateToYoung() {
    ServiceValidatorImpl service = new ServiceValidatorImpl();
    Service age = new Service("9");
    assertThat(service.validate(age.age), is(false));
  }

  @Test
  public void ValidateTooOld() {
    ServiceValidatorImpl service = new ServiceValidatorImpl();
    Service age = new Service("102");
    assertThat(service.validate(age.age), is(false));
  }
}
