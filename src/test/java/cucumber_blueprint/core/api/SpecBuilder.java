package cucumber_blueprint.core.api;

import cucumber_blueprint.constants.Props;
import cucumber_blueprint.utils.EnvConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;

import static cucumber_blueprint.utils.ConfigUtils.envConfig;
import static cucumber_blueprint.utils.ConfigUtils.getProp;

public class SpecBuilder {

    public static RequestSpecBuilder requestSpecBuilder() {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setBaseUri(envConfig.baseRestUri());
        builder.setContentType(ContentType.JSON);
        return builder;
    }
}
