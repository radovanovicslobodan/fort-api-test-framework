package fort_blueprint.utils;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response sendRequest(RequestSpecification requestSpec, Method requestMethod) {

        return switch (requestMethod) {
            case GET -> given().spec(requestSpec).log().all().relaxedHTTPSValidation().when()
                    .get().then().log().all().extract().response();
            case POST -> given().spec(requestSpec).log().all().relaxedHTTPSValidation().when()
                    .post().then().log().all().extract().response();
            case PUT -> given().spec(requestSpec).log().all().relaxedHTTPSValidation().when()
                    .put().then().log().all().extract().response();
            case DELETE -> given().spec(requestSpec).log().all().relaxedHTTPSValidation().when()
                    .delete().then().log().all().extract().response();
            default -> throw new IllegalStateException(
                    "Unexpected value: " + requestMethod);
        };
    }
}
