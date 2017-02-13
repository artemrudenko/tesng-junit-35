package by.stqa.pft.quick.rulesbehaviour.ignoring;

import org.junit.ClassRule;
import org.junit.Rule;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by artemr on 2/13/2017.
 */
public class SeleniumFixture {
  @ClassRule
  public static WebDriverRule driver = new WebDriverRule(DesiredCapabilities.chrome());
  @Rule
  public IgnoreInBrowserRule ignoreInBrowserRule = new IgnoreInBrowserRule(driver);
}
