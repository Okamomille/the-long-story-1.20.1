package net.okamiz.thelongstory.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.okamiz.thelongstory.world.dimension.ModDimensions;

public class SimulationTeleporterBlock extends Block {
    public SimulationTeleporterBlock(Settings settings) {
        super(settings);
    }

    private static void giveEntityEffect(PlayerEntity pe) {
        pe.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 60, 1, false, false));
        pe.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 1, false, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world instanceof ServerWorld && player.canUsePortals()) {
            RegistryKey<World> registryKey = ModDimensions.SIMULATION_LEVEL_KEY;
            ServerWorld serverWorld = ((ServerWorld)world).getServer().getWorld(registryKey);
            if (serverWorld == null) {
                return ActionResult.FAIL;

            }

            if(player instanceof ServerPlayerEntity){
                player.sendMessage(Text.translatable("message.thelongstory.simulationteleporter.success"), true);


                player.teleport(serverWorld, player.getX(), player.getY(), player.getZ(), PositionFlag.getFlags(1), player.getYaw(), player.getPitch());

                giveEntityEffect(player);
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.FAIL;
    }
}
