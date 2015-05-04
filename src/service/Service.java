package service;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class Service {
  public final String age;
  private ServiceValidator validator;
  private DataBase dataBase;

  public Service(String age){
    this.age = age;
  }

  public Service(String age, ServiceValidator validator,DataBase dataBase) {
    this.age = age;
    this.validator = validator;
    this.dataBase = dataBase;
  }


  public boolean add() {
    if (!validator.validate(age)) {
      return false;
    }
    dataBase.add(age);
    return true;
  }
  public boolean isAdult() {
    if (Integer.parseInt(age) < 18) {
      return false;
    }

    return true;
  }
}
