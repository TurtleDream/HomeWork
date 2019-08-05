package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class DriverManager {

    private static Properties properties = TestProperties.getInstance().getProperties();
    private static WebDriver webDriver = null;

    public static WebDriver getDriver(){
        if (webDriver == null){
            webDriver = createDriver();
        }
        return webDriver;
    }

    public static void quitDriver(){
        if (webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }

    private static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        return webDriver = new ChromeDriver();
    }
}