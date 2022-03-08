package cucumber_blueprint.utils;

import cucumber_blueprint.enums.Props;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    static Properties configProps;

    public static Properties getConfig() {

        try {
            InputStream input = new FileInputStream("src/test/resources/config.properties");
            configProps = new Properties();
            configProps.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return configProps;
    }

    public static String getDriverType() {
        return getConfig().getProperty("driverType");
    }

    public static String getBaseRestUri(){
        return getConfig().getProperty("baseRestUri");
    }

    public static String getBaseUri() {
        return getConfig().getProperty("baseWebUri");
    }

    public static String getUrl(String path) {
        return getBaseUri() + "/#/" + path;
    }

    public static String getProp(String prop) {
        return getConfig().getProperty(prop);
    }

    public static String getProp(Props prop) {
        return getConfig().getProperty(getProp(prop));
    }
}
