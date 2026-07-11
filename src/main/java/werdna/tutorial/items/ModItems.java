package werdna.tutorial.items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import werdna.tutorial.Tutorial;
import werdna.tutorial.items.custom.Chisel;
import werdna.tutorial.items.custom.Hammer;
import werdna.tutorial.items.custom.Paxel;
import werdna.tutorial.material.ModArmourMaterial;
import werdna.tutorial.material.ModToolMaterial;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static final Item FLOURITE = registerItem("flourite", Item::new);
    public static final Item RAW_FLOURITE = registerItem("raw_flourite", Item::new);
    public static final Item BISMUTH = registerItem("bismuth", Item::new);
    public static final Item RAW_BISMUTH = registerItem("raw_bismuth", Item::new);
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", Item::new);

    //Tools
    public static final Item BISMUTH_SWORD = registerItem("bismuth_sword", properties -> new Item(properties.sword(ModToolMaterial.BISMUTH,3f, -2.3f)));
    public static final Item BISMUTH_PICKAXE = registerItem("bismuth_pickaxe", properties -> new Item(properties.pickaxe(ModToolMaterial.BISMUTH,1f,-2.8f)));
    public static final Item BISMUTH_SHOVEL = registerItem("bismuth_shovel",properties -> new ShovelItem(ModToolMaterial.BISMUTH,1.5f, -3.0f, properties));
    public static final Item BISMUTH_HOE = registerItem("bismuth_hoe", properties -> new HoeItem(ModToolMaterial.BISMUTH, -2f, -1f, properties));
    public static final Item BISMUTH_AXE = registerItem("bismuth_axe", properties -> new AxeItem(ModToolMaterial.BISMUTH, 6f, -3.1f, properties));
    public static final Item BISMUTH_PAXEL = registerItem("bismuth_paxel", properties -> new Paxel(
            ModToolMaterial.BISMUTH, 6f, -3.1f, properties
    ));
    public static final Item BISMUTH_HAMMER = registerItem("bismuth_hammer",properties -> new Hammer(
            properties.pickaxe(ModToolMaterial.BISMUTH,1f,-2.8f)
    ));
    public static final Item CHISEL = registerItem("chisel", properties -> new Chisel(
            properties.durability(32)
    ));
    public static final Item BISMUTH_BOW = registerItem("bismuth_bow", properties -> new BowItem(
            properties.durability(500)
    ));

    //Armour
    public static final Item BISMUTH_HELMET = registerItem("bismuth_helmet", properties -> new Item(
            properties.humanoidArmor(ModArmourMaterial.Bismuth, ArmorType.HELMET)
    ));
    public static final Item BISMUTH_CHEST = registerItem("bismuth_chestplate", properties -> new Item(
            properties.humanoidArmor(ModArmourMaterial.Bismuth, ArmorType.CHESTPLATE)
    ));
    public static final Item BISMUTH_LEGS = registerItem("bismuth_leggings", properties -> new Item(
            properties.humanoidArmor(ModArmourMaterial.Bismuth, ArmorType.LEGGINGS)
    ));
    public static final Item BISMUTH_BOOTS = registerItem("bismuth_boots", properties -> new Item(
            properties.humanoidArmor(ModArmourMaterial.Bismuth,ArmorType.BOOTS)
    ));

    //Food
    public static final Item CAULIFLOWER = registerItem("cauliflower", properties -> new Item(properties.food(ModFoodProperties.CAULIFLOWER, ModFoodProperties.CAULIFLOWER_EFFECT)));

    /* For smaller objects can also write them as such
    public static final Item CAULIFLOWER = registerItem("cauliflower", properties -> new Item(
            properties.food(new FoodProperties.Builder().nutrition(5).saturationModifier(.6f).build())
    ){
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            if(Minecraft.getInstance().hasShiftDown())
            {
                builder.accept(Component.translatable("tooltip.tutorial.cauliflower.shift.down"));
            }else{
                builder.accept(Component.translatable("tooltip.tutorial.cauliflower.shift.up"));
            }
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });*/

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
