package net.instantgratification.potionstacker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.instantgratification.potionstacker.network.PotionLimitSyncPayload;
import net.instantgratification.potionstacker.util.PotionStackerManager;

// Verified against: ClientModInitializer.java (26.2+)
public class PotionStackerFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(PotionLimitSyncPayload.TYPE, (payload, context) -> {
            context.client().execute(() -> {
                PotionStackerManager.setClientLimit(payload.potionLimit());
            });
        });
    }
}
