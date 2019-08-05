package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void startScenario() {
        WebDriver webDriver;
        webDriver = DriverManager.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @After
    public void afterMethod(Scenario scenario) {
        if(scenario.isFailed()){
            takeScreenshot();
        }
        DriverManager.quitDriver();
    }

    @Attachment(type = "image/png", value = "Скриншот в момент ошибки")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Когда("Перейти на сайт 'Россгосстрах'")
    public void goToPage () {
        DriverManager.getDriver().get(properties.getProperty("app.url.rosgosstrakh"));
    }

    @Когда("Перейти на сайт 'Сбербанк'")
    public void goToSber () {
        DriverManager.getDriver().get(properties.getProperty("app.url.sberbank"));
    }

}
