package automation;

import automation.model.FooterPage;
import automation.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FooterMenuTest extends BaseTest {


    @Test
    public void testCheckTags() {
        List<String> listTags = new FooterPage(driver)
                .list();

        List<String> list = List.of("Autumn", "dress", "fashion", "jackets", "stockings", "trends");

        Assert.assertEquals(listTags, list);
    }
}
