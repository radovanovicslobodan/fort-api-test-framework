package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.After;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public abstract class BaseUiSteps {

    @Inject
    WebDriver driver;

    @Inject
    SoftAssertions assertions;

    public  void tearDown(){
        System.out.println("Tear Down");
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
