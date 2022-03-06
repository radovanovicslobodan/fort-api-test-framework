package cucumber_blueprint.rest.steps;

import com.google.inject.Inject;
import cucumber_blueprint.core.api.RestScenarioContext;
import cucumber_blueprint.rest.helpers.LoginHelpers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    @Inject
    private RestScenarioContext restScenarioContext;

    @When("Login request with username {string} and password {string} is sent")
    public void loginWithUserAndPassword(String username, String password) {
        restScenarioContext.response = LoginHelpers.postLogin(username, password);
    }

    @Then("Response status code is {int}")
    public void responseStatusIs(int statusCode) {
        assertThat(restScenarioContext.response.getStatusCode()).isEqualTo(statusCode);
    }
}
