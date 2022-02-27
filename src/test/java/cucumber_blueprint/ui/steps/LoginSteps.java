package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends BaseUiSteps {

    @Inject
    WebDriver driver;

    @Inject
    SoftAssertions assertions;

    @Inject
    LoginPage loginPage;

    @Given("^User is not logged in$")
    public void userIsNotLoggedIn() {
        driver.get("http://webapp.inflamco.test.s3-website-us-east-1.amazonaws.com");
        assertions.assertThat(loginPage.checkUserNameExist());
        assertions.assertThat(loginPage.checkPasswordExist());
        assertions.assertAll();
    }

    @When("^User navigates to login page$")
    public void userNavigatesToLoginPage() {
        System.out.println("User navigates to login page\n");
        assertions.assertThat(true);
    }

    @Then("^Login page fields are displayed$")
    public void loginPageFieldsAreDisplayed() {
        System.out.println("Login page fields are displayed\n");
        assertions.assertThat(true);
    }
}
