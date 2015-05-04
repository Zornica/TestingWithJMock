package service;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class UserRepository {
  public  User user;
  private AgeValidator validator;
  private DataBase dataBase;



  //Constructor with three parameters
  public UserRepository(User user, AgeValidator validator, DataBase dataBase) {
    this.user = user;
    this.validator = validator;
    this.dataBase = dataBase;
  }


  //Checks is the age register in dataBase
  public boolean register(User user) {
    if (!validator.validate(user)) {
      return false;
    }
    dataBase.add(user);
    return true;
  }

}
