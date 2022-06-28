package fort_blueprint.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static fort_blueprint.utils.ApiUtils.sendRequest;
import static fort_blueprint.utils.ConfigUtils.envConfig;

public class RequestUtil {
    static RequestSpecBuilder builder = new RequestSpecBuilder();

    public static RequestSpecBuilder makeGetRequest(String path) {
        builder.setContentType(ContentType.JSON);
        builder.setBaseUri(envConfig.baseUri());
        builder.setBasePath(path);
        return builder;
    }

    public static RequestSpecBuilder withParam(String key, String value) {
        return builder.addQueryParam(key, value);
    }

    public static Response send() {
//        RequestSpecification spec = builder.build();
        return sendRequest(builder.build(), Method.GET);
    }
}
