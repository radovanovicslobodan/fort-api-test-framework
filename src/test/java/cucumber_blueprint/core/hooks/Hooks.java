package cucumber_blueprint.core.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {
        System.out.println("Scenario: " + scenario.getName() + " started");
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        System.out.println("Scenario: " + scenario.getName() + " finished");
    }
}
