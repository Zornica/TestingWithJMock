package service;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class ServiceValidatorImpl implements ServiceValidator {
  //private Service service;

  @Override
  public boolean validate(Service service) {
    if (Integer.parseInt(service.age) >= 10 || Integer.parseInt(service.age) <= 100) {
      return true;
    }
    return false;
  }
}
