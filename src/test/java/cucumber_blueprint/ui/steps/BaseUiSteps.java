package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public abstract class BaseUiSteps {

    @Inject
    WebDriver driver;

    @Inject
    SoftAssertions assertions;
}
