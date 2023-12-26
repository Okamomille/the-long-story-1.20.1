package net.okamiz.thelongstory.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.entry.RegistryEntry;
import net.okamiz.thelongstory.damage.ModDamageTypes;

public class InfectedEffect extends StatusEffect {

    private float storedHealth;
    private int heartsLost;

    public InfectedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        storedHealth = entity.getHealth();

        if(amplifier == 0)
        {
            heartsLost = 2;
        } else if (amplifier == 1)
        {
            heartsLost = 4;
        }
        else
        {
            heartsLost = (amplifier + 1) * 2;
        }
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        super.onRemoved(attributeContainer);
        storedHealth = 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);





        /*if(entity.getHealth() < storedHealth)
        {
            entity.damage(ModDamageTypes.of(entity.getWorld(), ModDamageTypes.INFECTED), heartsLost);

            storedHealth = entity.getHealth();
        }
        if(entity.getHealth() > storedHealth)
        {
            storedHealth = entity.getHealth();
        }*/





    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
