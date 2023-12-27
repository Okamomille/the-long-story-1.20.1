package net.okamiz.thelongstory.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.okamiz.thelongstory.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeartContainerItem extends Item {
    public HeartContainerItem(Settings settings) {
        super(settings);
    }

    private PassiveEntity passive;
    private World world;


    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        if(!user.getWorld().isClient()) {

            if(entity instanceof WitchEntity && entity.getHealth() <= 15){
                entity.kill();
                user.playSound(SoundEvents.ENTITY_ALLAY_DEATH, SoundCategory.MASTER, 1f, 0.5f);
                user.playSound(SoundEvents.ENTITY_DONKEY_DEATH, SoundCategory.MASTER, 0.5f, 0.3f);
                user.playSound(SoundEvents.ITEM_TRIDENT_RIPTIDE_2, SoundCategory.MASTER, 0.5f, 0.2f);

                user.setStackInHand(hand, new ItemStack(ModItems.HEART_CONTAINER_FULL));

                return ActionResult.SUCCESS;
            }



        }

        return ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.thelongstory.heart_container"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
