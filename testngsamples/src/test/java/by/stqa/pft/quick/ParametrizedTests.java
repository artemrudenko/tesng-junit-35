package by.stqa.pft.quick;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by artemr on 2/1/2017.
 */
public class ParametrizedTests {
//  @Test(dataProvider = "users")
  @Test(dataProviderClass = DataProviders.class, dataProvider = "loadUserFromFile")
  public void test1(String user, String password){
    System.out.println(user + ":" + password);
  }

  @DataProvider
  public Iterator<Object[]> users(){
    List<Object[]> data = new ArrayList<Object[]>();
    for(int i=0; i<10; i++){
      data.add(new Object[]{generateRandomName(), generateRandomPassword()});
    }
    return data.iterator();
  }

  private Object generateRandomPassword() {
    return "password" + new Random().nextInt();
  }

  private Object generateRandomName() {
    return "user" + new Random().nextInt();
  }
}
