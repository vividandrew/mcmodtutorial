package werdna.tutorial.registries;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import werdna.tutorial.Tutorial;
import werdna.tutorial.items.ModItems;

public class ModFuel {
    public static void registerModFuels()
    {
        Tutorial.LOGGER.info("Register fuel items for " + Tutorial.MOD_ID);
        FuelValueEvents.BUILD.register(((builder, context) ->
        {
            builder.add(ModItems.STARLIGHT_ASHES,200);
        }));
    }
}
