package service;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class Service {
  public final String age;
  private ServiceValidator validator;
  private DataBase dataBase;

  public Service(String age) {
    this.age = age;
  }


  public boolean isAdult() {
    if (Integer.parseInt(age) < 18) {
      return false;
    }

    return true;
  }
}
