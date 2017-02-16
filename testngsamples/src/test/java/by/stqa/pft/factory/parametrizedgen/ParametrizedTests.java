package by.stqa.pft.factory.parametrizedgen;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Created by artemr on 2/1/2017.
 */

public class ParametrizedTests extends TestBase{
  public ParametrizedTests(String resource){
    super(resource);
  }

  @Factory
  public Object[] tf(){
    return new Object[]{new ParametrizedTests("/user.data")};
  }

  @Test(dataProvider = "loadUserFromFile")
  public void test1(String user, String password){
    System.out.println(user + ":" + password);
  }

}
