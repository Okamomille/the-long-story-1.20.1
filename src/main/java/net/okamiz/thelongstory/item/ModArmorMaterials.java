package net.okamiz.thelongstory.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.okamiz.thelongstory.TheLongStory;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    THESTONE("thestone", 25, new int[]{3,6,8,3}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.5f,0.0f, () -> Ingredient.ofItems(ModItems.THESTONE_INGOT)),

    ODMENTIUM("odmentium", 15, new int[]{3,5,6,2}, 8,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f,0.0f, () -> Ingredient.ofItems(ModItems.ODMENTIUM_INGOT)),
    GREEN_SHARD("green_shard", 7, new int[]{2,5,6,4}, 22,
    SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0f,0.0f, () -> Ingredient.ofItems(ModItems.GREEN_SHARD)),

    IMPURE_ZAROSITE("impure_zarosite", 32, new int[]{3,6,8,3}, 11,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.2f,0.1f, () -> Ingredient.ofItems(ModItems.IMPURE_ZAROSITE_INGOT)),

    ZAROSITE("zarosite", 39, new int[]{3,6,8,3}, 13,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.5f,0.2f, () -> Ingredient.ofItems(ModItems.ZAROSITE_GEMSTONE)),

    DRONIUM("dronium", 40, new int[]{3,6,8,3}, 13,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f,0.2f, () -> Ingredient.ofItems(ModItems.DRONIUM_INGOT))
    ;

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return TheLongStory.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
