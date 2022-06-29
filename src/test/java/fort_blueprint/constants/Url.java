package fort_blueprint.constants;

import static fort_blueprint.core.config_reader.ConfigReader.envConfig;

public class Url {
    private static final String API_VERSION = "api/v1/";
    public static final String BASE_URI = envConfig.baseUri() + API_VERSION;
    public static final String OAUTH_URL = envConfig.baseUri() + "auth/realms/fort/protocol/openid-connect/token";
}
