package fort_blueprint.core.request_builder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public final class RequestBuilder implements RequestCreator {
    RequestSpecification spec;

    // Private constructor to prevent direct object creation
    private RequestBuilder(String uri) {
        this.spec = RestAssured.with();
        this.spec.baseUri(uri);
    }

    public static RequestCreator makeGetRequest(String uri) {
        return new RequestBuilder(uri);
    }

    public RequestCreator withBasePath(String path) {
        this.spec.basePath(path);
        return this;
    }

    @Override
    public RequestCreator withPathParam(String key, String value) {
        this.spec.pathParams(key, value);
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
