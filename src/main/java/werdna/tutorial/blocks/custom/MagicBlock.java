package werdna.tutorial.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import werdna.tutorial.items.ModItems;
import werdna.tutorial.tag.ModTags;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS,1f,1f);
        return InteractionResult.SUCCESS;
    }
    private boolean isValiditem(ItemStack item)
    {/*
        if(item.is(Items.GOLD_INGOT))
        {
            return true;
        }
        if(item.is(ModItems.BISMUTH))
        {
            return true;
        }*/
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        if(entity instanceof LivingEntity en)
        {
            if(!en.hasEffect(MobEffects.GLOWING)) en.addEffect(new MobEffectInstance(MobEffects.GLOWING, 400));
        }

        if(entity instanceof ItemEntity ie)
        {
            if(isValiditem(ie.getItem()))
            {
                ie.setItem(new ItemStack(Items.DIAMOND,ie.getItem().count()));
            }
        }
        super.stepOn(level, pos, onState, entity);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance) {

        super.fallOn(level, state, pos, entity, fallDistance);
    }
}
