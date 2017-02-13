package by.stqa.pft.quick.runtimesuitesamples.fileloader;

import com.dhemery.runtimesuite.ClassFinder;
import com.dhemery.runtimesuite.Finder;
import com.dhemery.runtimesuite.RuntimeSuite;
import com.dhemery.runtimesuite.finders.ListedClasses;
import org.junit.runner.RunWith;

@RunWith(RuntimeSuite.class)
public class MySuite {

  @Finder public ClassFinder finder = new SuiteLoader("/suite.txt");

}
