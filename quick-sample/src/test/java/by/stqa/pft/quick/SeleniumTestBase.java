package by.stqa.pft.quick;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

/**
 * Created by artemr on 1/31/2017.
 */
public class SeleniumTestBase {
  protected WebDriver driver;

  @BeforeTest(alwaysRun = true)
  @Parameters("browser")
  public void startBrowser(@Optional String browser) {
    if (browser.equals("chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equals("ie")) {
      driver = new InternetExplorerDriver();
    } else {
      throw new Error("unknown browser " + browser);
    }
  }

  @AfterTest(alwaysRun = true)
  public void stopBrowser() {
    if (driver != null) {
      driver.quit();
    }
  }
}
