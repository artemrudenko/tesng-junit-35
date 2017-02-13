package by.stqa.pft.quick.rules.secondlevel;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by artemr on 2/13/2017.
 */
public class SeleniumFixture {
  @ClassRule
  public static WebDriverRule driver = new WebDriverRule(DesiredCapabilities.chrome());

  @Rule
  public TestWatcher screenshotRule = new ScreenshotRule(driver);
}
