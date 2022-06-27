package fort_blueprint.utils;

import fort_blueprint.constants.Props;
import org.aeonbits.owner.ConfigCache;

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

    public static String getProp(String prop) {
        return getConfig().getProperty(prop);
    }

    public static String getUrl(String path) {
        return getProp(Props.BASE_WEB_URI) + "/#/" + path;
    }

    public static EnvConfig envConfig = ConfigCache.getOrCreate(EnvConfig.class);

}
