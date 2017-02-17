package by.stqa.pft.lesson1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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

  @BeforeMethod
  public void setMode(Method m) {
    System.out.println("Before method " + m.getName());
    File folder = temp.toFile();
    TempDir annotation = m.getAnnotation(TempDir.class);
    if (annotation != null) {
      System.out.println("Changing mode");
      folder.setReadable(annotation.read(), false);
      folder.setWritable(annotation.write(), false);
    }
    System.out.println("Can write " + folder.canWrite());
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

  @Test(groups = "positive", dataProvider = "loadFilenamesFromFile")
  public void testCallCreatesFileAndReturnsTrue(String name) throws IOException {
    SoftHamcrestAssert h = new SoftHamcrestAssert();
    System.out.println("createNewFile creates file and returns true if file is new");
    File file = new File(temp.toString(), name);
    h.assertThat(file.createNewFile(), is(true));
    h.assertThat(file.exists(), is(true));
    h.assertAll();
  }

  @Test(groups = "positive", dataProvider = "getFilename")
  public void testCreatesEmptyFile(String name) throws IOException {
    System.out.println("createNewFile creates an empty file");
    File file = new File(temp.toString(), name);
    file.createNewFile();
    assertThat(file.length(), is(0L));
  }

  @Test(groups = "positive")
  public void testCreatesNewFileSoft() throws IOException {
    SoftHamcrestAssert h = new SoftHamcrestAssert();
    System.out.println("Soft: createNewFile creates an empty file");
    File file = new File(temp.toString(), getFileName());
    h.assertThat(file.createNewFile(), is(true));
    h.assertThat(file.length(), is(0L));
    h.assertAll();
  }

  @Test(groups = "negative")
  public void testCallReturnsFalseIfExists() throws IOException {
    System.out.println("createNewFile returns false if file isn't new");
    String f_name = getFileName();
    File file = new File(temp.toString(), f_name);
    file.createNewFile();
    File file2 = new File(temp.toString(), f_name);
    assertThat(file2.createNewFile(), is(false));
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

  @Test(groups = "negative", expectedExceptions = IOException.class)
  @TempDir(read = true, write = false)
  public void testCannotCreateFileInAReadOnlyDir() throws IOException {
    System.out.println("createNewFile testCannotCreateFileInAReadOnlyDir");
    File file = new File(temp.toString(), getFileName());
    file.createNewFile();
    assertThat(file.exists(), is(false));
  }

  @Test(groups = "negative")
  @TempDir(read = false, write = true)
  public void testCreateFileInAWritableOnlyDir() throws IOException {
    System.out.println("createNewFile testCreateFileInAWritableOnlyDir");
    File file = new File(temp.toString(), getFileName());
    file.createNewFile();
    assertThat(file.exists(), is(true));
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

  @DataProvider
  public Iterator<Object[]> loadFilenamesFromFile() throws IOException {
    try(BufferedReader reader = new BufferedReader(
            new InputStreamReader(CreateNewFileTests.class.getResourceAsStream("/filenames.data")))) {
      String line = reader.readLine();
      List<Object[]> filenames = new ArrayList<Object[]>();
      while (line != null) {
        filenames.add(new Object[]{line});
        line = reader.readLine();
      }
      return filenames.iterator();
    }
  }

  public String getRandomValueFromList(List<String> values){
    Random randomizer = new Random();
    return values.get(randomizer.nextInt(values.size()));
  }

  @DataProvider
  public Iterator<Object[]> getFilename(){
    List<String> ext = Arrays.asList("doc", "ini", "data", "config", "txt");
    List<Object[]> data = new ArrayList<Object[]>();
    for(int i=0; i < 5; i++){
      data.add(new Object[]{String.format("%s.%s", generateRandomName(), getRandomValueFromList(ext))});
    }
    return data.iterator();
  }

  private String generateRandomName() {
    return "Sample" + new Random().nextInt();
  }
}
