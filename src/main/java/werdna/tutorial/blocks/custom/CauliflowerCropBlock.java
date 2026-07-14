package werdna.tutorial.blocks.custom;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import werdna.tutorial.items.ModItems;

public class CauliflowerCropBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);


    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param properties
     */
    public CauliflowerCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CAULIFLOWER_SEEDS;
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
