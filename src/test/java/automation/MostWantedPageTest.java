package automation;

import automation.model.HomePage;
import automation.runner.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MostWantedPageTest extends BaseTest {

    @Test
    @Epic("Web interface HomePage")
    @Feature("Essential features")
    @Story("MostWanted Page")
    @Issue("Get url of page")
    @Description("This test attempts to check url from MostWanted Page on the  website")
    @Owner("R B")
    @Link(name = "Website", url = "https://skleptest.pl/")

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
