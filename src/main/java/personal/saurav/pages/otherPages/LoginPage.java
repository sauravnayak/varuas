package personal.saurav.pages.otherPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import personal.saurav.pages.BasePage;

public class LoginPages extends BasePage {

    private final By userNameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("submit-login");
    private final By adFrame = By.id("aswift_7");

    public LoginPages(WebDriver driver) {
        super(driver);
    }

    public SecureAreaPage login(String username, String password) {
        // 1. Vaporize the ad frame if it loads up on page initialization
        removeAdsFromDOM();

        // 2. Interact with fields securely
        writeText(userNameField, username);
        writeText(passwordField, password);
        click(submitButton);
        return new SecureAreaPage(driver);
    }

}
