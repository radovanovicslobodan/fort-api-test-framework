package fort_blueprint.core.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static fort_blueprint.utils.ConfigUtils.envConfig;

public class SpecBuilder {

    public static RequestSpecBuilder requestSpecBuilder() {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setBaseUri(envConfig.baseRestUri());
        builder.setContentType(ContentType.JSON);
        return builder;
    }

    public static RequestSpecBuilder requestSpecBuilder(String token, String path) {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setContentType(ContentType.JSON);
        builder.setBaseUri(envConfig.baseUri());
        builder.setBasePath(path);
        builder.addHeader("Authorization", "Bearer " + token);
        builder.build();
        return builder;
    }

    public static RequestSpecification requestSpecHelper(String token, String path) {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setContentType(ContentType.JSON);
        builder.setBaseUri(envConfig.baseUri());
        builder.setBasePath(path);
        builder.addHeader("Authorization", "Bearer " + token);

        return builder.build();
    }
}
