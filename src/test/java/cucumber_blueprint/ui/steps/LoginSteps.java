package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static cucumber_blueprint.utils.ConfigUtils.getUrl;

public class LoginSteps extends BaseUiSteps {

    @Inject
    LoginPage loginPage;

    @Given("User is not logged in")
    public void userIsNotLoggedIn() {
        driver.manage().deleteAllCookies();
    }

    @When("User navigates to {string} page")
    public void userNavigatesToPage(String path) throws IOException {
        driver.get(getUrl(path));
    }

    @Then("Login page fields are displayed")
    public void loginPageFieldsAreDisplayed() {
        assertions.assertThat(loginPage.checkUserNameExist());
        assertions.assertThat(loginPage.checkPasswordExist());
        assertions.assertAll();
    }
}
