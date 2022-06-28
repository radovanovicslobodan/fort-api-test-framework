package fort_blueprint.steps;

import com.google.inject.Inject;
import fort_blueprint.core.api.ScenarioContext;
import fort_blueprint.utils.AuthUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static fort_blueprint.constants.ContextProps.AUTH_TOKEN;
import static fort_blueprint.constants.ContextProps.RESPONSE;
import static fort_blueprint.constants.Credentials.USER_EMAIL;
import static fort_blueprint.constants.Credentials.USER_PASSWORD;
import static fort_blueprint.constants.Path.CLINICIANS;
import static fort_blueprint.constants.Url.BASE_URL;
import static fort_blueprint.core.request_builder.RequestBuilder.makeGetRequest;
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
//        Response response = given()
//                .header("Authorization", "Bearer " + context.get(AUTH_TOKEN))
//                .when()
//                .get("https://dev.forthealth.com/api/v1/clinicians")
//                .then()
//                .extract().response();

//        RequestSpecification requestSpec = requestSpecHelper(context.get(AUTH_TOKEN), "clinicians");
//
//        Response response1 = ApiUtils.sendRequest(requestSpec, Method.GET);

        Response response2 = makeGetRequest()
                .withBaseUri(BASE_URL)
                .withBasePath(CLINICIANS)
                .withAuthToken(context.get(AUTH_TOKEN))
                .send();

        context.set(RESPONSE, response2);
    }

    @Then("Status code is 200")
    public void statusCodeIs200() {
        System.out.println(context.get(RESPONSE).prettyPrint());
        assertThat(context.get(RESPONSE).getStatusCode()).isEqualTo(200);
    }
}
