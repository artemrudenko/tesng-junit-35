package by.stqa.pft.quick.rules.extractor;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestWatcher;
import org.junit.rules.Verifier;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by artemr on 2/6/2017.
 */
public class SeleniumFixture {
  protected static WebDriver driver;

  @ClassRule
  public static WebDriverRule driverRule = new WebDriverRule(
          DesiredCapabilities.chrome());

  @Rule
  public ExternalResource extractDriverRule = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      driver = driverRule.getDriver();
    }
  };

}

