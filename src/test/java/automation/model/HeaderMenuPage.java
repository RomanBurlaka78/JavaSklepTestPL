package automation.model;

import io.qameta.allure.Step;
import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;


public class HeaderMenuPage extends BasePage {
    public HeaderMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@id = 'desktop-menu']/li/a")
    List<WebElement> getMenuList;

    @FindBy(xpath = "//li[@class = 'top-email']/a")
     WebElement  getMailLink;

    @FindBy(xpath = "//li/a[@href]")
    public static  List<WebElement> allLinks;

    @Step("Get list of menu elements in header")
    public  List<String> headerMenuList() {

        return getMenuList
                .stream()
                .map(WebElement::getText)
                .map(link -> link.split(",")[0].trim())
                .collect(Collectors.toList());

    }

    @Step("Get list of menu links in header")
    public List<String> headerMenuLink() {
        List<String> menuLinks = getMenuList.stream()
                .map(link -> link.getAttribute("href"))
                .filter(url -> url != null && !url.isEmpty())
                .collect(Collectors.toList());

        return menuLinks;
    }

    @Step("Get response(int) from menu links")
    public int response() {
        List<String> menuLinks = getMenuList
                .stream()
                .map(link -> link.getAttribute("href"))
                .filter(url -> url != null && !url.isEmpty())
                .collect(Collectors.toList());

        int responseResult = 200;
        for (String menuLink : menuLinks) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(menuLink))
                    .method("HEAD", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            try {
                HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
                int responseCode = response.statusCode();

                // Przykład logiki - jeśli którykolwiek kod odpowiedzi jest 400 lub wyższy, ustaw wynik na ten kod
                if (responseCode != 200) {
                    responseResult = responseCode;
                }

            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }

        return responseResult;
    }

    @Step("Get response from mail link")
    public int responseFromMail() {
        int responseMail = 0;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getMailLink.getAttribute("href")))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
            responseMail = response.statusCode();

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        return responseMail;
    }

    public int checkLink(List<WebElement> element) {
        List<String> menuLinks = element
                .stream()
                .map(link -> link.getAttribute("href"))
                .filter(url -> url != null && !url.isEmpty())
                .collect(Collectors.toList());

        int responseResult = 200;
        for (String menuLink : menuLinks) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(menuLink))
                    .method("HEAD", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            try {
                HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
                int responseCode = response.statusCode();

                if (responseCode != 200) {
                    responseResult = responseCode;
                }

            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }

        return responseResult;
    }


}

