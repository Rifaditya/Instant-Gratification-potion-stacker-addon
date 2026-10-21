// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.dasik.social.api.client.gui.UniversalConfigScreen;

// Verified against: ModMenuIntegration.java (1.20.1)
@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return UniversalConfigScreen.createFactory("potion-stacker-addon", PotionStackerConfig.get(), PotionStackerConfig::save);
    }
}
