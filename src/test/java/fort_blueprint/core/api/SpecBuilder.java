package fort_blueprint.core.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static fort_blueprint.utils.ConfigUtils.envConfig;

public class SpecBuilder {

    public static RequestSpecBuilder requestSpecBuilder() {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setBaseUri(envConfig.baseRestUri());
        builder.setContentType(ContentType.JSON);
        return builder;
    }
}
