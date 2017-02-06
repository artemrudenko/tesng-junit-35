package by.stqa.pft.quick;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by artemr on 1/24/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SecondTest {
  @Test
  public void test1(){
    System.out.println("SecondTest.test1 All is OK!");
  }
  @Test
  public void test2(){
    System.out.println("SecondTest.test2 All is OK!");
  }
}
