package by.stqa.pft.injections.dataprovider.csv;

/**
 * Created by artemr on 2/20/2017.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CsvDataSource {
  String value();
}