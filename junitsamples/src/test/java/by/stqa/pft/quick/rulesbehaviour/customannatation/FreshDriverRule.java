package by.stqa.pft.quick.rulesbehaviour.customannatation;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by artemr on 2/13/2017.
 */
public class FreshDriverRule extends TestWatcher {
  private WebDriverRule driverRule;

  public FreshDriverRule(WebDriverRule driverRule) {
    this.driverRule = driverRule;
  }

  @Override
  protected void starting(Description description) {
    if (description.getAnnotation(NeedsFreshDriver.class) != null) {
      System.out.println("Restarting a browser");
      driverRule.startFreshDriver();
    }
  }
}
