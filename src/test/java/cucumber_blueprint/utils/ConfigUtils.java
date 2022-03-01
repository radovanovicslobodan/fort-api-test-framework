package cucumber_blueprint.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    public static Properties getConfig() throws IOException {

        InputStream input = new FileInputStream("src/test/resources/config.properties");
        Properties configProps = new Properties();
        configProps.load(input);

        return configProps;
    }

    public static String getDriverType() throws IOException {
        return getConfig().getProperty("driverType");
    }

    public static String getBaseUri() throws IOException {
        return getConfig().getProperty("baseUri");
    }

    public static String getUrl(String path) throws IOException {
        String url = getConfig().getProperty("baseUri") + path;
        return getConfig().getProperty("baseUri") + "/#/" + path;
    }
}
