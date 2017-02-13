package by.stqa.pft.quick.rules.extractor;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Created by artemr on 2/13/2017.
 */
public class WebDriverRule extends ExternalResource {
  private WebDriver driver;
  private Capabilities capabilities;

  public WebDriverRule(Capabilities capabilities){
    this.capabilities = capabilities;
  }

  public WebDriver getDriver(){
    return driver;
  }

  @Override
  protected void before() throws Throwable {
    System.out.println("Starting a browser");
    driver = WebDriverPool.DEFAULT.getDriver(capabilities);
  }

  @Override
  protected void after() {
    System.out.println("Stopping browser");
    if (driver != null) {
      driver.quit();
    }
  }
}