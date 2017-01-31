package by.stqa.pft.quick;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by artemr on 1/31/2017.
 */
public class SeleniumAssertionTest extends SeleniumTestBase{
  @Test
  public void testAssertion(){
    SeleniumAssertion check = new SeleniumAssertion(driver);
    driver.get("http://selenium2.ru");
    check.asserPresentElementLocated(By.id("jsn-menu"));
    check.assertDisplayed(driver.findElement(By.id("jsn-menu")));
  }


}
