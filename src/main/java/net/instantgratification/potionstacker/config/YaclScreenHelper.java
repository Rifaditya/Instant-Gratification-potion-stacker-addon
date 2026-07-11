package net.instantgratification.potionstacker.config;

// Verified against: YaclScreenHelper.java (YACL 3.9.5)
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class YaclScreenHelper {
    public static ConfigScreenFactory<?> createScreen() {
        return YaclScreenHelper::buildScreen;
    }

    private static Screen buildScreen(Screen parent) {
        PotionStackerConfig config = PotionStackerConfig.get();

        return YetAnotherConfigLib.createBuilder()
            .title(Component.translatable("config.potion-stacker-addon.title"))
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("config.potion-stacker-addon.category.general"))
                .group(OptionGroup.createBuilder()
                    .name(Component.translatable("config.potion-stacker-addon.group.categories"))

                    // Potion Limit
                    .option(Option.<Integer>createBuilder()
                        .name(Component.translatable("config.potion-stacker-addon.option.potion_limit"))
                        .description(val -> {
                            if (val > 39768215) {
                                return OptionDescription.of(Component.translatable("config.potion-stacker-addon.option.warning", val));
                            }
                            return OptionDescription.of(Component.translatable("config.potion-stacker-addon.option.potion_limit.description"));
                        })
                        .binding(
                            16,
                            () -> config.potionLimit,
                            val -> config.potionLimit = val
                        )
                        .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                            .min(1)
                            .max(Integer.MAX_VALUE)
                        )
                        .build()
                    )

                    .build()
                )
                .build()
            )
            .save(PotionStackerConfig::save)
            .build()
            .generateScreen(parent);
    }
}
