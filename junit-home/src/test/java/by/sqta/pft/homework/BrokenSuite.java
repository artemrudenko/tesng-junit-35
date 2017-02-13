package by.sqta.pft.homework;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(Categories.class)
@SuiteClasses(CreateNewFileTests.class)
@IncludeCategory(TCategories.BrokenTests.class)
public class BrokenSuite {

}
