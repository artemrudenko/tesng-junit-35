package by.stqa.pft.lesson1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

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

  @BeforeClass(alwaysRun = true)
  public void init() throws IOException {
    System.out.println("Preparing temp directory...");
    temp = Files.createTempDirectory("TestNGHomeWork_");
  }

  @AfterClass(alwaysRun = true)
  public void clean(){
    System.out.println("Removing temp directory...");
    deleteDirectory(temp.toFile());
  }

  @Test(groups = {"positive", "broken"})
  public void testPositiveBroken() throws IOException {
    System.out.println("createNewFile positive and broken(to be skipped)");
    File file = new File(temp.toString(), getFileName());
    file.createNewFile();
    throw new Error("Something wrong!");
  }

  @Test(groups = "positive")
  public void testCallReturnsTrue() throws IOException {
    System.out.println("createNewFile returns true if file is new");
    File file = new File(temp.toString(), getFileName());
    assertThat(file.createNewFile(), is(equalTo(true)));
  }

  @Test(groups = "positive")
  public void testCallCreatesFile() throws IOException {
    System.out.println("createNewFile should create new file");
    File file = new File(temp.toString(), getFileName());
    file.createNewFile();
    assertThat(file.exists(), is(equalTo(true)));
  }

  @Test(groups = "positive")
  public void testCreatesEmptyFile() throws IOException {
    System.out.println("createNewFile creates an empty file");
    File file = new File(temp.toString(), getFileName());
    file.createNewFile();
    assertThat(file.length(), is(equalTo(0L)));
  }

  @Test(groups = "negative")
  public void testCallReturnsFalseIfExists() throws IOException {
    System.out.println("createNewFile returns false if file isn't new");
    String f_name = getFileName();
    File file = new File(temp.toString(), f_name);
    file.createNewFile();
    File file2 = new File(temp.toString(), f_name);
    assertThat(file2.createNewFile(), is(equalTo(false)));
  }

  @Test(groups = "negative", expectedExceptions = IOException.class)
  public void testRaisesIOExceptionIfPathWrong() throws IOException {
    System.out.println("createNewFile raises IOException if path is wrong");
    File file = new File(temp.toString(), "12314//\\\\*.txt");
    file.createNewFile();
  }

  @Test(groups = {"negative", "broken"})
  public void testNegativeBroken() throws IOException {
    System.out.println("createNewFile negative and broken(to be skipped)");
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
