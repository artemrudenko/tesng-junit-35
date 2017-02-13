package by.stqa.pft.quick.rules.secondlevel;

import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by artemr on 2/13/2017.
 */
public class SeleniumFixtureWChain {
  public WebDriverRule driver = new WebDriverRule(DesiredCapabilities.chrome());

  @Rule
  public TestRule rule = RuleChain
          .outerRule(driver)
          .around(new ScreenshotRule(driver));
}
