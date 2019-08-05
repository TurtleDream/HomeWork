package steps;

import cucumber.api.java.ru.Когда;
import sberbankpages.SberbankPersonPage;
import utils.TestProperties;

import java.util.Properties;

public class SberbankPersonSteps {

    public static Properties properties = TestProperties.getInstance().getProperties();
    SberbankPersonPage sberbankPersonPage = new SberbankPersonPage();

    @Когда("Страница 'Сбербанк' загружена")
    public void pageLoaded() {
        sberbankPersonPage = new SberbankPersonPage();
    }

    @Когда("Клик на \"(.*)\"")
    public void click(String name) throws Exception {
        sberbankPersonPage.click(name);
    }
}
