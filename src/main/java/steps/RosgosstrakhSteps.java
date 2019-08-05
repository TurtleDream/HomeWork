package steps;

import cucumber.api.java.ru.Когда;
import rosgosstrakhpages.RosgosstrakhPage;

public class RosgosstrakhSteps {

    RosgosstrakhPage rosgosstrakhPage = null;

    @Когда("Страница 'Росгосстрах' загружена")
    public void pageLoaded() {
        rosgosstrakhPage = new RosgosstrakhPage();
    }

    @Когда("Нажать на \"(.*)\"")
    public void click(String name) throws Exception {
        rosgosstrakhPage.click(name);
    }
}
