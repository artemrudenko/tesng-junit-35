package by.stqa.pft.quick.rules.classrule;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestWatcher;
import org.junit.rules.Verifier;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by artemr on 2/6/2017.
 */
public class SeleniumFixture {
  protected static WebDriver driver;

  @ClassRule
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

  @Rule
  public TestWatcher screenshotRule = new TestWatcher() {
    @Override
    protected void succeeded(Description description) {
      super.starting(description);
    }

    @Override
    protected void failed(Throwable e, Description description) {
      System.out.println("Taking sceenshot");
      File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      try {
        Files.copy(tmp, new File(description.getMethodName() + ".png"));
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }

    @Override
    protected void starting(Description description) {
      super.starting(description);
    }

    @Override
    protected void finished(Description description) {
      super.finished(description);
    }
  };

  @Rule
  public Verifier errorVerifier = new Verifier() {
    @Override
    protected void verify() throws Throwable {
      String jsErrors = driver.findElement(By.id("__jsErrors")).getAttribute("textContent");
      ((JavascriptExecutor) driver).executeScript("__resetJsErrors()");

      Assert.assertThat(jsErrors, is(""));
    }
  };

}

