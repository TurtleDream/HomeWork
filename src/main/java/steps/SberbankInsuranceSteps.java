package steps;

import cucumber.api.java.ru.Когда;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import sberbankpages.SberbankInsurancePage;
import utils.DriverManager;

public class SberbankInsuranceSteps {

    SberbankInsurancePage sberbankInsurancePage = null;

    @Когда("Страница 'Страхование' загружена")
    public void pageLoaded() throws Exception {
        sberbankInsurancePage = new SberbankInsurancePage();
    }

    @Когда("Проверить заголовок текст \"(.*)\"")
    public void checkTitle(String title){
        Assert.assertTrue(DriverManager.getDriver().getPageSource().contains(title));
    }

    @Когда("Кликнуть на \"(.*)\"")
    public void click(String name) throws Exception {
        sberbankInsurancePage.click(name);
    }

    @Когда("Записать в поле \"(.*)\" значение \"(.*)\"")
    public void fillField(String name, String value) throws Exception {
        Thread.sleep(1000);
        sberbankInsurancePage.fillField(name, value);
    }

//    @Когда("Выбрать регион \"(.*)\"")
//    public void select (String code){
//        Select select = new Select(sberbankInsurancePage.region);
//        select.selectByValue(code);
//    }

    @Когда("Проверить значение \"(.*)\" в поле \"(.*)\"")
    public void checkText(String value, String name) throws Exception {
        Thread.sleep(1000);
        Assert.assertEquals(
                sberbankInsurancePage.getField(name).getAttribute("value"),
                value);
    }
}
