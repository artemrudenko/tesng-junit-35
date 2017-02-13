package by.stqa.pft.quick.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Created by artemr on 2/6/2017.
 */
public class TempFolderTests {
  @Rule
  public TemporaryFolder tmpdir = new TemporaryFolder();

  @Test
  public void testSmth(){
    System.out.println(tmpdir.getRoot());
  }
}
