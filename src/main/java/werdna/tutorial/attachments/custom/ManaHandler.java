package werdna.tutorial.attachments.custom;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import werdna.tutorial.attachments.ModAttachmentTypes;
import werdna.tutorial.networking.packet.ModManaPayloadS2C;

public class ManaHandler {
    public static void setClientMana(ServerPlayer player, int mana)
    {
        player.setAttached(ModAttachmentTypes.MANA, mana);
        ServerPlayNetworking.send(player, new ModManaPayloadS2C(mana));
    }
    public static void addClientMana(ServerPlayer player, int add)
    {
        int nMana = player.getAttached(ModAttachmentTypes.MANA) + add;
        player.setAttached(ModAttachmentTypes.MANA, nMana);
        ServerPlayNetworking.send(player, new ModManaPayloadS2C(nMana));
    }
    public static void removeClientMana(ServerPlayer player, int remove)
    {
        int nMana = player.getAttached(ModAttachmentTypes.MANA) - remove;
        player.setAttached(ModAttachmentTypes.MANA, nMana);
        ServerPlayNetworking.send(player, new ModManaPayloadS2C(nMana));
    }
}
