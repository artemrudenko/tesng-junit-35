package by.stqa.pft.interceptors.hookable;

/**
 * Created by artemr on 2/20/2017.
 */


import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(RunTwiceInterceptor.class)
public class UnstableTest {

  private static int attempt = 1;

  @Test
  public void randomlyFailingTest() {
    if (attempt == 3) {
      attempt = 1;
    } else {
      System.out.println("Ok");
      Assert.fail("Failed on " + (attempt++) + " attempt");
    }
  }

}