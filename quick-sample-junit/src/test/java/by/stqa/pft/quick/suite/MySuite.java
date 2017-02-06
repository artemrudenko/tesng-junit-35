package by.stqa.pft.quick.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
  Test1.class,
  Test2.class
})
public class MySuite {

  @BeforeClass
  public static void suiteSetUp() {
    System.out.println("suiteSetUp");
  }
  
  @AfterClass
  public static void suiteTearDown() {
    System.out.println("suiteTearDown");
  }

}
