package werdna.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BISMUTH.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_END_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_NETHER_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.RAW_BISMUTH.properties().blockIdOrThrow());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BISMUTH.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_END_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_NETHER_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.RAW_BISMUTH.properties().blockIdOrThrow());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.properties().blockIdOrThrow());
    }
}
