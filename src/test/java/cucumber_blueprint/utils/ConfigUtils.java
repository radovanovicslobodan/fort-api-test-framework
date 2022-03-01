package cucumber_blueprint.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    public static Properties getConfig() throws IOException {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String configPath = rootPath + "config.properties";

        Properties configProps = new Properties();
        configProps.load(new FileInputStream(configPath));

        return configProps;
    }

    public static String getBaseUri() throws IOException {
        return getConfig().getProperty("baseUri");
    }

    public static String getUrl(String path) throws IOException {
        return getConfig().getProperty("baseUri") + path;
    }
}
