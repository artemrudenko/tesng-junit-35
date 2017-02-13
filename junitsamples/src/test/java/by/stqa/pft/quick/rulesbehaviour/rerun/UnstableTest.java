package by.stqa.pft.quick.rulesbehaviour.rerun;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

/**
 * Created by artemr on 2/13/2017.
 */
public class UnstableTest {
  @Rule
  public TestRule runTwiceRule = new RunTwiceRule();

  private static int attempt = 1;

  @Test
  public void randomlyFailingTest(){
    if(attempt == 2){
      attempt = 1;
    }else {
      Assert.fail("Failed on  " + (attempt++) + " attempt");
    }
  }

}
