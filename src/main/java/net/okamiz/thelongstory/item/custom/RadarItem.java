package net.okamiz.thelongstory.item.custom;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Objects;

public class RadarItem extends Item {

    public RadarItem(FabricItemSettings fabricItemSettings) {
        super(fabricItemSettings);
    }

    private static void giveEntityEffect(PlayerEntity pe) {
        pe.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 60, 1, false, false));
        pe.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 1, false, false));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        if (world instanceof ServerWorld && player.canUsePortals()) {
            RegistryKey<World> registryKey = World.OVERWORLD;
            ServerWorld serverWorld = ((ServerWorld)world).getServer().getWorld(registryKey);
            if (serverWorld == null) {
                player.sendMessage(Text.translatable("message.thelongstory.overworldteleporter.fail"), true);
            }

            if(player instanceof ServerPlayerEntity){

                player.sendMessage(Text.translatable("message.thelongstory.overworldteleporter.success"), true);
                player.swingHand(hand);



                double x = Objects.requireNonNull(((ServerPlayerEntity) player).getSpawnPointPosition()).getX();
                double y = ((ServerPlayerEntity) player).getSpawnPointPosition().getY();
                double z = ((ServerPlayerEntity) player).getSpawnPointPosition().getZ();

                player.teleport(serverWorld, x, y, z, PositionFlag.getFlags(1), player.getYaw(), player.getPitch());
                giveEntityEffect(player);
                player.getItemCooldownManager().set(this, 1200);

            }else{
                player.sendMessage(Text.translatable("message.thelongstory.overworldteleporter.fail"), true);
            }



        }



        return super.use(world, player, hand);
    }
}