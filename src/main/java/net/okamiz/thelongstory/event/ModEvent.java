package net.okamiz.thelongstory.event;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.okamiz.thelongstory.util.ModTags;
import net.okamiz.thelongstory.world.biome.ModBiomes;
import org.jetbrains.annotations.Nullable;

public class ModEvent implements WorldTickCallback {


    @Override
    public void tick(World world) {
        if(!world.isClient() && world.getPlayers() instanceof PlayerEntity player){

            if(player.isTouchingWater()) {//&& player.getWorld().getBiome(player.getBlockPos()) == ModBiomes.SNOW_FOREST){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON));
            }
        }
    }
}
