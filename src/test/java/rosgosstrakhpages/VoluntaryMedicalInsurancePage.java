package rosgosstrakhpages;

import io.qameta.allure.Step;
import library.BasePage;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VoluntaryMedicalInsurancePage extends BasePage {

    @FindBy(className = "content-document-header")
    private WebElement title;

    @FindBy(xpath = "//a[contains(text(),'Отправить заявку')]")
    private WebElement sendRequest;

    @FindBy(name = "LastName")
    private WebElement lastName;

    @FindBy(name = "FirstName")
    private WebElement firstName;

    @FindBy(name = "MiddleName")
    private WebElement middleName;

    @FindBy(name = "Region")
    private WebElement region;

    @FindBy(name = "Email")
    private WebElement email;

    @FindBy(name = "Comment")
    private WebElement comment;

    @FindBy(id = "button-m")
    private WebElement sendButton;

    @FindBy(xpath = "//label[contains(text(),'Я согласен на')]")
    private WebElement consent;

    @FindBy(xpath = "//*[@id=\"applicationForm\"]/div[2]/div[5]/input")
    private WebElement phoneNumber;

    @FindBy(className = "validation-error-text")
    private WebElement errorText;

    @FindBy(className = "form-group col-md-12 col-xs-12")
    private WebElement regionLable;

    @FindBy(css = "[value='77']")
    private WebElement msk;

    public VoluntaryMedicalInsurancePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check title")
    public VoluntaryMedicalInsurancePage checkTitle(){
        Assert.assertTrue(title.getText().contains("добровольное медицинское страхование"));
        return this;
    }

    @Step("Send request")
    public VoluntaryMedicalInsurancePage sendRequest(){
        click(sendRequest);
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

        Actions actions = new Actions(this.webDriver);
        actions.moveToElement(sendRequest).click().build().perform();

        Assert.assertTrue(errorText.getText().contains("Введите адрес электронной почты"));

        email.clear();
        setText(email, jsonObject.get("email").toString() + "@qwerty.ru");

        return this;
    }
}