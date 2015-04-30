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
  ServiceValidator validator;

  @Test
  public void SendInDataBase() {
    final Service service = new Service("12");
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(service);
        will(returnValue(true));

        oneOf(dataBase).add(service);
        will(returnValue(true));
      }
    });
    dataBase.add(service);
  }
}
