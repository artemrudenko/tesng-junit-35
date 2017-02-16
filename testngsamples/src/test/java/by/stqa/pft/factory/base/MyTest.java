package by.stqa.pft.factory.base;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by artemr on 2/16/2017.
 */
public class MyTest {
  @BeforeClass
  public void setUp() {
    System.out.println("setUp");
  }

  @AfterClass
  public void tearDown() {
    System.out.println("tearDown");
  }

  @Test
  public void test1() {
    System.out.println("test1");
  }

  @Test
  public void test2() {
    System.out.println("test2");
  }
}
