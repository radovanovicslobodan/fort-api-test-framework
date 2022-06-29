package fort_blueprint.core.hooks;

import fort_blueprint.core.config_reader.EnvConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigCache;

@Slf4j
public class Hooks {
    public static EnvConfig envConfig;

    @BeforeAll
    public static void beforeAllScenarios() {
        envConfig = ConfigCache.getOrCreate(EnvConfig.class);
    }

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {
        log.info("Scenario: " + scenario.getName() + " started");
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        log.info("Scenario: " + scenario.getName() + " finished");
    }
}
