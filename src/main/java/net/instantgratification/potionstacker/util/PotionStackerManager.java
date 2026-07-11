package net.instantgratification.potionstacker.util;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.instantgratification.potionstacker.network.PotionLimitSyncPayload;

public class PotionStackerManager {
    private static volatile int potionLimit = 16;

    public static int getPotionLimit() {
        return potionLimit;
    }

    public static int getModifiedStackSize(Item item, int original) {
        if (original <= 0) {
            return original;
        }
        if (item instanceof PotionItem) {
            return potionLimit;
        }
        return original;
    }

    public static void setLimits(int limit, MinecraftServer server) {
        boolean changed = (limit != potionLimit);
        if (changed) {
            potionLimit = limit;
            if (server != null) {
                PotionLimitSyncPayload payload = new PotionLimitSyncPayload(limit);
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
        if (path.equals("potion_limit")) {
            setLimits(value, server);
        }
    }

    public static void setClientLimit(int limit) {
        potionLimit = limit;
    }
}
