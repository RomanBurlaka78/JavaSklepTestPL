package automation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract  class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebDriverWait wait2;
    public WebDriverWait wait5;
    public WebDriverWait wait10;

    public  WebDriverWait getWait2() {
        wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));

        return wait2;
    }

    public  WebDriverWait getWait5() {
        wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));

        return wait5;
    }
    public  WebDriverWait getWait10() {
        wait10 = new WebDriverWait(driver, Duration.ofSeconds(2));

        return wait10;
    }

    public WebDriverWait getWaitForElement(WebElement element, int sec) {
        WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(sec));

        return wait;
    }
}
