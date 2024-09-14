package automation;

import automation.model.HomePage;
import automation.runner.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class AccountPageTest extends BaseTest {

    @Test
    public void testRegisterAccount() {
        String registerSuccess = new HomePage(driver)
                .goToAccountPage()
                .registerAccount("busd@gmail.com", "qdfd1112DDF22")
                .accountName();
        Assert.assertEquals(registerSuccess, "My account – Generic Shop");
    }

    @Test
    public void testLoginPage() {
        testRegisterAccount();
        List<String> loginAccount = new HomePage(driver)
                .goToAccountPage()
                .loginAccount("busd@gmail.com", "qdfd1112DDF22")
                .listItem();

        Assert.assertEquals(loginAccount, List.of("Dashboard", "Orders", "Downloads", "Addresses", "Account details", "Logout"));
    }

    @Test
    public void testLogout() {
        testLoginPage();
        Boolean logOut = new HomePage(driver)
                .goToAccountPage()
                .clickLogout()
                .checkLogOut();

        Assert.assertTrue(logOut, "Not Log Out");
    }

}
