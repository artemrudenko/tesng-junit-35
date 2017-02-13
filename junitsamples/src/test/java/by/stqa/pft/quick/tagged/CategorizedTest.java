package by.stqa.pft.quick.tagged;

import org.junit.Test;
import org.junit.experimental.categories.Category;


/**
 * Created by artemr on 2/6/2017.
 */
public class CategorizedTest implements MyCategories {
  @Test
  @Category(PositiveTests.class)
  public void test1(){
    System.out.println("positive test");
  }
  @Test
  @Category({PositiveTests.class, BrokenTests.class})
  public void test2(){
    System.out.println("positive broken test");
  }
  @Test
  @Category(NegativeTests.class)
  public void test3(){
    System.out.println("negative test");
  }
}
