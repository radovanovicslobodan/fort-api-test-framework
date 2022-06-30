package fort_blueprint.core.request_builder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public final class GetRequestBuilder implements GetRequestCreator {
    RequestSpecification spec;

    // Private constructor to prevent direct object creation
    private GetRequestBuilder(String uri) {
        this.spec = RestAssured.with();
        this.spec.baseUri(uri);
    }

    public static GetRequestCreator makeGetRequest(String uri) {
        return new GetRequestBuilder(uri);
    }

    public GetRequestCreator withBasePath(String path) {
        this.spec.basePath(path);
        return this;
    }

    @Override
    public GetRequestCreator withPathParam(String key, String value) {
        this.spec.pathParams(key, value);
        return this;
    }

    @Override
    public GetRequestCreator withAuthToken(String token) {
        this.spec.header("Authorization", "Bearer " + token);
        return this;
    }

    @Override
    public Response send() {
        return this.spec.get();
    }
}
