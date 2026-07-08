package werdna.tutorial.items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import werdna.tutorial.Tutorial;
import werdna.tutorial.items.custom.Chisel;

import java.util.function.Function;

public class ModItems {
    public static final Item FLOURITE = registerItem("flourite", Item::new);
    public static final Item RAW_FLOURITE = registerItem("raw_flourite", Item::new);
    public static final Item BISMUTH = registerItem("bismuth", Item::new);
    public static final Item RAW_BISMUTH = registerItem("raw_bismuth", Item::new);
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", Item::new);

    public static final Item CHISEL = registerItem("chisel", properties -> new Chisel(
            properties.durability(32)
    ));
    public static final Item CAULIFLOWER = registerItem("cauliflower", properties -> new Item(
            properties.food(new FoodProperties.Builder().nutrition(5).saturationModifier(.6f).build())
    ));

    public static Item registerItem(String name, Function<Item.Properties, Item> function )
    {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name)))));
    }

    public static void registerItems()
    {
        Tutorial.LOGGER.info("Register Modded items for " + Tutorial.MOD_ID);

        /* add to existing tabs
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(FLOURITE);
            output.accept(RAW_FLOURITE);
        });*/
    }
}
