package werdna.tutorial.items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import werdna.tutorial.Tutorial;

import java.util.function.Function;

public class ModItems {
    public static final Item FLOURITE = registerItem("flourite", Item::new);
    public static final Item RAW_FLOURITE = registerItem("raw_flourite", Item::new);

    public static Item registerItem(String name, Function<Item.Properties, Item> function )
    {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name)))));
    }

    public static void registerItems()
    {
        Tutorial.LOGGER.info("Register Modded items for " + Tutorial.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(FLOURITE);
            output.accept(RAW_FLOURITE);
        });
    }
}
