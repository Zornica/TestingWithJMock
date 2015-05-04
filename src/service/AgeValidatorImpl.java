package service;

/**
 * Created by Zornitsa Petkova on 5/4/15.
 */
public class AgeValidatorImpl implements AgeValidator {
  @Override
  public boolean validate(User user) {
    if (Integer.parseInt(user.age) < 10 || Integer.parseInt(user.age) > 100) {
      return false;
    }
    return true;
  }
}