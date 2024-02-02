package net.okamiz.thelongstory.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.okamiz.thelongstory.util.ModDamageTypes;

public class CrystallizedEffect extends StatusEffect {

    public CrystallizedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }



    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(ModDamageTypes.of(entity.getWorld(), ModDamageTypes.CRYSTALLIZED), 1.0F);
        super.applyUpdateEffect(entity, amplifier);
    }




    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
       return true;
    }

}
