package by.stqa.pft.quick.rulesbehaviour.ignoring;

import org.junit.Test;

import static by.stqa.pft.quick.rulesbehaviour.ignoring.IgnoreInBrowser.Browser.*;

public class SeleniumTest extends SeleniumFixture {
  @Test
  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  @Test
  @IgnoreInBrowser(CHROME)
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
