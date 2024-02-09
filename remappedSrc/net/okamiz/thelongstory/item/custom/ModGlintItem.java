package net.okamiz.thelongstory.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class ModGlintItem extends Item {
    public ModGlintItem(Settings settings) {
        super(settings);
    }


    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }


    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }
}
