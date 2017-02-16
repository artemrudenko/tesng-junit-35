package by.stqa.pft.factory.datagen;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Created by artemr on 2/16/2017.
 */
public class MyTest {
  private String run;

  public MyTest(String run) {
    this.run = run;
  }

  @Factory
  public Object[] tf() {
    Object[] tests = new Object[3];
    for (int i = 0; i < 3; i++) {
      tests[i] = new MyTest("run " + i);
    }
    return tests;
  }

  @BeforeClass
  public void setUp() {
    System.out.println("setUp " + run);
  }

  @AfterClass
  public void tearDown() {
    System.out.println("tearDown " + run);
  }

  @Test
  public void test1() {
    System.out.println("test1 " + run);
  }

  @Test
  public void test2() {
    System.out.println("test2 " + run);
  }
}
