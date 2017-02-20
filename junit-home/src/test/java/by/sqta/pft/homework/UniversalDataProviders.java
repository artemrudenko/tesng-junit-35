package by.sqta.pft.homework;

import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.runners.model.FrameworkMethod;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artemr on 2/13/2017.
 */
public class UniversalDataProviders {

  @DataProvider
  public static Object[][] dataSourceLoader(FrameworkMethod testMethod) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {

    DataSource ds = testMethod.getAnnotation(DataSource.class);
    if(ds == null){
      throw new Error("Test method has no @DataSource annotations: " + testMethod.getName());
    }
    switch (ds.type()){
      case RESOURCE:
        return loadDataFromResource(ds.value());
      case FILE:
        return loadDataFromFile(ds.value());
      case METHOD:
        return loadFromMethod(testMethod, ds.value());
      default:
        throw new Error("Data source type is not supported: " + ds.type());
    }
  }

  private static Object[][] loadFromMethod(FrameworkMethod method, String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
    Class<?> c = Class.forName(method.getDeclaringClass().getName());
    Object t = c.newInstance();
    return (Object[][]) method.getDeclaringClass().getMethod(name).invoke(t);
  }

  private static Object[][] loadDataFromFile(String value) throws IOException{
    File f = searchFile(Paths.get("").normalize().toAbsolutePath().toFile(), value);
    return loadDataFromInputStream(new FileInputStream(f));
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

  static File searchFile(File file, String search) {
    if (file.isDirectory()) {
      File[] arr = file.listFiles();
      for (File f : arr) {
        File found = searchFile(f, search);
        if (found != null)
          return found;
      }
    } else {
      if (file.getName().equals(search)) {
        return file;
      }
    }
    return null;
  }

  private static Object[][] loadDataFromResource(String value) throws IOException{
    return loadDataFromInputStream(UniversalDataProviders.class.getResourceAsStream("/" + value));
  }
}
