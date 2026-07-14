package werdna.tutorial.mixin;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.VegetationBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import werdna.tutorial.blocks.ModBlocks;

@Mixin(CropBlock.class)
public class CropBlockMixin extends VegetationBlock {
    protected CropBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "getGrowthSpeed", at = @At(value="TAIL"), cancellable = true)
    protected static void getGrowthSpeedMixin(final Block t, final BlockGetter l, final BlockPos pos, CallbackInfoReturnable<Float> info)
    {
        float speed = 1.0F;
        if(l.getBlockState(pos).is(ModBlocks.RICE_SHOOT_BLOCK))
        {
            //What can be done, is if the water bellow is of higher quality then speed can be manipulated,
            //however no other liquids involved other than water, so will remain at reasonable speeds
            speed = 3f;
            info.setReturnValue(speed);
        }
    }

    @Override
    protected MapCodec<? extends VegetationBlock> codec() {
        return null;
    }
}
