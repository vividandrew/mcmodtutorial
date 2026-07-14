package werdna.tutorial.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.injection.Inject;
import werdna.tutorial.items.ModItems;
import werdna.tutorial.items.custom.RiceCropSeed;

public class RiceCropBlock extends CropBlock {
    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param properties
     */
    public RiceCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.RICE_SHOOTS;
    }


    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if(!level.isClientSide())
        {
            BlockState block = level.getBlockState(pos.below());
            if(block.is(Blocks.WATER))
            {
                BlockPos dBlock = pos.below();
                for(Direction dir: Direction.Plane.HORIZONTAL)
                {
                    BlockState fBlock = level.getBlockState(dBlock.relative(dir));
                    FluidState fluid = level.getFluidState(dBlock.relative(dir));
                    if(fluid.is(Fluids.WATER) || fBlock.is(Blocks.FROSTED_ICE))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        return super.canSurvive(state, level, pos);
    }
}
