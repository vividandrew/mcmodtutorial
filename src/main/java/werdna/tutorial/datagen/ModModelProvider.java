package werdna.tutorial.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import werdna.tutorial.Tutorial;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.blocks.custom.BismuthLamp;
import werdna.tutorial.blocks.custom.CauliflowerCropBlock;
import werdna.tutorial.blocks.custom.RiceCropBlock;
import werdna.tutorial.data.ModDataComponent;
import werdna.tutorial.items.ModItems;
import werdna.tutorial.material.ModArmourMaterial;

import java.util.Optional;

import static net.minecraft.client.data.models.BlockModelGenerators.createBooleanModelDispatch;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

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

        //Decorate blocks
        blockModelGenerators.createDoor(ModBlocks.BISMUTH_DOOR);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_BISMUTH);
        MultiVariant off = plainVariant(TexturedModel.CUBE.create(ModBlocks.BISMUTH_LAMP, blockModelGenerators.modelOutput));
        MultiVariant on = plainVariant(blockModelGenerators.createSuffixedVariant(ModBlocks.BISMUTH_LAMP, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.BISMUTH_LAMP)
                .with(createBooleanModelDispatch(BismuthLamp.CLICKED, on, off)));

        //World gen
        blockModelGenerators.createTrivialCube(ModBlocks.BISMUTH_DEEPSLATE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BISMUTH_END_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BISMUTH_NETHER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.BISMUTH_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.MAGIC_BLOCK);

        //food
        blockModelGenerators.createCropBlock(ModBlocks.CAULIFLOWER_BLOCK, CauliflowerCropBlock.AGE, 0,1,2,3,4,5,6);
        blockModelGenerators.createCropBlock(ModBlocks.RICE_SHOOT_BLOCK, RiceCropBlock.AGE, 0,1,2,3,4,5,6,7);

        //Flowers
        blockModelGenerators.createPlantWithDefaultItem(ModBlocks.PETUNIA_FLOWER, ModBlocks.POTTED_PETUNIA, BlockModelGenerators.PlantType.TINTED);
        blockModelGenerators.createTintedLeaves(ModBlocks.COLOURED_LEAVES,TexturedModel.LEAVES, -12466612);
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
        ItemModel.Unbaked unbakedChisel = ItemModelUtils.plainModel(itemModelGenerators.createFlatItemModel(ModItems.CHISEL, ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked unbakedUsedChisel = ItemModelUtils.plainModel(itemModelGenerators.createFlatItemModel(ModItems.CHISEL, "_used", ModelTemplates.FLAT_ITEM));
        itemModelGenerators.itemModelOutput.accept(ModItems.CHISEL, new ClientItem(new ConditionalItemModel.Unbaked(Optional.empty(),
                new HasComponent(ModDataComponent.COORDINATES, false),
                unbakedUsedChisel, unbakedChisel), new ClientItem.Properties(false,false,1f)).model());

        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BISMUTH_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.createFlatItemModel(ModItems.BISMUTH_BOW, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ModItems.BISMUTH_BOW);

        //Armour
        itemModelGenerators.generateTrimmableItem(ModItems.BISMUTH_HELMET, ModArmourMaterial.BISMUTH_KEY, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.BISMUTH_CHEST, ModArmourMaterial.BISMUTH_KEY, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.BISMUTH_LEGS, ModArmourMaterial.BISMUTH_KEY, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.BISMUTH_BOOTS, ModArmourMaterial.BISMUTH_KEY, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        //food
        //itemModelGenerators.generateFlatItem(ModItems.CAULIFLOWER_SEEDS, ModelTemplates.FLAT_ITEM);

        //sounds
        itemModelGenerators.generateFlatItem(ModItems.BAR_BRAWL_DISC,ModelTemplates.FLAT_ITEM);
    }
}
