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

public class ModItemsGroup {
    public static final CreativeModeTab MY_MODS = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "andys_mods"), FabricCreativeModeTab.builder()
                    .title(Component.translatable("tutorial.creativemodetab.everything"))
                    .icon(() -> new ItemStack(ModItems.RAW_FLOURITE))
                    .displayItems(((parameters, output) ->
                    {
                        output.accept(ModItems.RAW_FLOURITE);
                        output.accept(ModItems.FLOURITE);
                    }))
            .build());

    public static void registerCreativeModeTab()
    {
        Tutorial.LOGGER.info("Creating Custom Creative mode tab for " + Tutorial.MOD_ID);
    }
}