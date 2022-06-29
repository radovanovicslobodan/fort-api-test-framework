package fort_blueprint.steps;

import com.google.inject.Inject;
import fort_blueprint.core.api.ScenarioContext;
import fort_blueprint.utils.AuthUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static fort_blueprint.constants.ContextProp.RESPONSE;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationSteps {

    @Inject
    private ScenarioContext context;

    @When("Token request with username {string} and password {string} is sent")
    public void tokenRequestWithUsernameAndPasswordSent(String username, String password) {
        context.set(RESPONSE, AuthUtils.postCreateAuthToken(username, password));
    }

    @Then("Response status code is {int}")
    public void responseStatusIs(int statusCode) {
        assertThat(context.get(RESPONSE).getStatusCode()).isEqualTo(statusCode);
    }

    @And("Response contains token")
    public void responseContainsToken() {
        String token = context.get(RESPONSE).path("token").toString();
        assertThat(token).isNotNull();
    }
}
