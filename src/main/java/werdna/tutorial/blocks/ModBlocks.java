package werdna.tutorial.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import werdna.tutorial.Tutorial;

import java.util.function.Function;

public class ModBlocks {

    public static Block BISMUTH = registerBlock("bismuth_block", properties -> new Block(properties.strength(4f)
            .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static Block BISMUTH_DEEPSLATE_ORE = registerBlock("bismuth_deepslate_ore", properties -> new DropExperienceBlock(UniformInt.of(3,5),
            properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)
    ));
    public static Block BISMUTH_END_ORE = registerBlock("bismuth_end_ore", properties -> new DropExperienceBlock(UniformInt.of(0,3),
            properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.SAND)
    ));
    public static Block BISMUTH_NETHER_ORE = registerBlock("bismuth_nether_ore", properties -> new DropExperienceBlock(UniformInt.of(0,2),
            properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)
    ));
    public static Block BISMUTH_ORE = registerBlock("bismuth_ore", properties -> new DropExperienceBlock(UniformInt.of(0,4),
            properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)
    ));
    public static Block RAW_BISMUTH = registerBlock("raw_bismuth_block", properties -> new Block(
            properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
    ));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function)
    {
        Block toRegister = function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name))));

        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name), toRegister);
    }

    public static void registerBlockItem(String name, Block block)
    {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name)))));
    }

    public static void registerBlocks()
    {
        Tutorial.LOGGER.info("Register blocks for " + Tutorial.MOD_ID);
    }
}
