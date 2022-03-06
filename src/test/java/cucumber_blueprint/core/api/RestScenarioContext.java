package cucumber_blueprint.core.api;

import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@ScenarioScoped
public class RestScenarioContext {

    public Response response;
    public RequestSpecification requestSpec;
}
