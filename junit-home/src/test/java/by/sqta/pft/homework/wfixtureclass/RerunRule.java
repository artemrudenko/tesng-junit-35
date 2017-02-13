package by.sqta.pft.homework.wfixtureclass;

import org.junit.Assume;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by artemr on 2/13/2017.
 */
public class RerunRule implements TestRule {
  @Override
  public Statement apply(Statement base, Description description) {
    return new RerunStatement(base, description);
  }

  public class RerunStatement extends Statement {
    private final Statement base;
    private Description description;

    public RerunStatement(Statement base, Description description) {
      this.base = base;
      this.description = description;
    }

    @Override
    public void evaluate() throws Throwable {
      Unstable unstable = description.getAnnotation(Unstable.class);
      if (unstable != null) {
        int attempt = unstable.value();
        Assume.assumeThat("Number of attempts specified is less or equal to 0", attempt, greaterThan(0));
        System.out.println("Starting " + description.getMethodName() + "...");
        System.out.println("Total attempts allowed: " + attempt);

        int overall = attempt + 1;
        while (true) {
          try {
            base.evaluate();
            break;
          } catch (Throwable t) {
            System.out.println("Failed on " + (overall - attempt) + " attempt: " + description);
            attempt--;
            if (attempt <= 0) {
              throw t;
            }
          }
        }
      } else {
        base.evaluate();
      }
    }
  }
}