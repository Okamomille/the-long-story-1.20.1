package net.okamiz.thelongstory.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent EMERALD_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400,1),100).build();

}
