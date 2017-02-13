package by.stqa.pft.quick.rules.chaining;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by artemr on 2/6/2017.
 */
public class SeleniumFixture {
  protected static WebDriver driver;

  public static ExternalResource driverRule = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      System.out.println("Starting a browser");
      driver = new ChromeDriver();
    }

    @Override
    protected void after() {
      System.out.println("Stopping browser");
      if (driver != null) {
        driver.quit();
      }
    }
  };

  public static ExternalResource loginRule = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      System.out.println("Login");
    }

    @Override
    protected void after() {
      System.out.println("Logout");
    }
  };

  @ClassRule
  public static RuleChain rules = RuleChain
          .outerRule(driverRule)
          .around(loginRule);
}

