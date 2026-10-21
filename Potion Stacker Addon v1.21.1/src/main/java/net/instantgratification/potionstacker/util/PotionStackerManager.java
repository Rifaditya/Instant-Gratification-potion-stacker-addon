// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.util;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.instantgratification.potionstacker.network.PotionLimitSyncPayload;

import net.fabricmc.loader.api.FabricLoader;

public class PotionStackerManager {
    private static volatile int potionLimit = 16;
    private static volatile int stewLimit = 16;

    public static int getPotionLimit() {
        return potionLimit;
    }

    public static int getStewLimit() {
        return stewLimit;
    }

    public static int getModifiedStackSize(Item item, int original) {
        if (original <= 0) {
            return original;
        }
        if (item instanceof PotionItem) {
            return potionLimit;
        }
        if (isStewOrSoup(item)) {
            // Defer stew handling to stew-stacker-addon if loaded to prevent conflicts
            if (FabricLoader.getInstance().isModLoaded("stew-stacker-addon")) {
                return -1;
            }
            return stewLimit;
        }
        return -1;
    }

    public static boolean isStewOrSoup(Item item) {
        return item == net.minecraft.world.item.Items.MUSHROOM_STEW
            || item == net.minecraft.world.item.Items.RABBIT_STEW
            || item == net.minecraft.world.item.Items.BEETROOT_SOUP
            || item == net.minecraft.world.item.Items.SUSPICIOUS_STEW;
    }

    public static void setLimits(int pLimit, int sLimit, MinecraftServer server) {
        boolean changed = (pLimit != potionLimit || sLimit != stewLimit);
        if (changed) {
            potionLimit = pLimit;
            stewLimit = sLimit;
            if (server != null) {
                PotionLimitSyncPayload payload = new PotionLimitSyncPayload(pLimit, sLimit);
                for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                    ServerPlayNetworking.send(player, payload);
                    
                    // Force refresh client's container and inventory menus dynamically
                    if (player.containerMenu != null) {
                        player.containerMenu.broadcastFullState();
                    }
                    if (player.inventoryMenu != null && player.containerMenu != player.inventoryMenu) {
                        player.inventoryMenu.broadcastFullState();
                    }
                }
            }
        }
    }

    public static void setLimit(String path, int value, MinecraftServer server) {
        int nextPotion = potionLimit;
        int nextStew = stewLimit;
        if (path.equals("potion_limit")) {
            nextPotion = value;
        } else if (path.equals("stew_limit")) {
            nextStew = value;
        }
        setLimits(nextPotion, nextStew, server);
    }

    public static void setClientLimit(int pLimit, int sLimit) {
        potionLimit = pLimit;
        stewLimit = sLimit;
    }
}
