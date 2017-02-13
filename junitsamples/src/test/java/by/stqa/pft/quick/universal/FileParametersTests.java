package by.stqa.pft.quick.universal;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static by.stqa.pft.quick.universal.DataSource.Type.*;

/**
 * Created by artemr on 2/13/2017.
 */
@RunWith(DataProviderRunner.class)
public class FileParametersTests {

  @Test
  @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProviders.class)
  @DataSource(value = "/user.data", type = RESOURCE)
  public void testUniversal(String user, String password){
    System.out.println(user + ":" + password);
  }
}
