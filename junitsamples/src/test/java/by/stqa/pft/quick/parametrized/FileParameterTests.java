package by.stqa.pft.quick.parametrized;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(DataProviderRunner.class)
public class FileParameterTests {

  @Test
  @UseDataProvider("users")
  public void test1(String user, String password){
    System.out.println(user + " : " + password);
  }

  @DataProvider
  public static Object[][] users() throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(
            FileParameterTests.class.getResourceAsStream("/user.data")));

    List<Object[]> userData = new ArrayList<Object[]>();
    String line = in.readLine();
    while (line != null){
      userData.add(line.split(";"));
      line = in.readLine();
    }
    in.close();

    return (Object[][]) userData.toArray(new Object[][]{});
  }
}
