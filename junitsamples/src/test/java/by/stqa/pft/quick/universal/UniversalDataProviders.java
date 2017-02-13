package by.stqa.pft.quick.universal;

import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.runners.model.FrameworkMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artemr on 2/13/2017.
 */
public class UniversalDataProviders {

  @DataProvider
  public static Object[][] dataSourceLoader(FrameworkMethod testMethod) throws IOException{
    DataSource ds = testMethod.getAnnotation(DataSource.class);
    if(ds == null){
      throw new Error("Test method has no @DataSource annotation: " + testMethod.getName());
    }
    switch (ds.type()){
      case RESOURCE:
        return loadDataFromResource(ds.value());
      case FILE:
        return loadDataFromFile(ds.value());
      default:
        throw new Error("Data source type is not supported: " + ds.type());
    }
  }

  private static Object[][] loadDataFromFile(String value) throws IOException{
    return loadDataFromInputStream(new FileInputStream(new File(value)));
  }

  private static Object[][] loadDataFromInputStream(InputStream input) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(input));
    List<Object[]> userData = new ArrayList<Object[]>();
    String line = in.readLine();
    while (line != null){
      userData.add(line.split(";"));
      line = in.readLine();
    }
    in.close();
    return (Object[][])userData.toArray(new Object[][]{});
  }

  private static Object[][] loadDataFromResource(String value) throws IOException{
    return loadDataFromInputStream(UniversalDataProviders.class.getResourceAsStream(value));
  }
}
