package automation;

import automation.model.HomePage;
import automation.runner.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({automation.listening.ListeningClass.class})

public class HomePageTest extends BaseTest {
    @Test
    @Epic("Web interface")
    @Description("This test attempts to check title of HomePage on the  website")
    @Owner("R B")
    @Link(name = "Website", url = "https://skleptest.pl/")
    @Issue("AUTH-1111")

    public void getTitleOfPageTest(){
        String showTitleOfPage = new HomePage(driver)
                .getTitleOfPage();


        Assert.assertEquals(showTitleOfPage, "Generic Shop");
    }

}
