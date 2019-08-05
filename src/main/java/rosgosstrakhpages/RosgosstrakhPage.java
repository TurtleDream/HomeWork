package rosgosstrakhpages;

import annotations.FieldName;
import library.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RosgosstrakhPage extends BasePage {

    @FieldName(name = "Страхование")
    @FindBy(xpath = "//a[contains(text(), 'Страхование')][@href='#']")
    public WebElement insurance;

    @FieldName(name = "ДМС")
    @FindBy(xpath = "//li[contains(@class, 'line3')]//a[contains(text(), 'ДМС')]")
    public WebElement voluntaryMedicalInsurance;

//    @Step("Go to RGS page")
//    public void goToRgs(){
//        goToPage(DriverManager.getDriver(),"https://www.rgs.ru/");
//    }

//    @Step("Go to VMI page")
//    public void goToVMI(){
//        cleck(insurance);
//        cleck(voluntaryMedicalInsurance);
//    }

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "rosgosstrakhpages.RosgosstrakhPage");
    }
}