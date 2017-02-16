package by.stqa.pft.injections.method.paramsfixture;

/**
 * Created by artemr on 2/16/2017.
 */

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.selenium.factory.WebDriverPool;


public class SeleniumFixture {

  protected WebDriver driver;

  @BeforeClass
  public void startDriver() {
    driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
  }

  @BeforeMethod
  public void refreshDriver(Method m) {
    System.out.println("Before method " + m.getName());
    if (m.getAnnotation(NeedFreshDriver.class) != null) {
      System.out.println("Restarting the browser");
      WebDriverPool.DEFAULT.dismissDriver(driver);
      driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
    }
  }

  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    WebDriverPool.DEFAULT.dismissDriver(driver);
  }

}