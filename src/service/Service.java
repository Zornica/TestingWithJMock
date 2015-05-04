package service;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class Service {
  public final String age;
  private ServiceValidator validator;
  private DataBase dataBase;

  //Constructor with one parameter
  public Service(String age) {
    this.age = age;
  }

  //Constructor with three parameters
  public Service(String age, ServiceValidator validator, DataBase dataBase) {
    this.age = age;
    this.validator = validator;
    this.dataBase = dataBase;
  }


  //Checks is the age add in dataBase
  public boolean add() {
    if (!validator.validate(age)) {
      return false;
    }
    dataBase.add(age);
    return true;
  }

}
