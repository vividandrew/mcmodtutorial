package werdna.tutorial.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import werdna.tutorial.items.ModItems;

public class RiceCropSeed extends BlockItem {

    @Override
    public InteractionResult useOn(UseOnContext context) {

        InteractionResult ir = this.place(new BlockPlaceContext(context));
        if(context.getLevel().getBlockState(context.getClickedPos().above()).getBlock() == Blocks.WATER)
        {
            BlockPlaceContext bpc = new BlockPlaceContext(context.getLevel(),context.getPlayer(),context.getHand(), context.getItemInHand(),
                    new BlockHitResult(context.getClickLocation(), context.getClickedFace(),
                            context.getClickedPos().above().relative(context.getClickedFace(), 2), true)
            );
            ir = this.place(bpc);
        }
        return !ir.consumesAction() ? this.use(context.getLevel(),context.getPlayer(), context.getHand()) : ir;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        ItemStack is = player.getItemInHand(hand);
        BlockHitResult bhr = getPlayerPOVHitResult(level,player, ClipContext.Fluid.SOURCE_ONLY);

        if(bhr.getType() == HitResult.Type.MISS)
        {
            return InteractionResult.PASS;
        }else if(bhr.getType() != HitResult.Type.BLOCK)
        {
            return InteractionResult.PASS;
        }else{
            BlockPos pos = bhr.getBlockPos();
            Direction dir = bhr.getDirection();
            BlockPos relativepos = pos.relative(dir);

            if(level.mayInteract(player, pos) && player.mayUseItemAt(relativepos, dir, is))
            {
                this.place(new BlockPlaceContext(player,hand, is,  new BlockHitResult(bhr.getLocation(),
                        dir, relativepos, true)));
                return InteractionResult.SUCCESS;
            }else {
                return InteractionResult.FAIL;
            }
        }
    }

    public RiceCropSeed(Block block, Properties properties) {
        super(block, properties);
    }
}
