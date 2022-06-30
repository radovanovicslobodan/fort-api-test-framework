package fort_blueprint.steps;

import com.google.inject.Inject;
import fort_blueprint.core.api.ScenarioContext;
import fort_blueprint.utils.AuthUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static fort_blueprint.constants.ContextProp.AUTH_TOKEN;
import static fort_blueprint.constants.ContextProp.RESPONSE;
import static fort_blueprint.constants.Credential.USER_EMAIL;
import static fort_blueprint.constants.Credential.USER_PASSWORD;
import static fort_blueprint.constants.Path.CAREGIVERS;
import static fort_blueprint.constants.Url.BASE_URI;
import static fort_blueprint.core.request_builder.PutRequestBuilder.makePutRequest;
import static fort_blueprint.utils.ApiUtils.getCaregiverId;
import static org.assertj.core.api.Assertions.assertThat;

public class CaregiversSteps {
    @Inject
    ScenarioContext context;

    @Given("Authorized caregiver exists")
    public void authorizedCaregiverExists() {
        context.set(AUTH_TOKEN, AuthUtils.getAccessToken(USER_EMAIL, USER_PASSWORD));
    }

    @When("User sends request to add a child")
    public void userSendsRequestToAddAChild() {
        String body = "{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"dateOfBirth\": \"2000-06-29\",\n" +
                "  \"sexAtBirth\": \"MALE\",\n" +
                "  \"child\": {\n" +
                "    \"firstName\": \"Johnny\",\n" +
                "    \"lastName\": \"Doe\",\n" +
                "    \"dateOfBirth\": \"2017-06-29\",\n" +
                "    \"sexAtBirth\": \"MALE\",\n" +
                "    \"pronouns\": \"HE_HIM_HIS\"\n" +
                "  }\n" +
                "}";

        String caregiverId = getCaregiverId(context.get(AUTH_TOKEN));

        Response response = makePutRequest(BASE_URI)
                .withBasePath(CAREGIVERS)
                .withPathParam("caregiverId", caregiverId)
                .withAuthToken(context.get(AUTH_TOKEN))
                .withBody(body)
                .send();

        context.set(RESPONSE, response);
    }

    @Then("Caregiver is updated")
    public void caregiverIsUpdated() {
        assertThat(context.get(RESPONSE).getStatusCode()).isEqualTo(200);
    }
}
