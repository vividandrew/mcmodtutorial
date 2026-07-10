package werdna.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.Nullable;
import werdna.tutorial.Tutorial;
import werdna.tutorial.items.ModItems;
import werdna.tutorial.tag.ModTags;

import java.lang.reflect.Modifier;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BISMUTH.builtInRegistryHolder().key())
                .add(Items.GOLD_INGOT.builtInRegistryHolder().key());

        //Tools
        tag(ItemTags.SWORDS)
                .add(ModItems.BISMUTH_SWORD.builtInRegistryHolder().key());

        tag(ItemTags.PICKAXES)
                .add(ModItems.BISMUTH_PICKAXE.builtInRegistryHolder().key())
                .add(ModItems.BISMUTH_PAXEL.builtInRegistryHolder().key())
                .add(ModItems.BISMUTH_HAMMER.builtInRegistryHolder().key());

        tag(ItemTags.AXES)
                .add(ModItems.BISMUTH_AXE.builtInRegistryHolder().key())
                .add(ModItems.BISMUTH_PAXEL.builtInRegistryHolder().key());

        tag(ItemTags.HOES)
                .add(ModItems.BISMUTH_HOE.builtInRegistryHolder().key());

        tag(ItemTags.SHOVELS)
                .add(ModItems.BISMUTH_SHOVEL.builtInRegistryHolder().key())
                .add(ModItems.BISMUTH_PAXEL.builtInRegistryHolder().key());

        tag(ModTags.Items.BISMUTH_TOOL_MATERIAL)
                .add(ModItems.BISMUTH.builtInRegistryHolder().key());
        tag(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.BISMUTH_BOW.builtInRegistryHolder().key());

        //Armour
        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.BISMUTH_HELMET.builtInRegistryHolder().key());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.BISMUTH_CHEST.builtInRegistryHolder().key());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.BISMUTH_LEGS.builtInRegistryHolder().key());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.BISMUTH_BOOTS.builtInRegistryHolder().key());
    }
}
