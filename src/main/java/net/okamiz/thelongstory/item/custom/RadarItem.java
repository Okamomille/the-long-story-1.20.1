package net.okamiz.thelongstory.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.okamiz.thelongstory.util.ModTags;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

public class RadarItem extends Item {
    public RadarItem(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                
                if(isVualuableBlock(state)){
                    
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if (!foundBlock){
                player.sendMessage(Text.literal("No Thestone Ore Found"));
            }
        }

        context.getStack().damage(1,context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos down, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " below !"), false);
    }

    private boolean isVualuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.RADAR_DETECTABLE_BLOCKS);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.thelongstory.radar"));
        }else{
            tooltip.add(Text.translatable("tooltip.thelongstory.press_shift_info"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
