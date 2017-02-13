package by.stqa.pft.quick.rulesbehaviour.rerun;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by artemr on 2/13/2017.
 */
public class RunTwiceRule implements TestRule {
  @Override
  public Statement apply(Statement base, Description description) {
    return new RunTwiceStatement(base, description);
  }

  public class RunTwiceStatement extends Statement {
    private final  Statement base;
    private Description description;

    public RunTwiceStatement(Statement base, Description description) {
      this.base = base;
      this.description = description;
    }

    @Override
    public void evaluate() throws Throwable {
      try {
        base.evaluate();
      } catch (Throwable t) {
        System.out.println("Failed on first attempt: " + description);
        base.evaluate();
      }
    }
  }
}
