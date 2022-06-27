package fort_blueprint.utils.support;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import fort_blueprint.constants.HttpMethod;
import fort_blueprint.core.api.SpecBuilder;
import fort_blueprint.utils.ApiUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class ConduitTokenHelper {

    public static String postGetConduitToken(String email, String password) {

        JsonObject user = new JsonObject();
        JsonObject credentials = new JsonObject();

        credentials.addProperty("email", email);
        credentials.addProperty("password", password);

        user.add("user", credentials);

        String payload = new Gson().toJson(user);

        ConduitLoginBody body = new ConduitLoginBody(email, password);
        JsonPath jsonPathEvaluator;

        RequestSpecification requestSpec = SpecBuilder
                .requestSpecBuilder()
                .setBaseUri("https://api.realworld.io")
                .setBasePath("api/users/login")
                .setBody(payload)
                .build();

        jsonPathEvaluator = ApiUtils.sendRequest(requestSpec, HttpMethod.POST).jsonPath();

        return jsonPathEvaluator.get("jwt");
    }
}
