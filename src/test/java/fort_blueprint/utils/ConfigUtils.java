package fort_blueprint.utils;

import org.aeonbits.owner.ConfigCache;

public class ConfigUtils {
    public static EnvConfig envConfig = ConfigCache.getOrCreate(EnvConfig.class);
}
