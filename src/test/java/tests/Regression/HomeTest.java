package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import personal.saurav.driver.DriverManager;

public class HomeTest extends  BaseTest{


    @Test
    public void start() throws InterruptedException {
        DriverManager.getDriver().get("https://practice.expandtesting.com/login");
        DriverManager.getDriver().findElement(By.id("username")).sendKeys("practice");
        Thread.sleep(2000);
                ////a[@href='/login' and text()='Try it out']

    }

}
