package fort_blueprint.utils;

import fort_blueprint.constants.Path;
import fort_blueprint.core.api.SpecBuilder;
import fort_blueprint.pojo.AuthBody;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static fort_blueprint.constants.Url.OAUTH_URL;
import static io.restassured.RestAssured.with;

public class AuthUtils {

    public static Response postCreateAuthToken(String username, String password) {

        AuthBody body = new AuthBody(username, password);

        RequestSpecification requestSpec = SpecBuilder
                .requestSpecBuilder()
                .setBasePath(Path.AUTH)
                .setBody(body)
                .build();

        return ApiUtils.sendRequest(requestSpec, Method.POST);
    }

    public static String getAccessToken(String email, String password) {
        Response response = with()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", "password")
                .formParam("client_id", "qa-client-fort")
                .formParam("username", email)
                .formParam("password", password)
                .formParam("scope", "openid")
                .when()
                .post(OAUTH_URL)
                .then()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        return jsonPath.get("access_token");
    }
}
