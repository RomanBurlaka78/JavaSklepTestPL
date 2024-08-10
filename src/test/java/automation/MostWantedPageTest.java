package automation;

import automation.model.HomePage;
import automation.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MostWantedPageTest extends BaseTest {

    @Test
    public void testCheckCurrentPage() {
        int subStringUrl = new HomePage(driver)
                .goToMostWantedPage()
                .showUrlIndexOf();
        Assert.assertEquals(subStringUrl, 37);

        boolean subStringUrlContains = new HomePage(driver)
                .goToMostWantedPage()
                .showUrlContains();
        Assert.assertTrue(subStringUrlContains);

        int subStringUtilsIgnoreCase = new HomePage(driver)
                .goToMostWantedPage()
                .showUrlStringUtilsContainsIgnoreCase();
        System.out.println(subStringUtilsIgnoreCase);


    }


}
