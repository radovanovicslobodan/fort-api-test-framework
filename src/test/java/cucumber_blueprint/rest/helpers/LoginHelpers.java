package cucumber_blueprint.rest.helpers;

import cucumber_blueprint.enums.HttpMethod;
import cucumber_blueprint.utils.ApiUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginHelpers {

    public static Response postLogin(String username, String password) {

        RequestSpecBuilder builder = new RequestSpecBuilder();

        // Prepare request
        builder.setBaseUri("https://restful-booker.herokuapp.com");
        builder.setBasePath("auth");
        builder.setContentType(ContentType.JSON);
        builder.setBody("{\r\n    \"password\": \"" + password + "\",\r\n    \"username\": \"" + username + "\"\r\n}");
        RequestSpecification requestSpec = builder.build();

        return ApiUtils.sendRequest(requestSpec, HttpMethod.POST);
    }
}
