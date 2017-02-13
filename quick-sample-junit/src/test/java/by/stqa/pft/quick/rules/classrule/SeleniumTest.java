package by.stqa.pft.quick.rules.classrule;

import by.stqa.pft.quick.rules.chaining.SeleniumFixture;
import org.junit.Test;

public class SeleniumTest extends SeleniumFixture {
  @Test
  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  @Test
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
