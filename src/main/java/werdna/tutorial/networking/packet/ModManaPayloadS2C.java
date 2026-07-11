package werdna.tutorial.networking.packet;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import werdna.tutorial.Tutorial;

public record ModManaPayloadS2C(int mana) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ModManaPayloadS2C> MANA = new CustomPacketPayload.Type<>(
            Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "mana_payload")
            );
    public static final StreamCodec<RegistryFriendlyByteBuf, ModManaPayloadS2C> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, ModManaPayloadS2C::mana,
            ModManaPayloadS2C::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return MANA;
    }
}
