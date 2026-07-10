package werdna.tutorial.items;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import werdna.tutorial.Tutorial;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.datagen.ModItemTagProvider;

public class ModItemsGroup {
    public static final CreativeModeTab MY_MODS = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "andys_mods"), FabricCreativeModeTab.builder()
                    .title(Component.translatable("tutorial.creativemodetab.everything"))
                    .icon(() -> new ItemStack(ModItems.RAW_FLOURITE))
                    .displayItems(((parameters, output) ->
                    {
                        //items
                        output.accept(ModItems.RAW_FLOURITE);
                        output.accept(ModItems.FLOURITE);
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                        output.accept(ModItems.STARLIGHT_ASHES);

                        //food items
                        output.accept(ModItems.CAULIFLOWER);

                        //blocks
                        output.accept(ModBlocks.BISMUTH);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        output.accept(ModBlocks.BISMUTH_END_ORE);
                        output.accept(ModBlocks.BISMUTH_NETHER_ORE);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.RAW_BISMUTH);
                        output.accept(ModBlocks.BISMUTH_STAIRS);
                        output.accept(ModBlocks.BISMUTH_SLAB);
                        output.accept(ModBlocks.BISMUTH_BUTTON);
                        output.accept(ModBlocks.BISMUTH_PRESSURE_PLATE);
                        output.accept(ModBlocks.BISMUTH_WALL);
                        output.accept(ModBlocks.BISMUTH_DOOR);

                        //Decorative Blocks
                        output.accept(ModBlocks.BISMUTH_LAMP);

                        //Tools
                        output.accept(ModItems.BISMUTH_SWORD);
                        output.accept(ModItems.BISMUTH_PICKAXE);
                        output.accept(ModItems.BISMUTH_AXE);
                        output.accept(ModItems.BISMUTH_SHOVEL);
                        output.accept(ModItems.BISMUTH_HOE);
                        output.accept(ModItems.BISMUTH_PAXEL);
                        output.accept(ModItems.BISMUTH_HAMMER);

                        //Armour
                        output.accept(ModItems.BISMUTH_HELMET);
                        output.accept(ModItems.BISMUTH_CHEST);
                        output.accept(ModItems.BISMUTH_LEGS);
                        output.accept(ModItems.BISMUTH_BOOTS);

                        //Custom items
                        output.accept(ModItems.CHISEL);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                    }))
            .build());

    public static void registerCreativeModeTab()
    {
        Tutorial.LOGGER.info("Creating Custom Creative mode tab for " + Tutorial.MOD_ID);
    }
}