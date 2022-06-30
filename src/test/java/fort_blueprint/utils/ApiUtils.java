package fort_blueprint.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fort_blueprint.pojo.response.Clinician;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static fort_blueprint.constants.Credential.USER_EMAIL;
import static fort_blueprint.constants.Credential.USER_PASSWORD;
import static fort_blueprint.constants.Path.CLINICIANS;
import static fort_blueprint.constants.Url.BASE_URI;
import static fort_blueprint.utils.AuthUtils.getAccessToken;
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

    public static String getClinicianId() {
        ObjectMapper mapper = new ObjectMapper();
        String token = getAccessToken(USER_EMAIL, USER_PASSWORD);
        JsonNode clinicians = RestAssured.with()
                .baseUri(BASE_URI)
                .basePath(CLINICIANS)
                .header("Authorization", "Bearer " + token)
                .get()
                .as(JsonNode.class);

        List<Clinician> cliniciansList = mapper.convertValue(clinicians, new TypeReference<List<Clinician>>() {
                }
        );
        return cliniciansList.get(0).getId();
    }

    public static String getCaregiverId(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String caregiverId = String.valueOf(jwt.getClaim("userId"));
        return caregiverId;
    }
}
