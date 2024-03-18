package net.okamiz.thelongstory.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {

    THESTONE(2, 1631, 7.5f, 3.0f, 17, () -> Ingredient.ofItems(ModItems.THESTONE_INGOT)),
    GREEN_SHARD(2, 131, 10f, 3.7f, 22, () -> Ingredient.ofItems(ModItems.GREEN_SHARD)),
    IMPURE_ZAROSITE(MiningLevels.DIAMOND, 1461, 8.5F, 3.2F, 11, () -> Ingredient.ofItems(ModItems.IMPURE_ZAROSITE_INGOT)),
    ZAROSITE(MiningLevels.NETHERITE, 2130, 9.5F, 3.7F, 13, () -> Ingredient.ofItems(ModItems.ZAROSITE_GEMSTONE)),
    PURE_AMETHYST(MiningLevels.DIAMOND, 3000, 45f, 5f, 25, () -> Ingredient.ofItems(ModItems.PURE_AMETHYST_SHARD)),
    DRONIUM(MiningLevels.NETHERITE, 2230, 10F, 4F, 18, () -> Ingredient.ofItems(ModItems.DRONIUM_INGOT)),
    PANDAZITE(MiningLevels.DIAMOND, 1461, 8.5F, 3.2F, 11, () -> Ingredient.ofItems(ModItems.PANDAZITE_INGOT));


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

}
