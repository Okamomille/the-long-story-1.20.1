package net.okamiz.thelongstory.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.okamiz.thelongstory.effect.ModEffects;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.world.biome.ModBiomes;
import net.okamiz.thelongstory.world.dimension.ModDimensions;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {



        if(player.getMainHandStack().isOf(ModItems.ZAROSITE_SWORD) && !world.isClient()){
            if (entity instanceof LivingEntity livingEntity){
                livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.CRYSTALIZED), player);
            }
        }



        return ActionResult.PASS;
    }
}
