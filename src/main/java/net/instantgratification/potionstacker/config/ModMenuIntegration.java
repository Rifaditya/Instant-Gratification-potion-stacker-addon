package net.instantgratification.potionstacker.config;

// Verified against: ModMenuIntegration.java (26.2+)
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.dasik.social.api.config.GuiHelper;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return GuiHelper.getOptionalFactory(
            "potion-stacker-addon",
            "net.instantgratification.potionstacker.config.YaclScreenHelper",
            "createScreen"
        );
    }
}
