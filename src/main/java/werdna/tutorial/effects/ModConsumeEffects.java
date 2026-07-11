package werdna.tutorial.effects;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import werdna.tutorial.Tutorial;

public class ModConsumeEffects {
    public static final ConsumeEffect.Type<ManaAddConsumeEffect> MANA_ADD_CONSUME_EFFECT_TYPE =
            Registry.register(BuiltInRegistries.CONSUME_EFFECT_TYPE,
                    Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "mana_consume_effect"),
                    new ConsumeEffect.Type<>(ManaAddConsumeEffect.CODEC, ManaAddConsumeEffect.STREAM_CODEC));
    public static void registerModConsumeEffects()
    {
        Tutorial.LOGGER.info("Register consume effects for " + Tutorial.MOD_ID);
    }
}
