package by.stqa.pft.quick.tagged;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by artemr on 2/6/2017.
 */
@RunWith(Categories.class)
@SuiteClasses(CategorizedTest.class)
//@Categories.IncludeCategory({MyCategories.PositiveTests.class, MyCategories.NegativeTests.class})
@IncludeCategory(MyCategories.PositiveTests.class)
public class PositiveSuite {

}
