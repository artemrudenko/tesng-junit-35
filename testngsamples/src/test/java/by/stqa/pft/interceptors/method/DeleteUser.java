package by.stqa.pft.interceptors.method;

/**
 * Created by artemr on 2/20/2017.
 */
import org.testng.annotations.Test;

public class DeleteUser extends TestBase {

  private String user;

  public DeleteUser(String user) {
    this.user = user;
  }

  @Test
  public void testDeleteUser() {
    System.out.println("testDeleteUser " + user);
  }

}