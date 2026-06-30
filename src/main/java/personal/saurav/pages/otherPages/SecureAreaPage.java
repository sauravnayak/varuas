package personal.saurav.pages.otherPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import personal.saurav.pages.BasePage;

public class SecureAreaPage extends BasePage {

    private final By loginMessage= By.xpath("//*[@id='flash']//b");
    private final By logoutButton = By.cssSelector(".icon-2x.icon-signout");



    public SecureAreaPage(WebDriver driver){
        super(driver);
    }

    public void verifyLoginSuccess(){
        Assert.assertEquals(getText(loginMessage),"You logged into a secure area!");
    }
    public void verifyLogoutSucces(){
        click(logoutButton);
        Assert.assertEquals(getText(loginMessage),"You logged out of the secure area!");
    }

}
