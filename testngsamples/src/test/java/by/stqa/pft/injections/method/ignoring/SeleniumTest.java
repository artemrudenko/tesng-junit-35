package by.stqa.pft.injections.method.ignoring;

/**
 * Created by artemr on 2/16/2017.
 */
import org.testng.annotations.Test;

import static by.stqa.pft.injections.method.ignoring.IgnoreInBrowser.Browser.CHROME;

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