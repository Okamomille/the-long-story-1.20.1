package net.okamiz.thelongstory.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;


public class ModEffects {

    public static StatusEffect INFECTED;
    public static StatusEffect CRYSTALIZED;

    public static StatusEffect registerInfectedEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TheLongStory.MOD_ID, name),

                new InfectedEffect(StatusEffectCategory.HARMFUL, 5959114)
                        .addAttributeModifier(
                                EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.05F,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                        .addAttributeModifier(
                                EntityAttributes.GENERIC_MAX_HEALTH, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.10F,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }

    public static StatusEffect registerCrystallizedEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TheLongStory.MOD_ID, name),

                new CrystallizedEffect(StatusEffectCategory.HARMFUL, 7356576));
    }

    public static void registerEffects(){

        TheLongStory.LOGGER.info("Registering Effects for " + TheLongStory.MOD_ID);

        INFECTED = registerInfectedEffect("infected");
        CRYSTALIZED = registerCrystallizedEffect("crystallized");
    }
}
