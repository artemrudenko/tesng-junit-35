package by.stqa.pft.interceptors.annotations;

/**
 * Created by artemr on 2/20/2017.
 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWithBug {

  @Test
  @Bug(5)
  public void testSomething() {
    Assert.assertEquals(2 * 2, 5);
  }

}