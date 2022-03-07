package cucumber_blueprint.utils;

import cucumber_blueprint.enums.HttpMethod;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response sendRequest(RequestSpecification requestSpec, HttpMethod requestMethod) {

        Response response;

        switch (requestMethod) {
            case GET:
                response = given().spec(requestSpec).log().all().relaxedHTTPSValidation().when()
                        .get().then().log().all().extract().response();
                break;

            case POST:
                response = given().spec(requestSpec).log().all().relaxedHTTPSValidation().when()
                        .post().then().log().all().extract().response();
                break;

            case PUT:
                response = given().spec(requestSpec).log().all().relaxedHTTPSValidation().when()
                        .put().then().log().all().extract().response();
                break;

            case DELETE:
                response = given().spec(requestSpec).log().all().relaxedHTTPSValidation().when()
                        .delete().then().log().all().extract().response();
                break;

            default:
                throw new IllegalStateException(
                        "Unexpected value: " + requestMethod);

        }
        return response;
    }
}
