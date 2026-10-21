// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.instantgratification.potionstacker.util.PotionStackerManager;

// Verified against: ClientModInitializer.java (Fabric API 1.20.1)
public class PotionStackerFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(PotionStackerFabric.SYNC_LIMIT_ID, (client, handler, buf, responseSender) -> {
            int pLimit = buf.readVarInt();
            int sLimit = buf.readVarInt();
            client.execute(() -> {
                PotionStackerManager.setClientLimit(pLimit, sLimit);
            });
        });
    }
}
