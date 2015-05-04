package service;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class ServiceTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  DataBase dataBase;

  @Mock
  ServiceValidator validator;

  @Test
  public void sendInDataBase() {
    final Service service = new Service("12", validator,dataBase);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(service.age);
        will(returnValue(true));

        oneOf(dataBase).add(service.age);
        will(returnValue(true));
      }
    });
    service.add();
  }

  @Test
  public void notSendInDataBase() {
    final Service service = new Service("9", validator,dataBase);
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(service.age);
        will(returnValue(false));

        never(dataBase).add(service.age);
      }
    });
    service.add();
  }

  @Test
  public void isNotAdult(){
    final Service service = new Service("12");
    assertThat(service.isAdult(), is (false));
  }

  @Test
  public void isAdult(){
    final Service service = new Service("18");
    assertThat(service.isAdult(), is (true));
  }
}
