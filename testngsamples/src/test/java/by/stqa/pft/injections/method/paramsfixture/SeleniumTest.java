package by.stqa.pft.injections.method.paramsfixture;

/**
 * Created by artemr on 2/16/2017.
 */

import org.testng.annotations.Test;

public class SeleniumTest extends SeleniumFixture {

  @Test
  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  @Test
  @NeedFreshDriver
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}