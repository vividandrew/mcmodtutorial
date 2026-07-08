package werdna.tutorial.items.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import werdna.tutorial.blocks.ModBlocks;

import java.util.Map;

public class Chisel extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.CHISELED_STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.GOLD_BLOCK, ModBlocks.BISMUTH,
                    ModBlocks.BISMUTH, Blocks.GOLD_BLOCK
            );
    public Chisel(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level lvl = context.getLevel();
        Block clked = lvl.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clked))
        {
            if(!lvl.isClientSide())
            {
                lvl.setBlock(context.getClickedPos(), CHISEL_MAP.get(clked).defaultBlockState(), 3);

                context.getItemInHand().hurtAndBreak(1,((ServerLevel) lvl), ((ServerPlayer) context.getPlayer()),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            }
        }
        return InteractionResult.SUCCESS;
    }
}
