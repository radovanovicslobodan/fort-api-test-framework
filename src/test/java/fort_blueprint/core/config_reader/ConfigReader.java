package fort_blueprint.core.config_reader;

import org.aeonbits.owner.ConfigCache;

public class ConfigReader {
    public static EnvConfig envConfig = ConfigCache.getOrCreate(EnvConfig.class);
}
