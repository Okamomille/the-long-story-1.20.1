package net.okamiz.thelongstory.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents extends FoodComponents {
    public static final FoodComponent EMERALD_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(8).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 3600),100).build();

    public static final FoodComponent IRON_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(3).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60,0),100).build();

    public static final FoodComponent DIAMOND_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(10).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 2400, 0),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 2400,0),75).build();

    public static final FoodComponent REDSTONE_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1200,0),75).build();

    public static final FoodComponent LAPIS_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(4).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1200),100)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 3600),100).build();

    public static final FoodComponent AMETHYST_APPLE = new FoodComponent.Builder().alwaysEdible().hunger(5).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 400, 0, false, false, true),75)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200,0, false, false, true),100).build();

    public static final FoodComponent INFESTED_FLESH = new FoodComponent.Builder().alwaysEdible().hunger(1).saturationModifier(1f).meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 0),0.8F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 300,1),100).build();

    public static final FoodComponent BREEDY_FLESH = new FoodComponent.Builder().hunger(4).saturationModifier(1f).build();
    public static final FoodComponent TOOKI_MEAT = new FoodComponent.Builder().hunger(3).saturationModifier(1f).build();
    public static final FoodComponent COOKED_TOOKI_MEAT = new FoodComponent.Builder().hunger(6).saturationModifier(2f).build();

    public static final FoodComponent VITALY_FRUIT = new FoodComponent.Builder().hunger(4).saturationModifier(1f).build();
    public static final FoodComponent TORN_CARROT = new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).build();
    public static final FoodComponent SWEET_PEAR = new FoodComponent.Builder().hunger(5).saturationModifier(0.8f).build();
}
