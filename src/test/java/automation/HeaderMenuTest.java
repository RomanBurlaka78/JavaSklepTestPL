package automation;

import automation.model.HeaderMenuPage;
import automation.runner.BaseTest;
import automation.utils.TestValues;
import io.qameta.allure.*;
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

    }


}
