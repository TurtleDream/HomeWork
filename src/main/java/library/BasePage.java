package library;

import annotations.FieldName;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public abstract class BasePage {

    public static WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(), 60);
    private WebDriverWait webDriverWaitVisible;
    private WebDriverWait webDriverWaitClickable;


    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        webDriverWaitVisible = new WebDriverWait(DriverManager.getDriver(), 15);
        webDriverWaitClickable = new WebDriverWait(DriverManager.getDriver(), 15);
    }


    @Step("Go to page {url}")
    protected void goToPage(WebDriver webDriver, String url){
        webDriver.get(url);
    }

    @Step("Wait element : {webElement}")
    private void wait (WebElement webElement){
        webDriverWaitVisible.until(ExpectedConditions.visibilityOf(webElement));
        webDriverWaitClickable.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    @Step("Click to element: {webElement}")
    protected void cleck(WebElement webElement){
        wait(webElement);
        webElement.click();
    }

    @Step("Check page for text availability : {text}")
    protected boolean checkPageContainsText(String text){
        return DriverManager.getDriver().getPageSource().contains(text);
    }

    @Step("Set {text} in {webElement}")
    protected synchronized void setText(WebElement webElement, String text){
        wait(webElement);
        webElement.click();
        webElement.sendKeys(text);
    }

    @Step("Switch tab to : {tab}")
    protected void switchTab (String tab){
        Set<String> oldWindowsSet = DriverManager.getDriver().getWindowHandles();
        DriverManager.getDriver().findElement(By.xpath(tab)).click();
        Set<String> newWindowsSet = DriverManager.getDriver().getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        DriverManager.getDriver().switchTo().window(newWindowHandle);
    }

    public void fillField(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }

    public void fillField(String name, String value) throws Exception {
        WebElement element = getField(name);
        fillField(element, value);
    }

    public void checkText(WebElement webElement, String value) throws Exception {
        Assert.assertEquals(value, webElement.getText());
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void click(String name) throws Exception {
        WebElement element = getField(name);
        click(element);
    }

    public void selectItem(List<WebElement> menuItems, String itemName){
        for (WebElement item : menuItems ){
            if (item.getText().equalsIgnoreCase(itemName)){
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + itemName);
    }

    public WebElement getField(String name, String className) throws Exception {
        Class example = Class.forName(className);
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields){
            if (field.getAnnotation(FieldName.class).name().equals(name)){
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    public abstract WebElement getField(String name) throws Exception;
}