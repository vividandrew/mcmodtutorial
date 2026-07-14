package werdna.tutorial.items.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.data.ModDataComponent;
import werdna.tutorial.items.ModItems;
import werdna.tutorial.sounds.ModSounds;

import java.util.Map;
import java.util.function.Consumer;

public class Chisel extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.CHISELED_STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.GOLD_BLOCK, ModBlocks.BISMUTH,
                    ModBlocks.BISMUTH, Blocks.GOLD_BLOCK
            );

    private static final BooleanProperty HAS_COORDS = BooleanProperty.create("has_coords");

    public Chisel(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if(Minecraft.getInstance().hasShiftDown())
        {
            builder.accept(Component.translatable("tooltip.tutorial.chisel.shift.down"));
        }else{
            builder.accept(Component.translatable("tooltip.tutorial.chisel.shift.up"));
        }

        if(itemStack.get(ModDataComponent.COORDINATES) != null)
        {
            builder.accept(Component.literal("The last block changed at " + itemStack.get(ModDataComponent.COORDINATES)));
        }

        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
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

                context.getItemInHand().set(ModDataComponent.COORDINATES, context.getClickedPos());
                lvl.playSound(null, context.getClickedPos(),ModSounds.CHISEL_USE, SoundSource.BLOCKS, 10f,1f);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
