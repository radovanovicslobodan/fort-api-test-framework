package cucumber_blueprint.rest.helpers;

import cucumber_blueprint.constants.HttpMethod;
import cucumber_blueprint.constants.Paths;
import cucumber_blueprint.constants.Props;
import cucumber_blueprint.rest.pojos.AuthBody;
import cucumber_blueprint.utils.ApiUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static cucumber_blueprint.utils.ConfigUtils.getProp;

public class AuthHelpers {

    public static Response postCreateAuthToken(String username, String password) {

        AuthBody body = new AuthBody(username, password);

        RequestSpecBuilder builder = new RequestSpecBuilder();

        // Prepare request
        builder.setBaseUri(getProp(Props.BASE_REST_URI));
        builder.setBasePath(Paths.AUTH);
        builder.setContentType(ContentType.JSON);
        builder.setBody(body);
        RequestSpecification requestSpec = builder.build();

        return ApiUtils.sendRequest(requestSpec, HttpMethod.POST);
    }
}
