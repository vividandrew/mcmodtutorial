package werdna.tutorial.effects;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;
import werdna.tutorial.attachments.custom.ManaHandler;

public class ManaAddConsumeEffect implements ConsumeEffect {
    public static final MapCodec<ManaAddConsumeEffect> CODEC = MapCodec.unit(ManaAddConsumeEffect::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, ManaAddConsumeEffect> STREAM_CODEC = StreamCodec.unit(new ManaAddConsumeEffect());


    @Override
    public Type<? extends ConsumeEffect> getType() {
        return ModConsumeEffects.MANA_ADD_CONSUME_EFFECT_TYPE;
    }

    @Override
    public boolean apply(Level level, ItemStack stack, LivingEntity user) {
        if(!level.isClientSide() && user instanceof ServerPlayer player)
        {
            ManaHandler.addClientMana(player,1);
        }
        return true;
    }
}
