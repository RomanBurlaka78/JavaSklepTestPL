package automation.model;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ErrorPage extends BasePage {
    @FindBy(xpath = "//ul[@class = 'woocommerce-error']/li")
    private WebElement getError;
    @FindBy(xpath = "//ul[@class = 'woocommerce-error']")
    private WebElement error;

    public ErrorPage(WebDriver driver) {
        super(driver);
    }


    public String errorMessage() {
        String notError = "notError";
        try {
            getWaitForElement(getError, 5);
            if (getError.isDisplayed()) {
                notError = getError.getText();
            }
        } catch (Exception e) {
            return notError;
        }
        return notError;
    }




}
