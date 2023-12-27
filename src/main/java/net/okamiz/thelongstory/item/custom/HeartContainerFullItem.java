package net.okamiz.thelongstory.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeartContainerFullItem extends Item {

    public HeartContainerFullItem(Settings settings) {
        super(settings);
    }


    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

            tooltip.add(Text.translatable("tooltip.thelongstory.heart_container_full"));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
