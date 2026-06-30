package personal.saurav.pages.otherPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import personal.saurav.pages.BasePage;

public class CommonPageActions extends BasePage {
    // Target the specific iframe provided
    private final By googleAdFrame = By.id("aswift_7");


    public CommonPageActions(WebDriver driver){
        super(driver);
    }
}
