package rosgosstrakhpages;

import io.qameta.allure.Step;
import library.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RosgosstrakhPage extends BasePage {

    @FindBy(css = "[data-toggle='dropdown']")
    private WebElement insurance;

    @FindBy(linkText = "ДМС")
    private WebElement voluntaryMedicalInsurance;

    public RosgosstrakhPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Go to RGS page")
    public RosgosstrakhPage goToRgs(){
        goToPage(webDriver,"https://www.rgs.ru/");
        return this;
    }

    @Step("Go to VMI page")
    public void goToVMI(){
        click(insurance);
        click(voluntaryMedicalInsurance);
    }
}