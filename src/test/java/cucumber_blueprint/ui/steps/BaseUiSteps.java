package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public abstract class BaseUiSteps {

    WebDriver driver;

    SoftAssertions assertions;

    @Inject
    public BaseUiSteps(WebDriver driver, SoftAssertions assertions) {
        this.driver = driver;
        this.assertions = assertions;
    }
}
