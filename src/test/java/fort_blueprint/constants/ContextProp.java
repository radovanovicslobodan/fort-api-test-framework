package fort_blueprint.constants;

import io.restassured.response.Response;

public class ContextProp {
    public static final class Key<T> {
    }

    public static final Key<Response> RESPONSE = new Key<>();
    public static final Key<String> AUTH_TOKEN = new Key<>();
}
