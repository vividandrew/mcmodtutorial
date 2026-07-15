package werdna.tutorial.blocks;

import net.jpountz.lz4.LZ4FrameOutputStream;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import werdna.tutorial.Tutorial;
import werdna.tutorial.blocks.custom.*;
import werdna.tutorial.sounds.ModSounds;

import java.util.function.Function;

public class ModBlocks {

    public static Block BISMUTH = registerBlock("bismuth_block", properties -> new Block(properties.strength(4f)
            .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    // Decorative
    public static Block RAW_BISMUTH = registerBlock("raw_bismuth_block", properties -> new Block(
            properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
    ));

    public static Block BISMUTH_STAIRS = registerBlock("bismuth_stairs", properties -> new StairBlock(
            ModBlocks.BISMUTH.defaultBlockState(),
            properties.strength(2f).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
    ));
    public static Block BISMUTH_SLAB = registerBlock("bismuth_slab", properties -> new SlabBlock(
            properties.strength(2f).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
    ));
    public static Block BISMUTH_BUTTON = registerBlock("bismuth_button", properties -> new ButtonBlock(BlockSetType.IRON,200,
            properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
    ));
    public static Block BISMUTH_PRESSURE_PLATE = registerBlock("bismuth_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.IRON,
            properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
    ));
    public static Block BISMUTH_WALL = registerBlock("bismuth_wall", properties -> new WallBlock(
            properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
    ));

    public static Block BISMUTH_DOOR = registerBlock("bismuth_door", properties -> new DoorBlock(BlockSetType.ACACIA,
            properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
    ));
    public static Block BISMUTH_LAMP = registerBlock("bismuth_lamp", properties -> new BismuthLamp(
            properties.lightLevel(blockState -> blockState.getValue(BismuthLamp.CLICKED) ? 15: 0)));
    public static Block CUSTOM_CHAIR = registerBlock("chair", properties -> new Chair(
            properties.sound(SoundType.WOOD).mapColor(MapColor.WOOD).pushReaction(PushReaction.DESTROY).strength(1.24f)

    ));

    //World generation
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
    public static Block MAGIC_BLOCK = registerBlock("magic_block", properties -> new MagicBlock(
            properties.sound(ModSounds.MAGIC_BLOCK_SOUNDS).strength(2f).requiresCorrectToolForDrops()
    ));

    //crops
    public static Block CAULIFLOWER_BLOCK = registerBlockWithoutItem("cauliflower_crop", properties -> new CauliflowerCropBlock(
            properties.randomTicks().instabreak().sound(SoundType.CROP).noCollision().pushReaction(PushReaction.DESTROY)
    ));

    public static Block RICE_SHOOT_BLOCK = registerBlockWithoutItem("rice_crop", properties -> new RiceCropBlock(
            properties.randomTicks().instabreak().sound(SoundType.GRASS).noCollision().pushReaction(PushReaction.DESTROY)
    ));

    public static Block PETUNIA_FLOWER = registerBlock("petunia", properties -> new FlowerBlock(
            MobEffects.BLINDNESS, 12,properties.offsetType(BlockBehaviour.OffsetType.XZ).instabreak().sound(SoundType.GRASS)
            .pushReaction(PushReaction.DESTROY).dynamicShape().noCollision()
    ));
    public static Block POTTED_PETUNIA = registerBlock("potted_petunia", properties -> new FlowerPotBlock(PETUNIA_FLOWER,
            properties.instabreak().noCollision().pushReaction(PushReaction.DESTROY)
    ));

    public static Block COLOURED_LEAVES = registerBlock("coloured_leaves", properties -> new TintedParticleLeavesBlock(.1f,
            properties.strength(.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot)
                    .isSuffocating(Blocks::never).isViewBlocking(Blocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY)
                    .isRedstoneConductor(Blocks::never)));

    private static Block registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, Block> function)
    {
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name), function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name)))));
    }

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
