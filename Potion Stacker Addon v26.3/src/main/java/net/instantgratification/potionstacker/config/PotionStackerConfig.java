// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.config;

import java.nio.file.Path;
import net.dasik.social.api.config.ConfigOption;

public class PotionStackerConfig {
    private static PotionStackerConfig INSTANCE = new PotionStackerConfig();
    private static Path CONFIG_PATH;

    public static final int VERSION = 1;
    public int configVersion = VERSION;

    @ConfigOption(
        category = "general",
        group = "categories",
        nameKey = "config.potion-stacker-addon.option.potion_limit",
        descriptionKey = "config.potion-stacker-addon.option.potion_limit.description",
        min = 1,
        max = Integer.MAX_VALUE,
        step = 1,
        order = 1,
        syncGameRule = true,
        gameRuleName = "potion-stacker-addon:potion_limit"
    )
    public int potionLimit = 16;

    @ConfigOption(
        category = "general",
        group = "categories",
        nameKey = "config.potion-stacker-addon.option.stew_limit",
        descriptionKey = "config.potion-stacker-addon.option.stew_limit.description",
        min = 1,
        max = Integer.MAX_VALUE,
        step = 1,
        order = 2,
        syncGameRule = true,
        gameRuleName = "potion-stacker-addon:stew_limit"
    )
    public int stewLimit = 16;

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
