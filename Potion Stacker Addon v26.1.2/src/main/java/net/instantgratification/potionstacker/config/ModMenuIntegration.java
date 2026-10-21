// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.config;

// Verified against: ModMenuIntegration.java (26.2+)
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.dasik.social.api.client.gui.UniversalConfigScreen;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return UniversalConfigScreen.createFactory("potion-stacker-addon", PotionStackerConfig.get(), PotionStackerConfig::save);
    }
}
