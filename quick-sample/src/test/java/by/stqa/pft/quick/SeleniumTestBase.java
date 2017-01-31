package by.stqa.pft.quick;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by artemr on 1/31/2017.
 */
public class SeleniumTestBase {
  protected WebDriver driver;
  @BeforeSuite(alwaysRun = true)
  public void startBrowser(){
    driver = new ChromeDriver();
  }

  @AfterSuite(alwaysRun = true)
  public void stopBrowser(){
    driver.quit();
  }
}
