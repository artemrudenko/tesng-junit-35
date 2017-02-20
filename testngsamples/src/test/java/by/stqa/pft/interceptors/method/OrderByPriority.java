package by.stqa.pft.interceptors.method;

/**
 * Created by artemr on 2/20/2017.
 */
import java.util.Collections;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class OrderByPriority implements IMethodInterceptor {

  @Override
  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    Collections.sort(methods, (o1, o2) -> {
      HasPriority i1 = (HasPriority) o1.getInstance();
      HasPriority i2 = (HasPriority) o2.getInstance();
      return Integer.compare(i1.getPriority(), i2.getPriority());
    });
    return methods;
  }

}