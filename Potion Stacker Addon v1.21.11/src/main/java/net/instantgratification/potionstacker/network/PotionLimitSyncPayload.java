// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record PotionLimitSyncPayload(int potionLimit, int stewLimit) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<PotionLimitSyncPayload> TYPE = new CustomPacketPayload.Type<>(
        Identifier.fromNamespaceAndPath("potion-stacker", "sync_limit")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, PotionLimitSyncPayload> CODEC = StreamCodec.composite(
        ByteBufCodecs.VAR_INT,
        PotionLimitSyncPayload::potionLimit,
        ByteBufCodecs.VAR_INT,
        PotionLimitSyncPayload::stewLimit,
        PotionLimitSyncPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
