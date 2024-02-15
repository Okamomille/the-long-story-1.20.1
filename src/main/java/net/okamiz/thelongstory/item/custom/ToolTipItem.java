package net.okamiz.thelongstory.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ToolTipItem extends Item {


    public ToolTipItem(Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {


       // if (stack.equals(new ItemStack(ModBlocks.GREFFED_COMMAND_SYSTEM))){

       // }



        //BLOCKS



        super.appendTooltip(stack, world, tooltip, context);
    }
}
