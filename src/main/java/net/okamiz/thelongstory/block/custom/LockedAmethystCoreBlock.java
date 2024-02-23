package net.okamiz.thelongstory.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.okamiz.thelongstory.entity.ModEntities;
import net.okamiz.thelongstory.entity.custom.AmethystGolemEntity;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LockedAmethystCoreBlock extends Block {

    public LockedAmethystCoreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (random.nextInt(10) == 0) {
            BlockPos blockPos = pos;
            BlockState blockState = world.getBlockState(pos);
                ParticleUtil.spawnParticle(world, pos, random, ParticleTypes.REVERSE_PORTAL);
        }
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if(!world.isClient()){
            Item mainHand = player.getMainHandStack().getItem();

            if (mainHand == ModItems.AMETHYST_KEY){
                ServerWorld serverWorld = (ServerWorld)world;
                player.getStackInHand(hand).decrement(1);
                world.playSound(null, pos, SoundEvents.ITEM_TRIDENT_THUNDER, SoundCategory.MASTER, 1f, 1f);

                BlockPos blockPos = pos;
                AmethystGolemEntity boss = ModEntities.AMETHYST_GOLEM.create(world);
                boss.refreshPositionAndAngles(blockPos, 0.0f, 0.0f);
                boss.initialize(serverWorld, world.getLocalDifficulty(blockPos), SpawnReason.MOB_SUMMONED, null, null);
                serverWorld.spawnEntityAndPassengers(boss);


                world.breakBlock(pos, false);
            }
        }

        return super.onUse(state, world, pos, player, hand, hit);

    }



    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        tooltip.add(Text.translatable("tooltip.thelongstory.locked_amethyst_core"));
    }
}
