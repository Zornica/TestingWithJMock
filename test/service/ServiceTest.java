package service;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;


/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class ServiceTest {


  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  DataBase dataBase;

  @Mock
  AgeValidator validator;


  @Test
  public void sendInDataBase() {
    final User user = new User("12");
    final UserRepository service = new UserRepository(user, validator, dataBase);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(user);
        will(returnValue(true));

        oneOf(dataBase).add(user);
        will(returnValue(true));
      }
    });
    service.register(user);
  }

  @Test
  public void notSendInDataBase() {
    final User user = new User("9");
    final UserRepository service = new UserRepository(user, validator, dataBase);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(user);
        will(returnValue(false));

        never(dataBase).add(user);
      }
    });
    service.register(user);
  }


}
