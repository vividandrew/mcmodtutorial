package werdna.tutorial.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import werdna.tutorial.networking.packet.ModTestPayloadC2S;

// Client to Server C2S
public class ModServerBoundPackets {
    public static void handleModTestPayload(ModTestPayloadC2S payload, ServerPlayNetworking.Context context)
    {
        EntityTypes.CHICKEN.spawn(context.player().level(), context.player().getOnPos(), EntitySpawnReason.COMMAND);
        context.player().sendSystemMessage(Component.literal(payload.name() + " sent as payload to server, now spawning chickens"),true);
    }
}
