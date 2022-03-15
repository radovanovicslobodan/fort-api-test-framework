package cucumber_blueprint.core.api;

import cucumber_blueprint.constants.Props;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static cucumber_blueprint.utils.ConfigUtils.getProp;

public class SpecBuilder {

    public static RequestSpecBuilder requestSpecBuilder() {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setBaseUri(getProp(Props.BASE_REST_URI));
        builder.setContentType(ContentType.JSON);
        return builder;
    }
}
