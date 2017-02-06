package by.stqa.pft.quick;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by artemr on 2/6/2017.
 */
public class AssumeTest {
  @Test
  public void testPreconditionIsTrue(){
    Assume.assumeThat(2*2, is(4));
    Assert.assertThat(2*2, is(4));
  }
  @Test
  public void testPreconditionIsFalse(){
    Assume.assumeThat(2*2, is(5));
    Assert.assertThat(2*2, is(5));
  }

}
