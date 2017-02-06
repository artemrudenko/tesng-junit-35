package by.stqa.pft.quick.parametrized;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(JUnitParamsRunner.class)
public class JUnitParamsTest {
  public static Object[][] users(){
    return new Object[][]{
            {"admin", "admin"},
            {"guest", "guest"}
    };
  }
  @Test
  @Parameters(method = "users")
  public void test1(String user, String password){
    System.out.println("test1");
  }

  @Test
  @Parameters({"2,2,3",
          "2,2,4",
          "2,2,5"})
  public void test2(int x, int y, int z){
    Assert.assertThat(x*y, is(z));
    System.out.println("X: " + x + " Y: "+ y + " Z: " + z);
  }

}
