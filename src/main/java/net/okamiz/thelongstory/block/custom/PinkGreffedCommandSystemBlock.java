package net.okamiz.thelongstory.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stat;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PinkGreffedCommandSystemBlock extends Block{
    public PinkGreffedCommandSystemBlock(Settings settings) {
        super(settings);
        }
        private float timer = 0;
        private final float timerdelay = 3600;

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){





        if(timer <= 0){
            if(!world.isClient()){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 3600, 1));
                timer = timerdelay;
            }
            world.playSound(player, pos, SoundEvents.ENTITY_ALLAY_AMBIENT_WITH_ITEM, SoundCategory.BLOCKS, 1f, 1.2f);
            world.playSound(player, pos, SoundEvents.ITEM_LODESTONE_COMPASS_LOCK, SoundCategory.BLOCKS, 1f, 1f);

        }else if (timer > 0){
            //WRONG
            if(!world.isClient()){
            player.sendMessage(Text.literal("§o§7The Command System is cooling, you have to wait. " + timer));
            }
            world.playSound(player, pos, SoundEvents.BLOCK_CHEST_LOCKED, SoundCategory.BLOCKS, 1f, 2f);
        }


        return ActionResult.SUCCESS;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if(timer > 0){
            timer --;
        }
        super.randomDisplayTick(state, world, pos, random);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.thelongstory.pink_greffed_command_system"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
