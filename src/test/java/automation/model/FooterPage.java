package automation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class FooterPage extends BasePage {

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'tagcloud']/a")
    List<WebElement> tags;


    public List<String> list() {
        return tags.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
