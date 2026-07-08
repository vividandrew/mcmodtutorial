package werdna.tutorial.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.BlockFamily;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.items.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        var bismuth = blockModelGenerators.family(ModBlocks.BISMUTH);

        bismuth.stairs(ModBlocks.BISMUTH_STAIRS);
        bismuth.slab(ModBlocks.BISMUTH_SLAB);
        bismuth.pressurePlate(ModBlocks.BISMUTH_PRESSURE_PLATE);
        bismuth.button(ModBlocks.BISMUTH_BUTTON);
        bismuth.wall(ModBlocks.BISMUTH_WALL);

        blockModelGenerators.createDoor(ModBlocks.BISMUTH_DOOR);

        blockModelGenerators.createTrivialCube(ModBlocks.BISMUTH_DEEPSLATE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BISMUTH_END_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BISMUTH_NETHER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BISMUTH_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_BISMUTH);
        blockModelGenerators.createTrivialCube(ModBlocks.MAGIC_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        //Items
        itemModelGenerators.generateFlatItem(ModItems.FLOURITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_FLOURITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_BISMUTH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STARLIGHT_ASHES, ModelTemplates.FLAT_ITEM);

        //food
        itemModelGenerators.generateFlatItem(ModItems.CAULIFLOWER, ModelTemplates.FLAT_ITEM);

        //tools
        itemModelGenerators.generateFlatItem(ModItems.CHISEL, ModelTemplates.FLAT_ITEM);
    }
}
