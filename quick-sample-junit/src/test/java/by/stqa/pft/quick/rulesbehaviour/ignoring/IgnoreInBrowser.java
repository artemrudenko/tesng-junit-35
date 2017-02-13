package by.stqa.pft.quick.rulesbehaviour.ignoring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by artemr on 2/13/2017.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreInBrowser {
  public static enum Browser {
    ALL,
    ANDROID,
    CHROME,
    HTMLUNIT,
    FIREFOX,
    IE,
    IPHONE,
    MARIONETTE,
    OPERA,
    OPERA_MOBILE,
    PHANTOMJS,
    REMOTE,
    SAFARI,
  }

  Browser[] value();
}
