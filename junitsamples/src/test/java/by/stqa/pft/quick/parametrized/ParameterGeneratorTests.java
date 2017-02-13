package by.stqa.pft.quick.parametrized;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by artemr on 2/1/2017.
 */
@RunWith(DataProviderRunner.class)
public class ParameterGeneratorTests {
  @Test
  @UseDataProvider("users")
  public void test1(String user, String password) throws InterruptedException{
    System.out.println(user + ":" + password);
  }

  @DataProvider
  public static Object[][] users(){
    List<Object[]> data = new ArrayList<Object[]>();
    for(int i=0; i<10; i++){
      data.add(new Object[]{generateRandomName(), generateRandomPassword()});
    }
    return (Object[][]) data.toArray(new Object[][]{});
  }

  private static Object generateRandomPassword() {
    return "password" + new Random().nextInt();
  }

  private static Object generateRandomName() {
    return "user" + new Random().nextInt();
  }
}
