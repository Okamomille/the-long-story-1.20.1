package net.okamiz.thelongstory.item.custom;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.okamiz.thelongstory.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class TeleportationRemoteItem extends Item {

    public TeleportationRemoteItem(FabricItemSettings fabricItemSettings) {
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
                world.playSound(null, player.getBlockPos(), ModSounds.TELEPORTATION, SoundCategory.PLAYERS, 1f, 1f);
                player.teleport(serverWorld, x, y, z, PositionFlag.getFlags(1), player.getYaw(), player.getPitch());
                world.playSound(null, player.getBlockPos(), ModSounds.TELEPORTATION, SoundCategory.PLAYERS, 1f, 1f);
                giveEntityEffect(player);
                player.getItemCooldownManager().set(this, 1200);

            }else{
                player.sendMessage(Text.translatable("message.thelongstory.overworldteleporter.fail"), true);
            }



        }



        return super.use(world, player, hand);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.thelongstory.teleportation_remote"));
        }else{
            tooltip.add(Text.translatable("tooltip.thelongstory.press_shift_info"));
        }
    }
}