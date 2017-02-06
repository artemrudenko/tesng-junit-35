package by.stqa.pft.quick.rules;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by artemr on 2/6/2017.
 */
public class SeleniumMethodFixture {
  protected WebDriver driver;

  @Rule
  public ExternalResource driverRule = new ExternalResource() {
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
}

