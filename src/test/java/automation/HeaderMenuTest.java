package automation;

import automation.model.HeaderMenuPage;
import automation.model.HomePage;
import automation.runner.BaseTest;
import automation.utils.TestValues;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HeaderMenuTest extends BaseTest {

    @Test(testName = "Test check header menu")
    @Epic("Web interface")// Behavior-based hierarchy
    @Feature("Essential features")
    @Story("Header menu")
    @Issue("Header menu title")
    @Description("This test attempts to check title of HomePage on the  website")
    public void testCheckHeaderMenu() {
        List<String> headerMenu = new HeaderMenuPage(driver)
                .headerMenuList();
        System.out.println(headerMenu);

        Assert.assertEquals(headerMenu, TestValues.HeaderMenuElements.HEADER_MENU_LIST);
    }

    @Test(testName = "Test check header menu")
    @Epic("Web interface")// Behavior-based hierarchy
    @Feature("Essential features")
    @Story("Header menu")
    @Issue("Header menu link")
    @Description("This test attempts to check links to  the pages on the  website")
    public void testHeaderLinks() {
        List<String> headerLinks = new HeaderMenuPage(driver)
                .headerMenuLink();
        Assert.assertEquals(headerLinks, TestValues.HeaderMenuElements.HEADER_MENU_LINKS);

        int response = new HeaderMenuPage(driver)
                .response();

        Assert.assertEquals(response, 200);
    }
    @Test(testName = "Test check header menu")
    @Epic("Web interface")// Behavior-based hierarchy
    @Feature("Essential features")
    @Story("Header menu")
    @Issue("Header menu mail link")
    @Description("This test attempts to check link to mail(@gmail.com)")

    public void testMailLink() {
        int mailLinkResponse = new HeaderMenuPage(driver)
                .responseFromMail();

       Assert.assertEquals(mailLinkResponse, 200);

    }

    @Test(testName = "Test check al links")
    @Epic("Web interface")// Behavior-based hierarchy
    @Feature("Essential features")
    @Story("Home page")
    @Issue("Home page link")
    @Description("This test attempts to check all links")

    public void testAllLinks() {
        int allLinks = new HeaderMenuPage(driver)
                .checkLink(HeaderMenuPage.allLinks);
        Assert.assertEquals(allLinks, 200);

    }


}
