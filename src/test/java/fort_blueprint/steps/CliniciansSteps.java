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
import static fort_blueprint.constants.Path.CLINICIAN;
import static fort_blueprint.constants.Path.CLINICIANS;
import static fort_blueprint.constants.Url.BASE_URI;
import static fort_blueprint.core.request_builder.RequestBuilder.makeGetRequest;
import static fort_blueprint.utils.ApiUtils.getClinicianId;
import static org.assertj.core.api.Assertions.assertThat;

public class CliniciansSteps {
    @Inject
    ScenarioContext context;

    @Given("Authorized user exists")
    public void authorizedUserExists() {
        context.set(AUTH_TOKEN, AuthUtils.getAccessToken(USER_EMAIL, USER_PASSWORD));
    }

    @When("User sends request for clinicians list")
    public void userSendsRequestForCliniciansList() {
        Response response = makeGetRequest(BASE_URI)
                .withBasePath(CLINICIANS)
                .withAuthToken(context.get(AUTH_TOKEN))
                .send();

        context.set(RESPONSE, response);
    }

    @When("User sends request for clinician")
    public void userSendsRequestForClinician() {
        Response response = makeGetRequest(BASE_URI)
                .withBasePath(CLINICIAN)
                .withPathParam("clinicianId", getClinicianId())
                .withAuthToken(context.get(AUTH_TOKEN))
                .send();

        System.out.println(response.prettyPrint());
        context.set(RESPONSE, response);
    }

    @Then("Status code is 200")
    public void statusCodeIs200() {
//        System.out.println(context.get(RESPONSE).prettyPrint());
        assertThat(context.get(RESPONSE).getStatusCode()).isEqualTo(200);
    }
}
