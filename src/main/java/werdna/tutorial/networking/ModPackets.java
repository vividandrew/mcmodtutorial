package werdna.tutorial.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import werdna.tutorial.events.ModClientEvents;
import werdna.tutorial.events.ModServerEvents;
import werdna.tutorial.networking.packet.ModManaPayloadS2C;
import werdna.tutorial.networking.packet.ModTestPayloadC2S;

public class ModPackets {
    private static void registerClientBoundPackets(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry)
    {
        //Payloads sent from Server to Client S2C
        registry.register(ModManaPayloadS2C.MANA, ModManaPayloadS2C.STREAM_CODEC);
        ClientPlayNetworking.registerGlobalReceiver(ModManaPayloadS2C.MANA, ModClientBoundPackets::handleModManaPayload);
    }
    private static void registerServerBoundPackets(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry)
    {
        //Payloads sent from Client to Server C2S
        registry.register(ModTestPayloadC2S.ID, ModTestPayloadC2S.STREAM_CODEC);
        ServerPlayNetworking.registerGlobalReceiver(ModTestPayloadC2S.ID, ModServerBoundPackets::handleModTestPayload);
    }

    public static void registerPackets()
    {
        registerClientBoundPackets(PayloadTypeRegistry.clientboundPlay());
        registerServerBoundPackets(PayloadTypeRegistry.serverboundPlay());
    }
}
