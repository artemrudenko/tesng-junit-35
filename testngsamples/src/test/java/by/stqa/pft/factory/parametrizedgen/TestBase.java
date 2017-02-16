package by.stqa.pft.factory.parametrizedgen;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by artemr on 2/16/2017.
 */
public class TestBase {
  private String resource;

  protected TestBase(String resource){
    this.resource = resource;
  }

  @DataProvider
  public Iterator<Object[]> loadUserFromFile() throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(
            TestBase.class.getResourceAsStream(resource)));
    List<Object[]> userData = new ArrayList<Object[]>();
    String line = in.readLine();
    while (line != null){
      userData.add(line.split(";"));
      line = in.readLine();
    }
    in.close();
    return userData.iterator();
  }
}
