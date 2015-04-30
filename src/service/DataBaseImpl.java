package service;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class DataBaseImpl implements DataBase {
  ServiceValidator validator;

  @Override
  public boolean add(Service age) {
    if (!validator.validate(age)) {
      return false;
    }
    return true;
  }
}
