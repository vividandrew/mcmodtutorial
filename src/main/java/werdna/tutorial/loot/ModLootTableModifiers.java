package werdna.tutorial.loot;

import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import werdna.tutorial.items.ModItems;

public class ModLootTableModifiers {
    public static void modifyLoottables(ResourceKey<LootTable> key, FabricLootTableBuilder builder,
                                        LootTableSource source, HolderLookup.Provider provider)
    {
        if(key.identifier().equals(Identifier.withDefaultNamespace("blocks/short_grass")))
        {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.25f))
                    .add(LootItem.lootTableItem(ModItems.CAULIFLOWER))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2)).build());

            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.VILLAGE_PLAINS_HOUSE.equals(key))
        {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.25f))
                    .add(LootItem.lootTableItem(ModItems.CAULIFLOWER))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2)).build());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/spider")))
        {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.25f))
                    .add(LootItem.lootTableItem(ModItems.CAULIFLOWER))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2)).build());

            builder.pool(poolBuilder.build());
        }
    }
}
