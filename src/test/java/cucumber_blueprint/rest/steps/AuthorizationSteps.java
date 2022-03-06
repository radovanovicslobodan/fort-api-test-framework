package cucumber_blueprint.rest.steps;

import com.google.inject.Inject;
import cucumber_blueprint.core.api.RestScenarioContext;
import cucumber_blueprint.rest.helpers.LoginHelpers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationSteps {

    @Inject
    private RestScenarioContext restScenarioContext;

    @When("Token request with username {string} and password {string} is sent")
    public void tokenRequestWithUserAndPassword(String username, String password) {
        restScenarioContext.response = LoginHelpers.postLogin(username, password);
    }

    @Then("Response contains token")
    public void responseContainsToken() {
        String auth_token = restScenarioContext.response.path("token").toString();
        assertThat(auth_token).isNotNull();
    }
}
