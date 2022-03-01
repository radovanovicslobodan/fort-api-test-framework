package cucumber_blueprint.core.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Inject
    WebDriver driver;

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {
        String something = "ABC";
        System.out.println("Scenario: " + scenario.getName() + " started");
    }

    @After(order = 1)
    public void afterUiScenario() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        System.out.println("Scenario: " + scenario.getName() + " finished");
    }
}
