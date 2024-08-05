package automation.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Generic Shop')]")
    private WebElement getTitle;

    private final By accountTitle = By.xpath(" //li[@class='top-account']/a/i");

    public String getTitleOfPage() {
        return getTitle.getText();
    }

    public void accountClick() {
        wait2.until(ExpectedConditions.visibilityOf(getTitle));
        getWaitForElement(getTitle,3);
        driver.findElement(accountTitle).click();

    }


}
