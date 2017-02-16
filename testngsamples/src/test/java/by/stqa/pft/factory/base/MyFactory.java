package by.stqa.pft.factory.base;

import org.testng.annotations.Factory;

/**
 * Created by artemr on 2/16/2017.
 */
public class MyFactory {
  @Factory
  public Object[] tf() {
    Object[] tests = new Object[3];
    for (int i = 0; i < 3; i++) {
      tests[i] = new MyTest();
    }
    return tests;
  }
}
