package by.stqa.pft.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by artemr on 2/20/2017.
 */
public class RunUntilSuccess implements IRetryAnalyzer{
  @Override
  public boolean retry(ITestResult res){
    return !res.isSuccess();
  }
}
