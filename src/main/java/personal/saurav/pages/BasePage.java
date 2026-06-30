package personal.saurav.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import personal.saurav.pages.otherPages.LoginPage;
import personal.saurav.pages.otherPages.SecureAreaPage;

import java.time.Duration;

import static personal.saurav.driver.DriverManager.getDriver;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver=driver;
        this.webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void writeText(By locator,String text){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    protected void click(By locator){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected  String getText(By locator){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected void removeElementFromDOM(By locator) {
        try {
            // Check for presence rather than absolute UI visibility to target background frames
            var element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", element);
        } catch (Exception e) {
            System.out.println("Ad frame not present or already absent. Skipping removal.");
        }
    }
    protected void removeAdsFromDOM() {
        try {
            // Run clean JS script to find and destroy common Google Ad containers instantly
            ((JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll('ins.adsbygoogle, iframe[id^=\"aswift\"], iframe[id^=\"google_ads\"]').forEach(el => el.remove());"
            );
        } catch (Exception e) {
            System.out.println("Failed to clear background ad nodes: " + e.getMessage());
        }
    }

    protected LoginPage loginPage() {
        return new LoginPage(getDriver());
    }

    protected SecureAreaPage secureAreaPage() {
        return new SecureAreaPage(getDriver());
    }
}
