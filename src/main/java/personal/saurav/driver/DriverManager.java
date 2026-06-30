package personal.saurav.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return  driver.get();
    }

    private DriverManager(){}

    public static void quit(){
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // Removes the driver from the current thread completely
        }
    }
    public static void setDriver(WebDriver driverInstance){
        driver.set(driverInstance);
    }

    public static String getInfo(){
        var cap = ((RemoteWebDriver )DriverManager.getDriver()).getCapabilities();
        String browserName =cap.getBrowserName();
        String platform =cap.getPlatformName().toString();
        String version = cap.getBrowserVersion();
        return String.format("browser: %s Version: %s  platform: %s", browserName, version, platform);

    }
}
