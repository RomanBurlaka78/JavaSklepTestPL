package automation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id = 'reg_email']")
    private WebElement emailRegister;

    @FindBy(xpath = "//input[@id = 'reg_password']")
    private WebElement passwordRegister;

    @FindBy(xpath = "//input[@name = 'register']")
    private WebElement buttonRegister;

    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameLogin;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordLogin;

    @FindBy(xpath = "//input[@name='login']")
    WebElement buttonLogin;

    @FindBy(xpath = "//nav[@class = 'woocommerce-MyAccount-navigation']/ul/li")
    List<WebElement> myAccountItems;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement getLogOutBtn;

    @FindBy(xpath = "//a[contains(text(), 'Log out')]")
    WebElement getConfirmLogOutBtn;


    public AccountPage registerAccount(String email, String password) {
        emailRegister.sendKeys(email);
        passwordRegister.clear();
        passwordRegister.sendKeys(password);
        buttonRegister.submit();

        return this;
    }

    public Boolean getWaitUntilButtonInvisible() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getWait5().until(ExpectedConditions.invisibilityOf(buttonRegister));

        return true;
    }

    public AccountPage loginAccount(String email, String password) {
        userNameLogin.sendKeys(email);
        passwordLogin.clear();
        passwordLogin.sendKeys(password);
        buttonLogin.click();

        return this;
    }

    public List<String> listItem() {

        return getWait10().until(ExpectedConditions.visibilityOfAllElements(myAccountItems))
                .stream()
                .map(WebElement::getText)
                .map(permalink -> permalink.split(",")[0].trim())
                .collect(Collectors.toList());
    }

    public AccountPage clickLogout() {
        getLogOutBtn.click();
        getConfirmLogOutBtn.click();

        return this;
    }

    public Boolean checkLogOut() {
        try {
            getWait10().until(ExpectedConditions.invisibilityOfAllElements(myAccountItems));
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
    }

    public String accountName() {

        return getDriver().getTitle();
    }


}
