package by.stqa.pft.injections.method.extras;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by artemr on 2/16/2017.
 */
public class MyTest {
  private WebDriver driver;

  @BeforeClass
  public void startDriver(){
    driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
  }
  @BeforeMethod
  public void setUp(){
    driver.manage().logs().get("driver");
  }
  @Test
  public void test1(){
    driver.get("http://www.seleniumhq.org");
  }
  @Test
  public void test2(){
    driver.get("http://selenium2.ru");
  }
  @AfterMethod
  public void tearDown(Method m) throws IOException{
    LogEntries logEntries = driver.manage().logs().get("driver");
    File driverLog = new File(m.getName() + ".log");
    FileWriter out = new FileWriter(driverLog);
    for (LogEntry logEntry: logEntries.getAll()){
      out.write(logEntry.toString() + "\n");
    }
    out.close();
  }
  @AfterClass(alwaysRun = true)
  public void stopDriver(){
    WebDriverPool.DEFAULT.dismissDriver(driver);
  }

}
