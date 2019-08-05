package steps;

import cucumber.api.java.ru.Когда;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import rosgosstrakhpages.VoluntaryMedicalInsurancePage;
import utils.DriverManager;

public class VoluntaryMedicalInsuranceSteps {

    VoluntaryMedicalInsurancePage voluntaryMedicalInsurancePage = null;

    @Когда("Страница 'ДМС' загружена")
    public void pageLoaded() throws Exception {
        voluntaryMedicalInsurancePage = new VoluntaryMedicalInsurancePage();
    }

    @Когда("Проверить заголовок на наличие текста \"(.*)\"")
    public void checkTitle(String title){
        Assert.assertTrue(DriverManager.getDriver().getPageSource().contains(title));
    }

    @Когда("Нажатие на \"(.*)\"")
    public void click(String name) throws Exception {
        voluntaryMedicalInsurancePage.click(name);
    }

    @Когда("Заполнить поле \"(.*)\" значением \"(.*)\"")
    public void fillField(String name, String value) throws Exception {
        voluntaryMedicalInsurancePage.fillField(name, value);
    }

    @Когда("Выбрать регион \"(.*)\"")
    public void select (String code){
        Select select = new Select(voluntaryMedicalInsurancePage.region);
        select.selectByValue(code);
    }

    @Когда("Проверка значения \"(.*)\" в поле \"(.*)\"")
    public void checkText(String value, String name) throws Exception {
        Thread.sleep(1000);
        Assert.assertEquals(
                voluntaryMedicalInsurancePage.getField(name).getAttribute("value"),
                value);
    }

    @Когда("Проверить выбранный регион")
    public void checkSelectRegion (){
        Select select = new Select(voluntaryMedicalInsurancePage.region);
        Assert.assertTrue(select.getAllSelectedOptions().contains(voluntaryMedicalInsurancePage.msk));
    }

    @Когда("Отправить заявку")
    public void sendRequest (){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(voluntaryMedicalInsurancePage.sendRequest).click().build().perform();
    }
}
