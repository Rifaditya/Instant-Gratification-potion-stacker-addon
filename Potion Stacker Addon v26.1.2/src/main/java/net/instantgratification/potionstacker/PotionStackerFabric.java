// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.resources.Identifier;
import net.instantgratification.potionstacker.config.PotionStackerConfig;
import net.instantgratification.potionstacker.network.PotionLimitSyncPayload;
import net.instantgratification.potionstacker.util.PotionStackerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Verified against: ModInitializer.java (Fabric API)
// Verified against: DynamicGameRuleManager.java (DasikLibrary 1.8.2)
public class PotionStackerFabric implements ModInitializer {
    public static final String MOD_ID = "potion-stacker-addon";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final GameRuleCategory CUSTOM_CATEGORY = DynamicGameRuleManager.registerCategory(
        Identifier.fromNamespaceAndPath(MOD_ID, MOD_ID)
    );

    public static GameRule<Integer> POTION_LIMIT;
    public static GameRule<Integer> STEW_LIMIT;

    @Override
    public void onInitialize() {
        LOGGER.info("Instant Gratification: Potion Stacker Initialized");

        // Load config baseline template
        PotionStackerConfig.load(FabricLoader.getInstance().getConfigDir());

        // Register custom stack size override into Stack Size Adjuster's manager
        net.instantgratification.stacksizeadjuster.util.StackSizeManager.registerOverride(
            (net.instantgratification.stacksizeadjuster.util.CustomStackSizeOverride) (item, originalSize) -> 
                PotionStackerManager.getModifiedStackSize(item, originalSize)
        );

        // Register Potion Limit GameRule with dynamic default loaded from baseline config
        POTION_LIMIT = DynamicGameRuleManager.integerRule(MOD_ID + ":potion_limit", CUSTOM_CATEGORY, PotionStackerConfig.get().potionLimit)
            .name("Potion Limit")
            .description("Maximum stack size for potions (potions, splash potions, lingering potions, and water bottles). Default: 16")
            .range(1, Integer.MAX_VALUE)
            .register();

        // Register Stew Limit GameRule with dynamic default loaded from baseline config
        STEW_LIMIT = DynamicGameRuleManager.integerRule(MOD_ID + ":stew_limit", CUSTOM_CATEGORY, PotionStackerConfig.get().stewLimit)
            .name("Stew Limit")
            .description("Maximum stack size for stews and beetroot soup. Default: 16")
            .range(1, Integer.MAX_VALUE)
            .register();

        // Register Payload S2C
        PayloadTypeRegistry.clientboundPlay().register(PotionLimitSyncPayload.TYPE, PotionLimitSyncPayload.CODEC);

        // Sync limits to client when player joins the world
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            sender.sendPacket(new PotionLimitSyncPayload(
                PotionStackerManager.getPotionLimit(),
                PotionStackerManager.getStewLimit()
            ));
        });

        // Initialize/update active limits on server starting
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            // Reload config baseline template to fetch main-menu updates
            PotionStackerConfig.load(FabricLoader.getInstance().getConfigDir());

            GameRules rules = server.getGameRules();
            
            // If the world is newly created (not initialized yet), apply the baseline config template directly to the active GameRules
            if (!server.getWorldData().overworldData().isInitialized()) {
                rules.set(POTION_LIMIT, PotionStackerConfig.get().potionLimit, server);
                rules.set(STEW_LIMIT, PotionStackerConfig.get().stewLimit, server);
            }

            int pLimit = rules.get(POTION_LIMIT);
            int sLimit = rules.get(STEW_LIMIT);
            PotionStackerManager.setLimits(pLimit, sLimit, server);
        });
    }
}
