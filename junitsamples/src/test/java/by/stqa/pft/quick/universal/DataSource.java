package by.stqa.pft.quick.universal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by artemr on 2/13/2017.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
  public enum Type{
    RESOURCE,
    FILE
  }
  String value();
  Type type();
}
