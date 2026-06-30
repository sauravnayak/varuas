package tests.Regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import personal.saurav.data.BrowserData;
import personal.saurav.driver.DriverManager;
import personal.saurav.pages.otherPages.LoginPage;
import personal.saurav.pages.otherPages.SecureAreaPage;
import tests.BaseTest;

import static personal.saurav.driver.DriverManager.getDriver;

public class HomeTest extends BaseTest {


    @Test(enabled = true)
    public void start() {

        navigateTo("/login");
        LoginPage loginPage = new LoginPage(getDriver());
        //loginPages.login("practice","SuperSecretPassword!").verifyLoginSuccess();
        SecureAreaPage secureAreaPage =  loginPage.login("practice","SuperSecretPassword!");
        secureAreaPage.verifyLoginSuccess();
        secureAreaPage.verifyLogoutSucces();

    }


}
