package library;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver webDriver;

    @BeforeClass
    public static void tearUp(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @After
    public void cleanUp(){
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    @AfterClass
    public static void tearDown(){
        webDriver.close();
    }
}
