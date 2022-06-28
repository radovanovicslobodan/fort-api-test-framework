package fort_blueprint.core.request_builder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public final class RequestBuilder implements RequestBase, RequestCreator {
    RequestSpecification spec = RestAssured.with();

    // Private constructor to prevent direct object creation
    private RequestBuilder() {
    }

    public static RequestBase makeGetRequest() {
        return new RequestBuilder();
    }

    public RequestCreator withBaseUri(String path) {
        this.spec.baseUri(path);
        return this;
    }

    public RequestCreator withBasePath(String path) {
        this.spec.basePath(path);
        return this;
    }

    @Override
    public RequestCreator withPathParam(String key, String value) {
        Map<String, String> param = new HashMap<>();
        param.put(key, value);
        this.spec.pathParams(param);
        return this;
    }

    @Override
    public RequestCreator withAuthToken(String token) {
        this.spec.header("Authorization", "Bearer " + token);
        return this;
    }

    @Override
    public Response send() {
        return this.spec.get();
    }
}
