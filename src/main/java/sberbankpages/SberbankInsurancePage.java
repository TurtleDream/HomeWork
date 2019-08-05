package sberbankpages;

import annotations.FieldName;
import cucumber.api.java.ru.Когда;
import io.qameta.allure.Step;
import library.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;

public class SberbankInsurancePage extends BasePage {

    @FieldName(name = "Мин сумма страхования")
    @FindBy (xpath = "//div[@class='b-form-prog-block ng-scope'][1]")
    public WebElement minSumInsurance;

    @FieldName(name = "Оформить")
    @FindBy (xpath = "//span[contains(text(), 'Оформить')]")
    public WebElement issue;

    @FieldName(name = "Фамилия застрахованного")
    @FindBy (xpath = "//input[@name='insured0_surname']")
    public WebElement surnameField;

    @FieldName(name = "Имя застрахованного")
    @FindBy (xpath = "//input[@name='insured0_name']")
    public WebElement givenNamesField;

    @FieldName(name = "ДР застрахованного")
    @FindBy (xpath = "//input[@name='insured0_birthDate']")
    public WebElement dateOfBirth;

    @FieldName(name = "Фамилия")
    @FindBy (xpath = "//input[@name='surname']")
    public WebElement surname;

    @FieldName(name = "Имя")
    @FindBy (xpath = "//input[@name='name']")
    public WebElement name;

    @FieldName(name = "Отчество")
    @FindBy (xpath = "//input[@name='middlename']")
    public WebElement middlename;

    @FieldName(name = "ДР")
    @FindBy (xpath = "//input[@name='birthDate']")
    public WebElement birthDate;

    @FieldName(name = "М")
    @FindBy (xpath = "male")
    public WebElement male;

    @FieldName(name = "Ж")
    @FindBy (xpath = "female")
    public WebElement female;

    @FieldName(name = "Серия")
    @FindBy (xpath = "//input[@name='passport_series']")
    public WebElement passport_series;

    @FieldName(name = "Номер")
    @FindBy (xpath = "//input[@name='passport_number']")
    public WebElement passport_number;

    @FieldName(name = "Дата выдачи")
    @FindBy (xpath = "//input[@name='issueDate']")
    public WebElement issueDate;

    @FieldName(name = "Место")
    @FindBy (xpath = "//textarea[@name='issuePlace']")
    public WebElement issuePlace;

    @FieldName(name = "Продолжить")
    @FindBy (xpath = "//span[contains(text(), 'Продолжить')]")
    public WebElement continueButton;

    @FieldName(name = "Ошибка")
    @FindBy (xpath = "//div[contains(text(), 'Заполнены не все обязательные поля')]")
    public WebElement errorMsg;

//    @Step("Select min sum insurance")
//    public void policySelection (){
//        click(minSumInsurance);
//        click(issue);
//    }
//
//    @Step("Fill in the form")
//    public void formFilling (Map<String, String> map) {
//        setText(surnameField, map.get("engFirstName"));
//        setText(givenNamesField, map.get("engLastName"));
//        setText(dateOfBirth, map.get("dateOfBirth"));
//        setText(surname, map.get("lastName"));
//        setText(name, map.get("firstName"));
//        setText(middlename, map.get("middleName"));
//        setText(birthDate, map.get("dateOfBirthS"));
//
//        if(map.get("sex") == "f") {
//            click(female);
//        }
//
//        setText(passport_series, map.get("passportSeries"));
//        setText(passport_number, map.get("passportNumber"));
//        setText(issueDate, map.get("dateOfIssue"));
//        setText(issuePlace, map.get("issuedBy"));
//    }
//
//    @Step("Check form")
//    public void checkFilling (Map<String, String> map){
//        Assert.assertEquals(
//                "",
//                map.get("engFirstName"),
//                surnameField.getAttribute("value"));
//        Assert.assertEquals(
//                "",
//                map.get("engLastName"),
//                givenNamesField.getAttribute("value"));
//        Assert.assertEquals(
//                "",
//                map.get("dateOfBirth"),
//                dateOfBirth.getAttribute("value").replace(".",""));
//        Assert.assertEquals(
//                "",
//                map.get("lastName"),
//                surname.getAttribute("value"));
//        Assert.assertEquals(
//                "",
//                map.get("firstName"),
//                name.getAttribute("value"));
//        Assert.assertEquals(
//                "",
//                map.get("middleName"),
//                middlename.getAttribute("value"));
//        Assert.assertEquals(
//                "",
//                map.get("dateOfBirthS"),
//                birthDate.getAttribute("value").replace(".",""));
//        Assert.assertEquals(
//                "",
//                map.get("passportSeries"),
//                passport_series.getAttribute("value"));
//        Assert.assertEquals(
//                "",
//                map.get("passportNumber"),
//                passport_number.getAttribute("value"));
//        Assert.assertEquals(
//                "",
//                map.get("dateOfIssue"),
//                issueDate.getAttribute("value").replace(".",""));
//        Assert.assertEquals(
//                "",
//                map.get("issuedBy"),
//                issuePlace.getAttribute("value"));
//
//        if(map.get("sex") == "m") Assert.assertTrue(
//                "Ошибка!\n Ожидалось: " + map.get("sex"),
//                male.isSelected());
//        else if (map.get("sex") == "f") Assert.assertTrue(
//                "Ошибка!\n Ожидалось: " + map.get("sex"),
//                female.isSelected());
//    }
//
//    @Step("Check error message")
//    public void checkErrorMsg(){
//        click(continueButton);
//        Assert.assertEquals(
//                "Ошибка!\n" +
//                        "Ожидалось: Заполнены не все обязательные поля\n" +
//                        "Получено: " + errorMsg.getAttribute("value"),
//                "Заполнены не все обязательные поля",
//                errorMsg.getText());
//    }

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "sberbankpages.SberbankInsurancePage");
    }
}