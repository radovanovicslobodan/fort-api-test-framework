package fort_blueprint.core.request_builder;

import io.restassured.response.Response;

public interface PutRequestCreator {
    PutRequestCreator withBasePath(String basePath);

    PutRequestCreator withPathParam(String key, String value);

    PutRequestCreator withAuthToken(String token);

    PutRequestCreator withBody(String body);

    Response send();
}
