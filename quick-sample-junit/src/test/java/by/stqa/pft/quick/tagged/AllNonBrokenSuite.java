package by.stqa.pft.quick.tagged;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(Categories.class)
@SuiteClasses(CategorizedTest.class)
@ExcludeCategory(MyCategories.BrokenTests.class)
public class AllNonBrokenSuite {
}
