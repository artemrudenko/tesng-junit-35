package by.stqa.pft.factory.complex;


import org.testng.annotations.Test;

/**
 * Created by artemr on 2/16/2017.
 */
public class CreateUser {
  private String user;
  private String password;

  public CreateUser(String user, String password){
    this.user = user;
    this.password = password;
  }

  @Test
  public void testCreateUser(){
    System.out.println("testCreateUser " + user + ":" + password);
  }
}
