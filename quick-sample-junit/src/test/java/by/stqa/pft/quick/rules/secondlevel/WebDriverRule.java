package by.stqa.pft.quick.rules.secondlevel;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.*;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.List;
import java.util.Set;

/**
 * Created by artemr on 2/13/2017.
 */
public class WebDriverRule extends ExternalResource implements WebDriver, TakesScreenshot{
  private Capabilities capabilities;

  public WebDriverRule(Capabilities capabilities){
    this.capabilities = capabilities;
  }

  private WebDriver driver;

  @Override
  protected void before() throws Throwable{
    System.out.println("Starting a browser");
    driver = WebDriverPool.DEFAULT.getDriver(capabilities);
  }

  @Override
  protected void after(){
    System.out.println("Stopping browser");
    if (driver != null) {
      driver.quit();
    }
  }

  @Override
  public void get(String url) {
    driver.get(url);
  }

  @Override
  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  @Override
  public String getTitle() {
    return driver.getTitle();
  }

  @Override
  public List<WebElement> findElements(By by) {
    return driver.findElements(by);
  }

  @Override
  public WebElement findElement(By by) {
    return driver.findElement(by);
  }

  @Override
  public String getPageSource() {
    return driver.getPageSource();
  }

  @Override
  public void close() {
    driver.close();
  }

  @Override
  public void quit() {
    driver.quit();
  }

  @Override
  public Set<String> getWindowHandles() {
    return driver.getWindowHandles();
  }

  @Override
  public String getWindowHandle() {
    return driver.getWindowHandle();
  }

  @Override
  public TargetLocator switchTo() {
    return driver.switchTo();
  }

  @Override
  public Navigation navigate() {
    return driver.navigate();
  }

  @Override
  public Options manage() {
    return driver.manage();
  }

  @Override
  public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
    return ((TakesScreenshot) driver).getScreenshotAs(target);
  }
}
