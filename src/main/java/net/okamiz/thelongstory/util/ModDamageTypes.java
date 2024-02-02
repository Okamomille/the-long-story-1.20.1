package net.okamiz.thelongstory.util;

import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.okamiz.thelongstory.TheLongStory;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> CRYSTALIZED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier(TheLongStory.MOD_ID, "crystalized"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
