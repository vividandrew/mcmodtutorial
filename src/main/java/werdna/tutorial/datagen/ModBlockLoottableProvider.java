package werdna.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.blocks.custom.CauliflowerCropBlock;
import werdna.tutorial.blocks.custom.RiceCropBlock;
import werdna.tutorial.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLoottableProvider extends FabricBlockLootSubProvider {
    public ModBlockLoottableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.BISMUTH);
        dropSelf(ModBlocks.RAW_BISMUTH);
        dropSelf(ModBlocks.MAGIC_BLOCK);
        dropSelf(ModBlocks.BISMUTH_STAIRS);
        dropSelf(ModBlocks.BISMUTH_BUTTON);
        dropSelf(ModBlocks.BISMUTH_PRESSURE_PLATE);
        dropSelf(ModBlocks.BISMUTH_WALL);

        dropSelf(ModBlocks.PETUNIA_FLOWER);
        add(ModBlocks.POTTED_PETUNIA, createPotFlowerItemTable(ModBlocks.PETUNIA_FLOWER));

        add(ModBlocks.BISMUTH_SLAB,createSlabItemTable(ModBlocks.BISMUTH_SLAB));
        add(ModBlocks.BISMUTH_DOOR,createDoorTable(ModBlocks.BISMUTH_DOOR));

        add(ModBlocks.BISMUTH_ORE, createOreDropper(ModBlocks.BISMUTH_ORE, ModItems.RAW_BISMUTH, 1f ,2f));
        add(ModBlocks.BISMUTH_NETHER_ORE, createOreDropper(ModBlocks.BISMUTH_NETHER_ORE, ModItems.RAW_BISMUTH, 1f,1f));
        add(ModBlocks.BISMUTH_END_ORE, createOreDropper(ModBlocks.BISMUTH_END_ORE, ModItems.RAW_BISMUTH, 1f,2f));
        add(ModBlocks.BISMUTH_DEEPSLATE_ORE, createOreDropper(ModBlocks.BISMUTH_DEEPSLATE_ORE, ModItems.RAW_BISMUTH, 2f,4f));

        //Food
        var builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CAULIFLOWER_BLOCK)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CauliflowerCropBlock.AGE, CauliflowerCropBlock.MAX_AGE));
        add(ModBlocks.CAULIFLOWER_BLOCK, createCropDrops(ModBlocks.CAULIFLOWER_BLOCK, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS, builder));

        builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.RICE_SHOOT_BLOCK)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RiceCropBlock.AGE, RiceCropBlock.MAX_AGE));
        add(ModBlocks.RICE_SHOOT_BLOCK, createCropDrops(ModBlocks.RICE_SHOOT_BLOCK, ModItems.RICE_SHOOTS, ModItems.RICE_SHOOTS, builder));

    }

    public LootTable.Builder createOreDropper(final Block block, Item drop, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
