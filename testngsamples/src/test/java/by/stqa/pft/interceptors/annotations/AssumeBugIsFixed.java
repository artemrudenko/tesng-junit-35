package by.stqa.pft.interceptors.annotations;

/**
 * Created by artemr on 2/20/2017.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URL;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;

public class AssumeBugIsFixed implements IAnnotationTransformer {

  @Override
  public void transform(ITestAnnotation annotation, Class testClass,
                        Constructor testConstructor, Method testMethod) {
    Bug bugAnnotation = testMethod.getAnnotation(Bug.class);
    if (bugAnnotation != null) {
      try {
        MantisConnectLocator mcl = new MantisConnectLocator();
        MantisConnectPortType mcp = mcl.getMantisConnectPort(
                new URL("http://localhost/mantisbt-1.2.19/api/soap/mantisconnect.php"));
        IssueData issue = mcp.mc_issue_get("administrator", "root",
                BigInteger.valueOf(bugAnnotation.value()));
        String status = issue.getStatus().getName();
        System.out.println("Status is " + status);
        if (! ("closed".equals(status) || "resolved".equals(status))) {
          annotation.setEnabled(false);
        }
      } catch (Exception e) {
        System.out.println("why");
        e.printStackTrace();
      }
    }

  }

}