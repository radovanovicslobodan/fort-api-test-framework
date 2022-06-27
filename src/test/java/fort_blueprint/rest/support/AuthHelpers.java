package fort_blueprint.rest.support;

import fort_blueprint.constants.Paths;
import fort_blueprint.core.api.SpecBuilder;
import fort_blueprint.rest.pojos.AuthBody;
import fort_blueprint.utils.ApiUtils;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthHelpers {

    public static Response postCreateAuthToken(String username, String password) {

        AuthBody body = new AuthBody(username, password);

        RequestSpecification requestSpec = SpecBuilder
                .requestSpecBuilder()
                .setBasePath(Paths.AUTH)
                .setBody(body)
                .build();

        return ApiUtils.sendRequest(requestSpec, Method.POST);
    }
}
