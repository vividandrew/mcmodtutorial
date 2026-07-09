package werdna.tutorial.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hammer extends Item {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    public Hammer(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos pos, LivingEntity owner) {
        if(itemStack.getItem() instanceof Hammer hammer && owner instanceof ServerPlayer sp)
        {
            if(HARVESTED_BLOCKS.contains(pos)) return true;

            for(BlockPos position : getBlocksToBeDestroyed(1,pos, sp))
            {
                if(pos == position || !hammer.isCorrectToolForDrops(itemStack, level.getBlockState(position)))
                {
                    continue;
                }
                HARVESTED_BLOCKS.add(position);
                sp.gameMode.destroyBlock(position);
                HARVESTED_BLOCKS.remove(position);
            }
        }
        return super.mineBlock(itemStack, level, state, pos, owner);
    }

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    public List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        if (traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                }
            }
        }

        if (traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                }
            }
        }

        if (traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                }
            }
        }

        return positions;
    }
}
