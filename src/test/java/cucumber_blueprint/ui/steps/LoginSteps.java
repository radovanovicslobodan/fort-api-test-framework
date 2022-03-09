package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.ui.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import static cucumber_blueprint.utils.ConfigUtils.getUrl;

public class LoginSteps extends BaseUiSteps {

    @Inject
    JavascriptExecutor js;

    @Inject
    LoginPage loginPage;

    @When("User navigates to {string} page")
    public void userNavigatesToPage(String path) {
        js.executeScript("alert('Welcome to Guru99');");
        driver.get(getUrl(path));
    }

    @Then("Login page fields are displayed")
    public void loginPageFieldsAreDisplayed() {
        assertions.assertThat(loginPage.checkUserNameExist());
        assertions.assertThat(loginPage.checkPasswordExist());
        assertions.assertAll();
    }
}
