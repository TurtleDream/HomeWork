package sberbankpages;

import io.qameta.allure.Step;
import library.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TravelsAndPurchasesPage extends BasePage {

    public TravelsAndPurchasesPage (WebDriver webDriver){
        super(webDriver);
    }

    @Step("Switch tab")
    public void clickMakeOnlineButton(){
        switchTab("//a[contains (@href, 'viewCalc')]");
    }

    @Step("Check page")
    public void checkPageForText(String text) {
        Assert.assertTrue(checkPageContainsText(text));
    }
}
