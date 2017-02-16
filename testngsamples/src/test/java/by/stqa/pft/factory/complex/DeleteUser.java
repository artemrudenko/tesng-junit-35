package by.stqa.pft.factory.complex;

import org.testng.annotations.Test;

/**
 * Created by artemr on 2/16/2017.
 */
public class DeleteUser {
  private String user;

  public DeleteUser(String user) {
    this.user = user;
  }

  @Test
  public void testDeleteUser() {
    System.out.println("testDeleteUser " + user);
  }
}
