package by.stqa.pft.interceptors.hookable;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * Created by artemr on 2/20/2017.
 */
public class RunTwiceInterceptor implements IHookable {
  @Override
  public void run(IHookCallBack callBack, ITestResult res){
    System.out.println("Starting " + res.getName());
    callBack.runTestMethod(res);
    if(res.getThrowable() != null){
      res.setThrowable(null);
      System.out.println("Second attempt " + res.getName());
      callBack.runTestMethod(res);
    }
  }
}
