package cucumber_blueprint.enums;

public enum HttpMethod {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    public final String method;

    HttpMethod(String method) {
        this.method = method;
    }
}
