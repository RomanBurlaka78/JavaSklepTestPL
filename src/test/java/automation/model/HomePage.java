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

    @FindBy(xpath = "//a[@href = 'https://skleptest.pl']")
    private WebElement getShopLink;

    @FindBy(xpath = "//a[@href = 'https://skleptest.pl/product-category/most-wanted/']")
    private WebElement getMostWantedLink;

    @FindBy(xpath = "/")
    private WebElement getCategoriesLink;

    @FindBy(xpath = "//a[contains(text(), 'About Us')]")
    private WebElement getAboutUsLink;

    @FindBy(xpath = "//a[contains(text(), 'Contact')]")
    private WebElement getContactLink;

    @FindBy(xpath = "//a[@href = 'https://skleptest.pl/tag/all/']")
    private WebElement getBlogLink;
    private final By accountTitle = By.xpath(" //li[@class='top-account']/a/i");

    public String showTitleOfPage() {
        return getTitle.getText();
    }

    public void accountClick() {
        wait2.until(ExpectedConditions.visibilityOf(getTitle));
        getWaitForElement(getTitle,3);
        driver.findElement(accountTitle).click();

    }


}
