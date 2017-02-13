package by.stqa.pft.quick;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class AssertionTest{
  @Test
  public void testAssert(){
    Assert.assertEquals(5, 2*2);
  }
  @Test
  public void testHamcrest(){
    Assert.assertThat(2*2, is(5));
  }
  @Test
  public void testSoftAssert(){
    SoftAssertions s = new SoftAssertions();
    s.assertThat(2*2).isEqualTo(3);
    s.assertThat(2*2).isEqualTo(5);
    s.assertAll();
  }
}
