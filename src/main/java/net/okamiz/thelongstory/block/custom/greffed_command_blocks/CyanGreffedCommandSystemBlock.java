package net.okamiz.thelongstory.block.custom.greffed_command_blocks;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CyanGreffedCommandSystemBlock extends GreffedCommandSystemBlock{
    public CyanGreffedCommandSystemBlock(Settings settings) {
        super(settings);
        }
    public final StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 3600, 1);
/*
    @Override
    public void applyEffect(PlayerEntity player, StatusEffectInstance instance) {
        super.applyEffect(player, effectInstance);
    }
*/

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
            tooltip.add(Text.translatable("tooltip.thelongstory.press_shift_info"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
