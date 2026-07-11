package werdna.tutorial.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import werdna.tutorial.attachments.ModAttachmentTypes;
import werdna.tutorial.networking.packet.ModManaPayloadS2C;

public class ModClientBoundPackets {

    public static void handleModManaPayload(ModManaPayloadS2C manaPayloadS2C, ClientPlayNetworking.Context context)
    {
        context.player().setAttached(ModAttachmentTypes.MANA, manaPayloadS2C.mana());
    }
}
