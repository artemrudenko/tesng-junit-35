package by.sqta.pft.homework.wfixturerule;

import by.sqta.pft.homework.TCategories;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(DataProviderRunner.class)
public class CreateNewFileTests {
  @Rule
  public TemporaryFolder tmpdir = new TemporaryFolder();

  @Test
  @Category({TCategories.PositiveTests.class, TCategories.BrokenTests.class})
  public void testPositiveBroken() throws IOException {
    System.out.println("createNewFile positive and broken(to be skipped)");
    File file = new File(tmpdir.getRoot().toString(), getFileName());
    file.createNewFile();
    throw new Error("Something wrong!");
  }

  @Test
  @Category(TCategories.PositiveTests.class)
  @UseDataProvider("filenames")
  public void testCallCreatesFileAndReturnsTrue(String name) throws IOException {
    SoftAssertions s = new SoftAssertions();
    System.out.println("createNewFile creates file and returns true if file is new");
    File file = new File(tmpdir.getRoot().toString(), name);
    s.assertThat(file.createNewFile()).isEqualTo(true);
    s.assertThat(file.exists()).isEqualTo(true);
    s.assertAll();
  }

  @Test
  @Category(TCategories.PositiveTests.class)
  @UseDataProvider("generateFilenames")
  public void testCreatesEmptyFile(String name) throws IOException {
    System.out.println("createNewFile creates an empty file");
    File file = new File(tmpdir.getRoot().toString(), name);
    file.createNewFile();
    assertThat(file.length(), is(0L));
  }

  @Test
  @Category(TCategories.PositiveTests.class)
  public void testCreatesNewFileSoft() throws IOException {
    SoftAssertions s = new SoftAssertions();
    System.out.println("Soft: createNewFile creates an empty file");
    File file = new File(tmpdir.getRoot().toString(), getFileName());
    s.assertThat(file.createNewFile()).isEqualTo(true);
    s.assertThat(file.length()).isEqualTo(0L);
    s.assertAll();
  }

  @Test
  @Category(TCategories.NegativeTests.class)
  public void testCallReturnsFalseIfExists() throws IOException {
    System.out.println("createNewFile returns false if file isn't new");
    String f_name = getFileName();
    File file = new File(tmpdir.getRoot().toString(), f_name);
    file.createNewFile();
    File file2 = new File(tmpdir.getRoot().toString(), f_name);
    assertThat(file2.createNewFile(), is(false));
  }

  @Test(expected = IOException.class)
  @Category(TCategories.NegativeTests.class)
  public void testRaisesIOExceptionIfPathWrong() throws IOException {
    System.out.println("createNewFile raises IOException if path is wrong");
    File file = new File(tmpdir.getRoot().toString(), "12314//\\\\*.txt");
    file.createNewFile();
  }

  @Test
  @Category({TCategories.NegativeTests.class, TCategories.BrokenTests.class})
  public void testNegativeBroken() throws IOException {
    System.out.println("createNewFile negative and broken(to be skipped)");
    File file = new File(tmpdir.getRoot().toString(), "12314//\\\\*.txt");
    file.createNewFile();
  }

  private static String getFileName(){
    return String.format("sample_%s.txt", System.currentTimeMillis());
  }

  @DataProvider
  public static Object[][] filenames() throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(
            CreateNewFileTests.class.getResourceAsStream("/filenames.data")));

    List<Object[]> userData = new ArrayList<Object[]>();
    String line = in.readLine();
    while (line != null){
      userData.add(line.split(";"));
      line = in.readLine();
    }
    in.close();

    return (Object[][]) userData.toArray(new Object[][]{});
  }

  public static String getRandomValueFromList(List<String> values){
    Random randomizer = new Random();
    return values.get(randomizer.nextInt(values.size()));
  }

  @DataProvider
  public static Object[][] generateFilenames(){
    List<String> ext = Arrays.asList("doc", "ini", "data", "config", "txt");
    List<Object[]> data = new ArrayList<Object[]>();
    for(int i=0; i < 5; i++){
      data.add(new Object[]{String.format("%s.%s", generateRandomName(), getRandomValueFromList(ext))});
    }
    return (Object[][]) data.toArray(new Object[][]{});
  }

  private static String generateRandomName() {
    return "Sample" + new Random().nextInt();
  }
}
