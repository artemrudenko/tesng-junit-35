package by.sqta.pft.homework;

import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(org.junit.experimental.categories.Categories.class)
@SuiteClasses(CreateNewFileTests.class)
@ExcludeCategory(TCategories.BrokenTests.class)
public class NotBrokenSuite {
}
