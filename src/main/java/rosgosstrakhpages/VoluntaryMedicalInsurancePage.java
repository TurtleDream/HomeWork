package rosgosstrakhpages;

import annotations.FieldName;
import cucumber.api.java.ru.Когда;
import io.qameta.allure.Step;
import library.BasePage;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManager;

public class VoluntaryMedicalInsurancePage extends BasePage {

    @FieldName(name = "Заголовок")
    @FindBy(xpath = "//h1")
    public WebElement title;

    @FieldName(name = "Отправить заявку")
    @FindBy(xpath = "//a[contains(@href, '#')][contains(text(), 'Отправить')]")
    public WebElement sendRequest;

    @FieldName(name = "Фамилия")
    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FieldName(name = "Имя")
    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FieldName(name = "Отчество")
    @FindBy(xpath = "//input[@name='MiddleName']")
    public WebElement middleName;

    @FieldName(name = "Регион")
    @FindBy(xpath = "//select[@name='Region']")
    public WebElement region;

    @FieldName(name = "Почта")
    @FindBy(xpath = "//input[@name='Email']")
    public WebElement email;

    @FieldName(name = "Комментарий")
    @FindBy(xpath = "//textarea[@name='Comment']")
    public WebElement comment;

    @FieldName(name = "Отправить")
    @FindBy(xpath = "//button[@id='button-m']")
    public WebElement sendButton;

    @FieldName(name = "Согласие")
    @FindBy(xpath = "//label[contains(text(),'Я согласен на')]")
    public WebElement consent;

    @FieldName(name = "Телефон")
    @FindBy(xpath = "//*[@id=\"applicationForm\"]/div[2]/div[5]/input")
    public WebElement phoneNumber;

    @FieldName(name = "Ошибка")
    @FindBy(xpath = "//span[@class='validation-error-text']")
    public WebElement errorText;

    @FieldName(name = "Регион лейбл")
    @FindBy(xpath = "//div[@class='form-group col-md-12 col-xs-12'][1]")
    public WebElement regionLable;

    @FieldName(name = "Москва")
    @FindBy(xpath = "//option[@value='77']")
    public WebElement msk;

    @Step("Check title")
    public VoluntaryMedicalInsurancePage checkTitle(){
        Assert.assertTrue(title.getText().contains("добровольное медицинское страхование"));
        return this;
    }

    @Step("Send request")
    public VoluntaryMedicalInsurancePage sendRequest(){
        cleck(sendRequest);
        return this;
    }

    @Step("Check page for text")
    public VoluntaryMedicalInsurancePage checkPageForText(String text){
        Assert.assertTrue(checkPageContainsText(text));
        return this;
    }

    @Step("Fill in the form")
    public VoluntaryMedicalInsurancePage fillInTheForm(JSONObject jsonObject){
        setText(lastName, jsonObject.get("lastName").toString());
        setText(firstName, jsonObject.get("firstName").toString());
        setText(middleName, jsonObject.get("middleName").toString());
        setText(phoneNumber, jsonObject.get("phoneNumber").toString());
        setText(email, jsonObject.get("email").toString());
        setText(comment, jsonObject.get("comment").toString());

        Select select = new Select(region);
        select.selectByValue("77");

        return this;
    }

    @Step("Check form")
    public VoluntaryMedicalInsurancePage checkForm(JSONObject jsonObject){
        Assert.assertEquals(
                "\nError! \nExpected: "
                        + jsonObject.get("lastName").toString() +"\n Actualy: "
                        + lastName.getAttribute("value"),
                lastName.getAttribute("value"),
                jsonObject.get("lastName").toString());
        Assert.assertEquals(
                "\nError! \nExpected: "
                        + jsonObject.get("firstName").toString() +"\n Actualy: "
                        + firstName.getAttribute("value"),
                firstName.getAttribute("value"),
                jsonObject.get("firstName").toString());
        Assert.assertEquals(
                "\nError! \nExpected: "
                        + jsonObject.get("middleName").toString() +"\n Actualy: "
                        + middleName.getAttribute("value"),
                middleName.getAttribute("value"),
                jsonObject.get("middleName").toString());
        Assert.assertEquals(
                "\nError! \nExpected: +7"
                        + jsonObject.get("phoneNumber").toString() +"\n Actualy: "
                        + phoneNumber.getAttribute("value"),
                phoneNumber.getAttribute("value"),
                "+7" + jsonObject.get("phoneNumber").toString());
        Assert.assertEquals(
                "\nError! \nExpected: "
                        + jsonObject.get("email").toString() +"\n Actualy: "
                        + email.getAttribute("value"),
                email.getAttribute("value"),
                jsonObject.get("email").toString());
        Assert.assertEquals(
                "\nError! \nExpected: "
                        + jsonObject.get("comment").toString() +"\n Actualy: "
                        + comment.getAttribute("value"),
                comment.getAttribute("value"),
                jsonObject.get("comment").toString());

        Select select = new Select(region);
        Assert.assertTrue(select.getAllSelectedOptions().contains(msk));
        click(consent);

        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(sendRequest).click().build().perform();

        Assert.assertTrue(errorText.getText().contains("Введите адрес электронной почты"));

        email.clear();
        setText(email, jsonObject.get("email").toString() + "@qwerty.ru");

        return this;
    }

    @Override
    public WebElement getField(String name) throws Exception {
        return  getField(name, "rosgosstrakhpages.VoluntaryMedicalInsurancePage");
    }
}