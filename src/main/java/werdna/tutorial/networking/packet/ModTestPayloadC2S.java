package werdna.tutorial.networking.packet;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import werdna.tutorial.Tutorial;

public record ModTestPayloadC2S(String name, int value) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ModTestPayloadC2S> ID = new CustomPacketPayload.Type<>(
            Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "test_payload")
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, ModTestPayloadC2S> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, ModTestPayloadC2S::name, ByteBufCodecs.VAR_INT, ModTestPayloadC2S::value,
            ModTestPayloadC2S::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
