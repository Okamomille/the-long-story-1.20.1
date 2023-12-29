package net.okamiz.thelongstory.block.custom.greffed_command_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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

public class GreffedCommandSystemBlock extends Block{

    private float timer = 0;
    private final float timerdelay = 3600;
    public final StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.REGENERATION, 3600, 1);

    public GreffedCommandSystemBlock(Settings settings) {
        super(settings);
        }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){

        if(this.timer <= 0){
            if(!world.isClient()){
                applyEffect(player, effectInstance);
                this.timer = timerdelay;
            }
            world.playSound(player, pos, SoundEvents.ENTITY_ALLAY_AMBIENT_WITH_ITEM, SoundCategory.BLOCKS, 1f, 1.2f);
            world.playSound(player, pos, SoundEvents.ITEM_LODESTONE_COMPASS_LOCK, SoundCategory.BLOCKS, 1f, 1f);

        }else if (this.timer > 0){
            //WRONG
            if(!world.isClient()){
            player.sendMessage(Text.literal("§o§7The Command System is cooling, you have to wait. " + this.timer));
            }
            world.playSound(player, pos, SoundEvents.BLOCK_CHEST_LOCKED, SoundCategory.BLOCKS, 1f, 2f);
        }
        return ActionResult.SUCCESS;
    }


    public void applyEffect(PlayerEntity player, StatusEffectInstance instance){

        player.addStatusEffect(instance);

    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if(this.timer > 0){
            this.timer --;
        }
        super.randomDisplayTick(state, world, pos, random);
    }

}
