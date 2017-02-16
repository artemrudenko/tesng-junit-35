package by.stqa.pft.injections.result;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by artemr on 2/16/2017.
 */
public class MyTest {
  @Test
  public void test1(){
    System.out.println("test1");
  }
  @Test
  public void test2(){
    System.out.println("test2");
    Assert.assertTrue(false);
  }

  @AfterMethod
  public void tearDown(ITestResult result){
    if(!result.isSuccess()){
      System.out.println("Taking screenshot after failure of " + result.getName());
    }
  }
}
