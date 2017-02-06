package by.stqa.pft.quick.parametrized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(Parameterized.class)
public class ParametersFieldsTest {
  @Parameters(name = "user: {0}, password: {1}")
  public static Collection<Object[]> users(){
    return Arrays.asList(new Object[][]{
            {"admin", "admin"},
            {"guest", "guest"}
    });
  }

  @Parameter(0)
  public String user;
  @Parameter(1)
  public String password;

  @Test
  public void testLogin(){
    System.out.println("User name: " + user);
    System.out.println("User password: " + password);
  }

}
