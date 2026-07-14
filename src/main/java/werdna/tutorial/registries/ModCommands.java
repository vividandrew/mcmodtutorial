package werdna.tutorial.registries;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.data.PackOutput;
import werdna.tutorial.Tutorial;
import werdna.tutorial.commands.ReturnHomeCommand;
import werdna.tutorial.commands.SetHomeCommand;

public class ModCommands {
    public static void registerCommands()
    {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }
    public static void register()
    {
        Tutorial.LOGGER.info("Registering Commands for " + Tutorial.MOD_ID);
    }
}
