package werdna.tutorial.registries;

import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import werdna.tutorial.Tutorial;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.items.ModItems;

public class ModCompostables {
    public static void registerModCompostables()
    {
        Tutorial.LOGGER.info("Register compostable items for " + Tutorial.MOD_ID);
        CompostableRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5f);
        CompostableRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.15f);
        CompostableRegistry.INSTANCE.add(ModBlocks.PETUNIA_FLOWER, .8f);
    }
}
