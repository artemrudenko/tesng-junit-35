package by.stqa.pft.lesson1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by artemr on 1/30/2017.
 */
public class CreateNewFileTests {
  Path temp;
  @BeforeClass
  public void init() throws IOException {
    System.out.println("Preparing temp directory...");
    temp = Files.createTempDirectory("TestNGHomeWork_");
  }

  @AfterClass
  public void clean(){
    System.out.println("Removing temp directory...");
    deleteDirectory(temp.toFile());
  }

  @Test
  public void testCallCreatesFile() throws IOException {
    System.out.println("createNewFile should create new file");
    File file = new File(temp.toString(), getFileName());
    file.createNewFile();
    Assert.assertTrue(file.exists());
  }

  @Test
  public void testCallReturnsTrue() throws IOException {
    System.out.println("createNewFile returns true if file is new");
    File file = new File(temp.toString(), getFileName());
    Assert.assertTrue(file.createNewFile());
  }

  @Test
  public void testCreatesEmptyFile() throws IOException {
    System.out.println("createNewFile creates an empty file");
    File file = new File(temp.toString(), getFileName());
    file.createNewFile();
    Assert.assertEquals(file.length(), 0, "An empty file expected to be created!");
  }

  @Test
  public void testCallReturnsFalseIfExists() throws IOException {
    System.out.println("createNewFile returns false if file isn't new");
    String f_name = getFileName();
    File file = new File(temp.toString(), f_name);
    file.createNewFile();
    File file2 = new File(temp.toString(), f_name);
    Assert.assertFalse(file2.createNewFile());
  }

  @Test(expectedExceptions = IOException.class)
  public void testRaisesIOExceptionIfPathWrong() throws IOException {
    File file = new File(temp.toString(), "12314//\\\\*.txt");
    file.createNewFile();
  }

  public static boolean deleteDirectory(File dir) {
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
  private String getFileName(){
    return String.format("sample_%s.txt", System.currentTimeMillis());
  }
}
