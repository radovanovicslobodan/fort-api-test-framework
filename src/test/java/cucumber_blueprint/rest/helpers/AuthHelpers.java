package cucumber_blueprint.rest.helpers;

import com.google.inject.Inject;
import cucumber_blueprint.enums.HttpMethod;
import cucumber_blueprint.enums.Paths;
import cucumber_blueprint.enums.Props;
import cucumber_blueprint.rest.pojos.AuthBody;
import cucumber_blueprint.utils.ApiUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static cucumber_blueprint.utils.ConfigUtils.getBaseRestUri;
import static cucumber_blueprint.utils.ConfigUtils.getProp;

public class AuthHelpers {

    public static Response postCreateAuthToken(String username, String password) {

        AuthBody body = new AuthBody(username, password);

        RequestSpecBuilder builder = new RequestSpecBuilder();

        // Prepare request
        builder.setBaseUri(getProp(Props.BASE_REST_URI.prop));
        builder.setBasePath(Paths.AUTH.path);
        builder.setContentType(ContentType.JSON);
        builder.setBody(body);
        RequestSpecification requestSpec = builder.build();

        return ApiUtils.sendRequest(requestSpec, HttpMethod.POST);
    }
}
