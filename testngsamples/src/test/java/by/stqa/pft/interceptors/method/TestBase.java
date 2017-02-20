package by.stqa.pft.interceptors.method;

/**
 * Created by artemr on 2/20/2017.
 */
public class TestBase implements HasPriority {

  private int p;

  @Override
  public int getPriority() {
    return p;
  }

  @Override
  public void setPriority(int p) {
    this.p = p;
  }

}