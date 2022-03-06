package cucumber_blueprint.rest.helpers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestHelpers {

    public static Response sendRequest(RequestSpecification rSpec, String requestMethod) {

        Response response;

        switch (requestMethod) {
            case "GET":
                response = given().spec(rSpec).log().all().relaxedHTTPSValidation().when()
                        .get().then().log().all().extract().response();
                break;

            case "POST":
                response = given().spec(rSpec).log().all().relaxedHTTPSValidation().when()
                        .post().then().log().all().extract().response();
                break;

            case "PUT":
                response = given().spec(rSpec).log().all().relaxedHTTPSValidation().when()
                        .put().then().log().all().extract().response();
                break;

            case "DELETE":
                response = given().spec(rSpec).log().all().relaxedHTTPSValidation().when()
                        .delete().then().log().all().extract().response();
                break;

            default:
                throw new IllegalStateException(
                        "Unexpected value: " + requestMethod);

        }
        String statusCode = String.valueOf(response.getStatusCode());

        return response;
    }
}
