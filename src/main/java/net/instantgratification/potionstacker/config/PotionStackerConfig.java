package net.instantgratification.potionstacker.config;

import java.nio.file.Path;

public class PotionStackerConfig {
    private static PotionStackerConfig INSTANCE = new PotionStackerConfig();
    private static Path CONFIG_PATH;

    public static final int VERSION = 1;
    public int configVersion = VERSION;

    public int potionLimit = 16;

    public static synchronized void load(Path configDir) {
        CONFIG_PATH = configDir.resolve("potion-stacker.json");
        INSTANCE = net.dasik.social.api.config.ConfigHelper.load(
            CONFIG_PATH, INSTANCE, PotionStackerConfig.class, VERSION,
            config -> config.configVersion, (config, ver) -> config.configVersion = ver,
            null, org.slf4j.LoggerFactory.getLogger("PotionStacker")
        );
    }

    public static synchronized void save() {
        if (CONFIG_PATH == null) return;
        net.dasik.social.api.config.ConfigHelper.save(CONFIG_PATH, INSTANCE, org.slf4j.LoggerFactory.getLogger("PotionStacker"));
    }

    public static PotionStackerConfig get() {
        return INSTANCE;
    }
}
