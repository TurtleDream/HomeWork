package sberbankpages;

import annotations.FieldName;
import io.qameta.allure.Step;
import library.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverManager;

public class SberbankPersonPage extends BasePage {

    @FieldName(name = "Страхование")
    @FindBy (xpath = "//span[contains(text(), 'Страхование')]//parent::button")
    public WebElement insurance;

    @FieldName(name = "Путешествия и покупки")
    @FindBy (xpath = "//li[@class='lg-menu__sub-item']//a[contains(text(), 'Страхование путешественников')]")
    public WebElement travelsAndPurchases;

//    @Step("Go to Sberbank Person")
//    public SberbankPersonPage goToSberPerson(){
//        goToPage(DriverManager.getDriver(),"http://www.sberbank.ru/ru/person");
//        return this;
//    }
//
//    @Step("Go to Travels and purchases page")
//    public void goToTravelsAndPurchases(){
//        click(insurance);
//        click(travelsAndPurchases);
//    }

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "sberbankpages.SberbankPersonPage");
    }
}