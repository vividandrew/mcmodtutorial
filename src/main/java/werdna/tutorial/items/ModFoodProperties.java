package werdna.tutorial.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import werdna.tutorial.effects.ManaAddConsumeEffect;

public class ModFoodProperties {
    public static final FoodProperties CAULIFLOWER =
            new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();


    public static final Consumable CAULIFLOWER_EFFECT = Consumables.defaultFood()
            .onConsume(new ManaAddConsumeEffect())
            .build();
}
