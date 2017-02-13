package by.sqta.pft.homework;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by artemr on 2/13/2017.
 */
public class RerunRule implements TestRule {
  private static int attempt;

  @Override
  public Statement apply(Statement base, Description description) {
    return new RerunStatement(base, description);
  }

  public class RerunStatement extends Statement {
    private final  Statement base;
    private Description description;

    public RerunStatement(Statement base, Description description) {
      this.base = base;
      this.description = description;
    }

    @Override
    public void evaluate() throws Throwable {
      while(attempt > 0) {
        try {
          base.evaluate();
          break;
        } catch (Throwable t) {
          System.out.println("Failed on " + attempt + " attempt: " + description);
          attempt--;
        }
      }
    }
  }
}