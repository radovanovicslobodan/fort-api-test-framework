package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.core.driver.support.DriverHelpers;
import io.cucumber.java.en.Given;

public class CommonSteps extends BaseUiSteps {

    @Inject
    DriverHelpers driverHelpers;

    @Given("User is not logged in")
    public void userIsNotLoggedIn() {
        driver.manage().deleteAllCookies();
    }
}
