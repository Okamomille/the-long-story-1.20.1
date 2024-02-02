package net.okamiz.thelongstory.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.okamiz.thelongstory.effect.ModEffects;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ZarositeSwordItem extends SwordItem {
    public ZarositeSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(ModEffects.CRYSTALIZED, 60, 0), attacker);
        return super.postHit(stack, target, attacker);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.thelongstory.zarosite_sword"));
        }else{
            tooltip.add(Text.translatable("tooltip.thelongstory.press_shift_info"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
