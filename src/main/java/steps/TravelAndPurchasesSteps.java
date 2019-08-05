package steps;

import cucumber.api.java.ru.Когда;
import org.junit.Assert;
import sberbankpages.TravelsAndPurchasesPage;
import utils.DriverManager;

public class TravelAndPurchasesSteps {

    TravelsAndPurchasesPage travelsAndPurchasesPage = null;

    @Когда("Страница 'Путешествия' загружена")
    public void pageLoaded() throws Exception {
        travelsAndPurchasesPage = new TravelsAndPurchasesPage();
    }

    @Когда("Проверить заголовок на наличие \"(.*)\"")
    public void checkTitle(String title){
        Assert.assertTrue(DriverManager.getDriver().getPageSource().contains(title));
    }

    @Когда("Скрыть меню на \"(.*)\"")
    public void click(String name) throws Exception {
        travelsAndPurchasesPage.click(name);
    }

    @Когда("Оформить сейчас")
    public void switchTabTravels (){
        travelsAndPurchasesPage.clickMakeOnlineButton();
    }
}
