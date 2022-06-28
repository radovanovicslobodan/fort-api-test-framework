package fort_blueprint.core.request_builder;

import io.restassured.response.Response;

public interface RequestCreator {
    RequestCreator withBasePath(String basePath);

    RequestCreator withPathParam(String key, String value);

    RequestCreator withAuthToken(String token);

    Response send();
}
