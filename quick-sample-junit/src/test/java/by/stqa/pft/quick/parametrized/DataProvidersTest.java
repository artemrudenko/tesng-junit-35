package by.stqa.pft.quick.parametrized;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(DataProviderRunner.class)
public class DataProvidersTest {
  @DataProvider
  public static Object[][] users(){
    return new Object[][]{
            {"admin", "admin"},
            {"guest", "guest"}
    };
  }

  @Test
  @UseDataProvider("users")
  public void test1(String user, String password){
    System.out.println("test1");
  }

  @Test
  public void test2(){
    System.out.println("test2");
  }

}
