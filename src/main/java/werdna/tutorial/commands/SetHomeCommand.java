package werdna.tutorial.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.LevelData;
import werdna.tutorial.Tutorial;
import werdna.tutorial.attachments.ModAttachmentTypes;

public class SetHomeCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext context,
                                Commands.CommandSelection commandSelection)
    {
        dispatcher.register(Commands.literal("home").then(Commands.literal("set").executes(SetHomeCommand::run)));
    }
    // Home set

    //Home return

    private static int run(CommandContext<CommandSourceStack> context)
    {
        Player player = context.getSource().getPlayer();
        if(player == null)
        {
            context.getSource().sendFailure(Component.literal("[!] This command can only be used by player entities"));
            return -1;
        }

        BlockPos pos = player.blockPosition();

        String position = "[*] "+player.getPlainTextName() + "Player at (" + pos.getX()+"," + pos.getY() + "," + pos.getZ() + ")" +
                "Has used the home command";
        player.setAttached(ModAttachmentTypes.HOME, pos);

        if(player instanceof ServerPlayer sp)
        {
            ServerPlayer.RespawnConfig newConfig = new ServerPlayer.RespawnConfig(LevelData.RespawnData.of(Level.OVERWORLD,pos, 0f,0f),false);
            if(sp.getRespawnConfig() == null || sp.getRespawnConfig().isSamePosition(newConfig))
            {
                sp.setRespawnPosition(newConfig, true);
            }
        }

        Tutorial.LOGGER.info(position);
        context.getSource().sendSuccess(() -> Component.literal("Have sethome"), false );

        return 1;
    }
}
