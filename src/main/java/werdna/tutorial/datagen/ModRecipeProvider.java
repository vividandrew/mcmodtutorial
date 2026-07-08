package werdna.tutorial.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import werdna.tutorial.Tutorial;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.items.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> BISMUTH_SMELTABLE = List.of(ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE,
                        ModBlocks.BISMUTH_END_ORE, ModBlocks.BISMUTH_NETHER_ORE, ModItems.RAW_BISMUTH);

                oreSmelting(BISMUTH_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.BISMUTH,
                        0.25f, 200, "bismuth");
                oreBlasting(BISMUTH_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.BISMUTH,
                        0.25f, 100, "bismuth");

                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.BISMUTH, RecipeCategory.DECORATIONS,
                        ModBlocks.BISMUTH);

                stairBuilder(ModBlocks.BISMUTH_STAIRS, Ingredient.of(ModBlocks.BISMUTH))
                        .unlockedBy(getHasName(ModBlocks.BISMUTH), has(ModBlocks.BISMUTH))
                        .save(output);

                slab(RecipeCategory.BUILDING_BLOCKS,ModBlocks.BISMUTH_SLAB,ModBlocks.BISMUTH);

                pressurePlate(ModBlocks.BISMUTH_PRESSURE_PLATE, ModBlocks.BISMUTH);
                buttonBuilder(ModBlocks.BISMUTH_BUTTON,Ingredient.of(ModBlocks.BISMUTH))
                        .unlockedBy(getHasName(ModBlocks.BISMUTH), has(ModBlocks.BISMUTH))
                        .save(output);

                wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_WALL, Ingredient.of(ModBlocks.BISMUTH))
                        .unlockedBy(getHasName(ModBlocks.BISMUTH), has(ModBlocks.BISMUTH))
                        .save(output);

                doorBuilder(ModBlocks.BISMUTH_DOOR, Ingredient.of(ModBlocks.BISMUTH));


                shaped(RecipeCategory.MISC, ModBlocks.RAW_BISMUTH)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RAW_BISMUTH)
                        .unlockedBy(getHasName(ModItems.RAW_BISMUTH), has(ModItems.RAW_BISMUTH))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.CHISEL)
                        .pattern(" B")
                        .pattern("s ")
                        .define('B', ModItems.BISMUTH)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BISMUTH), has(ModItems.BISMUTH))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_BISMUTH, 9)
                        .requires(ModBlocks.RAW_BISMUTH)
                        .unlockedBy(getHasName(ModBlocks.RAW_BISMUTH), has(ModBlocks.RAW_BISMUTH))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Andys Tutorial Recipes";
    }
}
