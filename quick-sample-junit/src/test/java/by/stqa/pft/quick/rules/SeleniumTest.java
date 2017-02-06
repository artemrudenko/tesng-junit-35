package by.stqa.pft.quick.rules;

import org.junit.Test;

//public class SeleniumTest extends SeleniumMethodFixture {
//public class SeleniumTest extends SeleniumClassFixture {
public class SeleniumTest extends SeleniumComplexClassFixture {
  @Test
  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  @Test
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
