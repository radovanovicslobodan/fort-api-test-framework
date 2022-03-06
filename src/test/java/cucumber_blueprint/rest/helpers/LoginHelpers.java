package cucumber_blueprint.rest.helpers;

import com.google.inject.Inject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginHelpers {

    public static Response postLogin(String username, String password) {

        RequestSpecBuilder builder = new RequestSpecBuilder();

        // Prepare request
        builder.setBaseUri("https://restful-booker.herokuapp.com/auth");
        builder.setBasePath("");
        builder.setContentType(ContentType.JSON);
        builder.setBody("{\r\n    \"password\": \"" + password + "\",\r\n    \"username\": \"" + username + "\"\r\n}");
        RequestSpecification requestSpec = builder.build();

        return RestHelpers.sendRequest(requestSpec,"POST");
    }
}
