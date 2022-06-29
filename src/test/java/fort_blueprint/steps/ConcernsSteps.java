package fort_blueprint.steps;

import com.google.inject.Inject;
import fort_blueprint.core.api.ScenarioContext;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static fort_blueprint.constants.ContextProp.RESPONSE;

public class ConcernsSteps {
    @Inject
    ScenarioContext context;

    @When("User try to get L1 concerns")
    public void userTryToGetL1Concerns() {
        Response response = null;

        context.set(RESPONSE, response);
    }
}
