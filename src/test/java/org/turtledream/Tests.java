package org.turtledream;

import io.qameta.allure.Step;
import org.junit.Ignore;
import library.BaseTest;
import org.json.simple.JSONObject;
import org.junit.Test;
import rosgosstrakhpages.RosgosstrakhPage;
import rosgosstrakhpages.VoluntaryMedicalInsurancePage;
import sberbankpages.SberbankInsurancePage;
import sberbankpages.SberbankPersonPage;
import sberbankpages.TravelsAndPurchasesPage;

import java.util.HashMap;
import java.util.Map;

public class Tests extends BaseTest {

    @Ignore
    @Test
    @Step("Start rosgosstrakh test")
    public void rosgosstrakhTest(){
        RosgosstrakhPage rosgosstrakhPage = new RosgosstrakhPage(webDriver);
        VoluntaryMedicalInsurancePage voluntaryMedicalInsurancePage = new VoluntaryMedicalInsurancePage(webDriver);
        JSONObject personalInfo = new JSONObject();
        personalInfo.put("lastName", "Иванов");
        personalInfo.put("firstName", "Иван");
        personalInfo.put("middleName", "Иванович");
        personalInfo.put("phoneNumber", " (987) 654-32-10");
        personalInfo.put("email", "qwertyqwerty");
        personalInfo.put("comment", "Здесь могла быть ваша реклама");

        rosgosstrakhPage
                .goToRgs();
        rosgosstrakhPage
                .goToVMI();

        voluntaryMedicalInsurancePage
                .checkTitle()
                .sendRequest();

        voluntaryMedicalInsurancePage.checkPageForText("Заявка на добровольное медицинское страхование");

        voluntaryMedicalInsurancePage.fillInTheForm(personalInfo);

        voluntaryMedicalInsurancePage.checkForm(personalInfo);
    }

    @Ignore
    @Test
    @Step("Start sberbank test")
    public void sberbankTest() {
        SberbankPersonPage sberbankPersonPage = new SberbankPersonPage(BaseTest.webDriver);
        TravelsAndPurchasesPage travelsAndPurchasesPage = new TravelsAndPurchasesPage(BaseTest.webDriver);
        SberbankInsurancePage sberbankInsurancePage = new SberbankInsurancePage(BaseTest.webDriver);
        Map<String, String> personalInfo = new HashMap<String, String>();
        personalInfo.put("engFirstName", "Petr");
        personalInfo.put("engLastName", "Petrov");
        personalInfo.put("dateOfBirth", "12041995");
        personalInfo.put("firstName", "Сидр");
        personalInfo.put("lastName", "Сидоров");
        personalInfo.put("middleName", "Сидорович");
        personalInfo.put("dateOfBirthS", "11051993");
        personalInfo.put("sex", "m");
        personalInfo.put("passportSeries", "4815");
        personalInfo.put("passportNumber", "162342");
        personalInfo.put("dateOfIssue", "15012013");
        personalInfo.put("issuedBy", "Puten");

        sberbankPersonPage.goToSberPerson();
        sberbankPersonPage.goToTravelsAndPurchases();

        travelsAndPurchasesPage.checkPageForText("Страхование путешественников");
        travelsAndPurchasesPage.clickMakeOnlineButton();

        sberbankInsurancePage.policySelection();
        sberbankInsurancePage.formFilling(personalInfo);
        sberbankInsurancePage.checkFilling(personalInfo);
        sberbankInsurancePage.checkErrorMsg();
    }
}
