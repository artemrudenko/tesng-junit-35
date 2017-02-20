package by.stqa.pft.listenerssample;

/**
 * Created by artemr on 2/20/2017.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ru.stqa.selenium.factory.WebDriverPool;
import com.automation.remarks.testng.VideoListener;

@Listeners(VideoListener.class)
public class MyTest {

  private WebDriver driver;

  @BeforeClass
  public void startDriver() {
    driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.firefox());
  }

  @Test
  public void test1() {
    driver.get("http://www.seleniumhq.org/");
  }

  @Test
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    WebDriverPool.DEFAULT.dismissDriver(driver);
  }

}