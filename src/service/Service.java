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

  public void sendInDataBase(Service age){
    if(!validator.validate(age)){return ;}
     dataBase.add(age);
  }
   public boolean isAdult(){
     if(Integer.parseInt(age) < 18){
       return false;
   }

     return true;
   }
}
