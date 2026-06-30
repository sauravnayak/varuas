package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import personal.saurav.data.BrowserData;
import personal.saurav.driver.DriverManager;
import personal.saurav.utils.PropertyReader;

import static personal.saurav.driver.DriverManager.getDriver;

public class BaseTest {

    protected final String BASE_URL = PropertyReader.getBaseURL();


    @BeforeTest(alwaysRun = true)
    public void preCondition() {
        ChromeOptions options = new ChromeOptions()
                .addArguments(BrowserData.chromeOptions());
        WebDriver driverInstance = new ChromeDriver(options);
        DriverManager.setDriver(driverInstance);
        getDriver().manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }

    public void navigateTo(String path) {
        getDriver().get(BASE_URL + path);
    }
}
