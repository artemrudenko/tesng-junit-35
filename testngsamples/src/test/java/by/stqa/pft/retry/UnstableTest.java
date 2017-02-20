package by.stqa.pft.retry;

/**
 * Created by artemr on 2/20/2017.
 */

import org.junit.Assert;
import org.testng.annotations.Test;

public class UnstableTest {
  private static int attempt = 1;

  @Test(retryAnalyzer = RunUntilSuccess.class)
  public void randomlyFailingTest() {
    if (attempt == 3) {
      attempt = 1;
    } else {
      Assert.fail("Failed on " + (attempt++) + " attempt");
    }
  }
}