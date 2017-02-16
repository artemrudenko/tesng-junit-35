package by.stqa.pft.factory.complex;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by artemr on 2/16/2017.
 */
public class MyFactory {
  @Factory
  public Object[] tf() throws IOException {
    List<Object> tests = new ArrayList<Object>();
    List<String[]> data = loadUserFromResource("/user.data");
    for(String[] dataItem: data){
      tests.add(new CreateUser(dataItem[0], dataItem[1]));
      tests.add(new DeleteUser(dataItem[0]));
    }
    return (Object[]) tests.toArray(new Object[tests.size()]);
  }

  public List<String[]> loadUserFromResource(String resource) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(
            MyFactory.class.getResourceAsStream(resource)));
    List<String[]> userData = new ArrayList<String[]>();
    String line = in.readLine();
    while (line != null){
      userData.add(line.split(";"));
      line = in.readLine();
    }
    in.close();
    return userData;
  }
}
