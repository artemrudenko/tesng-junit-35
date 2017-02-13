package by.stqa.pft.quick.rulesbehaviour.ignoring;

import org.junit.Assume;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static by.stqa.pft.quick.rulesbehaviour.ignoring.IgnoreInBrowser.*;

/**
 * Created by artemr on 2/13/2017.
 */
public class IgnoreInBrowserRule implements TestRule{
  private WebDriverRule driverRule;

  public IgnoreInBrowserRule(WebDriverRule driverRule){
    this.driverRule = driverRule;
  }


  @Override
  public Statement apply(Statement base, Description description) {
    return new IgnoreInBrowserStatement(base, description);
  }

  private class IgnoreInBrowserStatement extends Statement {
    private Statement base;
    private Description description;

    public IgnoreInBrowserStatement(Statement base, Description description) {
      this.base = base;
      this.description = description;
    }

    @Override
    public void evaluate() throws Throwable {
      IgnoreInBrowser ignore = description.getAnnotation(IgnoreInBrowser.class);
      if(ignore != null){
        String browser = driverRule.getCapabilities().getBrowserName();
        Browser[] ignoredBrowsers = ignore.value();
        for (Browser ignoredBrowser: ignoredBrowsers){
          Assume.assumeFalse("Ignored in browser " + browser,
                  ignoredBrowser.name().toLowerCase().equals(browser));
        }
      }
      base.evaluate();
    }
  }
}
