package fort_blueprint.core.request_builder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequestBuilder implements PutRequestCreator {
    RequestSpecification spec;

    private PutRequestBuilder(String uri) {
        this.spec = RestAssured.with();
        this.spec.baseUri(uri);
    }

    public static PutRequestCreator makePutRequest(String uri) {
        return new PutRequestBuilder(uri);
    }

    @Override
    public PutRequestCreator withBasePath(String basePath) {
        this.spec.basePath(basePath);
        return this;
    }

    @Override
    public PutRequestCreator withPathParam(String key, String value) {
        this.spec.pathParams(key, value);
        return this;
    }

    @Override
    public PutRequestCreator withAuthToken(String token) {
        this.spec.header("Authorization", "Bearer " + token);
        return this;
    }

    @Override
    public PutRequestCreator withBody(String body) {
        this.spec.body(body);
        return this;
    }

    @Override
    public Response send() {
        return this.spec.put();
    }
}
