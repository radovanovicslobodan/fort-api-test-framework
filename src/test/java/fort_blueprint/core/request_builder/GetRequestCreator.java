package fort_blueprint.core.request_builder;

import io.restassured.response.Response;

public interface GetRequestCreator {
    GetRequestCreator withBasePath(String basePath);

    GetRequestCreator withPathParam(String key, String value);

    GetRequestCreator withAuthToken(String token);

    Response send();
}
