package automation.runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.module.Configuration;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
@Listeners({automation.listening.ListeningClass.class})

abstract public class BaseTest {
    protected WebDriver driver;
    public WebDriverWait wait2;
    public WebDriverWait wait5;
    public WebDriverWait wait10;

    public void getWeb() {
        driver.get("https://skleptest.pl/");
    }
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        getWeb();
    }

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


    @BeforeMethod
    public void BeforeTest() {
        setUp();
        getWeb();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
