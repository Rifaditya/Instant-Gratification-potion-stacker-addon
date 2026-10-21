// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.GameRules;
import net.instantgratification.potionstacker.config.PotionStackerConfig;
import net.instantgratification.potionstacker.util.PotionStackerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Verified against: ModInitializer.java (Fabric API 1.20.1)
// Verified against: DynamicGameRuleManager.java (DasikLibrary 1.4.0+1.20.1)
public class PotionStackerFabric implements ModInitializer {
    public static final String MOD_ID = "potion-stacker-addon";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ResourceLocation SYNC_LIMIT_ID = new ResourceLocation(MOD_ID, "sync_limit");

    public static CustomGameRuleCategory CUSTOM_CATEGORY;
    public static GameRules.Key<GameRules.IntegerValue> POTION_LIMIT;
    public static GameRules.Key<GameRules.IntegerValue> STEW_LIMIT;

    @Override
    public void onInitialize() {
        LOGGER.info("Instant Gratification: Potion Stacker Initialized (1.20.1)");

        // Load config baseline template
        PotionStackerConfig.load(FabricLoader.getInstance().getConfigDir());

        // Register custom stack size override into Stack Size Adjuster's manager
        net.instantgratification.stacksizeadjuster.util.StackSizeManager.registerOverride(
            (net.instantgratification.stacksizeadjuster.util.CustomStackSizeOverride) (item, originalSize) -> 
                PotionStackerManager.getModifiedStackSize(item, originalSize)
        );

        // Register Category
        CUSTOM_CATEGORY = DynamicGameRuleManager.registerCategory(
            new ResourceLocation(MOD_ID, MOD_ID),
            Component.translatable("gamerule.category.potion-stacker-addon.potion-stacker-addon")
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

        // Sync limits to client when player joins the world
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            FriendlyByteBuf buf = PacketByteBufs.create();
            buf.writeVarInt(PotionStackerManager.getPotionLimit());
            buf.writeVarInt(PotionStackerManager.getStewLimit());
            sender.sendPacket(SYNC_LIMIT_ID, buf);
        });

        // Initialize/update active limits on server starting
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            // Reload config baseline template to fetch main-menu updates
            PotionStackerConfig.load(FabricLoader.getInstance().getConfigDir());

            GameRules rules = server.getGameRules();
            
            // If the world is newly created (not initialized yet), apply the baseline config template directly to the active GameRules
            if (!server.getWorldData().overworldData().isInitialized()) {
                rules.getRule(POTION_LIMIT).set(PotionStackerConfig.get().potionLimit, server);
                rules.getRule(STEW_LIMIT).set(PotionStackerConfig.get().stewLimit, server);
            }

            int pLimit = rules.getInt(POTION_LIMIT);
            int sLimit = rules.getInt(STEW_LIMIT);
            PotionStackerManager.setLimits(pLimit, sLimit, server);
        });
    }
}
