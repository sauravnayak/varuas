package tests.Regression;

import org.testng.annotations.Test;
import personal.saurav.pages.otherPages.LoginPage;
import personal.saurav.pages.otherPages.SecureAreaPage;
import tests.BaseTest;

import static personal.saurav.driver.DriverManager.getDriver;

public class HomeTest extends BaseTest {


    @Test()
    public void start() {

        navigateTo("/login");
        LoginPage loginPage = new LoginPage(getDriver());
        //loginPages.login("practice","SuperSecretPassword!").verifyLoginSuccess();
        SecureAreaPage secureAreaPage =  loginPage.login("practice","SuperSecretPassword!");
        secureAreaPage.verifyLoginSuccess();
        secureAreaPage.verifyLogoutSucces();

    }


}
