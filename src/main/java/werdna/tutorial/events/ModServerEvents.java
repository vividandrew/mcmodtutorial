package werdna.tutorial.events;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import werdna.tutorial.Tutorial;
import werdna.tutorial.attachments.ModAttachmentTypes;
import werdna.tutorial.attachments.custom.ManaHandler;
import werdna.tutorial.commands.ReturnHomeCommand;
import werdna.tutorial.networking.packet.ModManaPayloadS2C;

public class ModServerEvents {

    public static void onPlayerJoin(ServerPlayer player)
    {
        if(player.hasAttached(ModAttachmentTypes.MANA))
        {
            ManaHandler.setClientMana(player, player.getAttached(ModAttachmentTypes.MANA));
        }else{
            ManaHandler.setClientMana(player, 5);
        }
    }
    public static void onPlayerCopyFrom(ServerPlayer playerOld, ServerPlayer playerNew, boolean alive)
    {
        ManaHandler.setClientMana(playerNew, playerOld.getAttached(ModAttachmentTypes.MANA));
    }
    public static void onPlayerafterRespawn(ServerPlayer playerOld, ServerPlayer playerNew, boolean alive)
    {
        ManaHandler.setClientMana(playerNew, playerOld.getAttached(ModAttachmentTypes.MANA));
    }
}
