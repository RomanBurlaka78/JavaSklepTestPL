package automation.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderMenuPage extends  BasePage {
    public HeaderMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@id = 'desktop-menu']/li/a")
    List<WebElement> getMenuList;

    @Step("Get list of menu elements in header")
    public List <String> headerMenuList() {

        return getMenuList
                .stream()
                .map(WebElement::getText)
                .map(link -> link.split(",")[0].trim())
                .collect(Collectors.toList());

    }
}
