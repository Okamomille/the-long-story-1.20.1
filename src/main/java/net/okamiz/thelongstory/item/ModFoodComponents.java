package net.okamiz.thelongstory.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent EMERALD_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400,1),100).build();

    public static final FoodComponent IRON_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50,1),100).build();

    public static final FoodComponent DIAMOND_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 2400),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 2400, 1),100).build();

    public static final FoodComponent REDSTONE_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3600),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400,1),100).build();

    public static final FoodComponent LAPIS_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3600),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 3600),100).build();

    public static final FoodComponent AMETHYST_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 3600, 1, false, false, true),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400,1, false, false, true),100).build();
}
