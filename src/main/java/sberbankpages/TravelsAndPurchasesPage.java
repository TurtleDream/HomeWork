package sberbankpages;

import annotations.FieldName;
import io.qameta.allure.Step;
import library.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelsAndPurchasesPage extends BasePage {

    @FieldName(name = "Закрыть")
    @FindBy(xpath = "//a[contains(text(),'Закрыть')]")
    public WebDriverWait closer;

    @Step("Switch tab")
    public void clickMakeOnlineButton(){
        switchTab("//a[contains (@href, 'viewCalc')]");
    }

    @Step("Check page")
    public void checkPageForText(String text) {
        Assert.assertTrue(checkPageContainsText(text));
    }

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "sberbankpages.TravelsAndPurchasesPage");
    }
}
