package by.sqta.pft.homework.wfixtureclass;

import org.junit.Rule;
import org.junit.rules.ExternalResource;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by artemr on 2/6/2017.
 */
public class FolderFixture {
  protected Path tmpdir;

  @Rule
  public RerunRule rerunRule = new RerunRule();

  @Rule
  public ExternalResource folderRule = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      System.out.println("Preparing temp directory...");
      tmpdir = Files.createTempDirectory("JUnitHomeWork_");
    }

    @Override
    protected void after() {
      System.out.println("Removing temp directory...");
      deleteDirectory(tmpdir.toFile());
    }
  };

  private static boolean deleteDirectory(File dir) {
    if (dir.isDirectory()) {
      File[] children = dir.listFiles();
      if(children != null){
        for (int i = 0; i < children.length; i++) {
          boolean success = deleteDirectory(children[i]);
          if (!success) {
            return false;
          }
        }
      }
    }
    return dir.delete();
  }
}
