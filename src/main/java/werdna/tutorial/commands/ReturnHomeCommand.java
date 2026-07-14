package werdna.tutorial.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import werdna.tutorial.Tutorial;
import werdna.tutorial.attachments.ModAttachmentTypes;

public class ReturnHomeCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext context,
                                                                Commands.CommandSelection commandSelection)
{
    dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes(ReturnHomeCommand::run)));
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

        if(!player.hasAttached(ModAttachmentTypes.HOME))
        {
            context.getSource().sendFailure(Component.literal("ERROR: Home has not been set"));
            return -1;
        }

        BlockPos pos = player.getAttached(ModAttachmentTypes.HOME);

        String position = "[*] "+player.getPlainTextName() + "Player at (" + pos.getX()+"," + pos.getY() + "," + pos.getZ() + ")" +
                "Has used the home command";
        player.teleportTo(pos.getX(),pos.getY(),pos.getZ());
        Tutorial.LOGGER.info(position);

        return 1;
    }
}
