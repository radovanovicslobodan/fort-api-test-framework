package fort_blueprint.ui.steps;

import com.google.inject.Inject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public abstract class BaseUiSteps {

    @Inject
    WebDriver driver;

    @Inject
    SoftAssertions assertions;
}
