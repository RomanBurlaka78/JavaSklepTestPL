package automation.model;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MostWantedPage extends BasePage {

    public MostWantedPage(WebDriver driver) {
        super(driver);
    }

    public int showUrlIndexOf() {
        String url = driver.getCurrentUrl();

        return url.indexOf("/most-wanted/");

    }
    public boolean showUrlContains() {

      return driver.getCurrentUrl().contains("/most-wanted/");
    }

    public  int showUrlStringUtilsContainsIgnoreCase() {

        return   StringUtils.compareIgnoreCase(driver.getCurrentUrl(),"/most-wanted/");
    }


}
