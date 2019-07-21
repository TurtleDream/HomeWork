package sberbankpages;

import io.qameta.allure.Step;
import library.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SberbankPersonPage extends BasePage {

    @FindBy (xpath = "//span[contains(text(), 'Страхование')]")
    private WebElement insurance;

    @FindBy (xpath = "//a[contains(text(), 'Путешествия и покупки')]")
    private WebElement travelsAndPurchases;

    public SberbankPersonPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Go to Sberbank Person")
    public SberbankPersonPage goToSberPerson(){
        goToPage(webDriver,"http://www.sberbank.ru/ru/person");
        return this;
    }

    @Step("Go to Travels and purchases page")
    public void goToTravelsAndPurchases(){
        click(insurance);
        click(travelsAndPurchases);
    }
}