package werdna.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.items.ModItems;
import werdna.tutorial.tag.ModTags;

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
                .add(ModBlocks.RAW_BISMUTH.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_STAIRS.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_SLAB.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_BUTTON.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_PRESSURE_PLATE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_WALL.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_DOOR.properties().blockIdOrThrow())
                .add(ModBlocks.MAGIC_BLOCK.properties().blockIdOrThrow());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BISMUTH.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_END_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_NETHER_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_ORE.properties().blockIdOrThrow())
                .add(ModBlocks.RAW_BISMUTH.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_STAIRS.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_SLAB.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_BUTTON.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_PRESSURE_PLATE.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_WALL.properties().blockIdOrThrow())
                .add(ModBlocks.BISMUTH_DOOR.properties().blockIdOrThrow());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.properties().blockIdOrThrow());

        tag(BlockTags.WALLS)
                .add(ModBlocks.BISMUTH_WALL.properties().blockIdOrThrow());

        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.properties().blockIdOrThrow())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRENT_FOR_BISMUTH_TOOL)
                .addOptionalTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        tag(ModTags.Blocks.PAXEL_MINABLE)
                .forceAddTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .forceAddTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_AXE);
    }
}
