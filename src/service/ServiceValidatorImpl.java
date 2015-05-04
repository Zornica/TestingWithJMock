package service;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class ServiceValidatorImpl implements ServiceValidator {
  @Override
  public boolean validate(String age) {
    if (Integer.parseInt(age) < 10 || Integer.parseInt(age) > 100) {
      return false;
    }
    return true;
  }
}
