package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.UsingItemCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.THESTONE_DUST),
                        Text.literal("Shiny!"), Text.literal("Find and mine Thestone Ore."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_thestone_dust", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_DUST))
                .build(consumer, TheLongStory.MOD_ID + ":obtained_thestone_dust");



            Advancement thestoneIngotAdvancement = Advancement.Builder.create()
                    .display(new AdvancementDisplay(new ItemStack(ModItems.THESTONE_INGOT),
                            Text.literal("Is This Magic?"), Text.literal("Obtain a Thestone Ingot."),
                            new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                            true, true, false))
                    .criterion("has_thestone_ingot", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_INGOT))
                    .parent(rootAdvancement)
                    .build(consumer, TheLongStory.MOD_ID + ":obtained_thestone_ingot");


        Advancement soulContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER),
                        Text.literal("Harvest Souls?"), Text.literal("Obtain a Soul Container."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_soul_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER))
                .parent(rootAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_soul_container");


        // SOUL CONTAINERS -------------------------------------------------------------

        Advancement RegenerationContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_REGENERATION),
                        Text.literal("The Power of Regeneration."), Text.literal("Use a Soul Container on a Witch."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_regeneration_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_REGENERATION))
                .parent(soulContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_regeneration_container");

        Advancement FireResistanceContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_FIRE_RESISTANCE),
                        Text.literal("The Power of Fire Resistance."), Text.literal("Use a Soul Container on a Blaze."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_fire_resistance_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_FIRE_RESISTANCE))
                .parent(RegenerationContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_fire_resistance_container");

        Advancement LeapingContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_JUMP_BOOST),
                        Text.literal("The Power of Leaping."), Text.literal("Use a Soul Container on a Rabbit."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_leaping_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_JUMP_BOOST))
                .parent(FireResistanceContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_leaping_container");

        Advancement ResistanceContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_RESISTANCE),
                        Text.literal("The Power of Resistance."), Text.literal("Use a Soul Container on an Iron Golem."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_resistance_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_RESISTANCE))
                .parent(LeapingContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_resistance_container");

        Advancement DolphinGraceContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_DOLPHIN_GRACE),
                        Text.literal("The Power of Dolphin's Grace."), Text.literal("Use a Soul Container on a Dolphin."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_dolphin_grace_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_DOLPHIN_GRACE))
                .parent(ResistanceContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_dolphin_grace_container");

        Advancement NightVisionContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_NIGHT_VISION),
                        Text.literal("The Power of Night Vision."), Text.literal("Use a Soul Container on a Bat."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_night_vision_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_NIGHT_VISION))
                .parent(DolphinGraceContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_night_vision_container");

        Advancement SlowFallingContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_SLOW_FALLING),
                        Text.literal("The Power of Slow Falling."), Text.literal("Use a Soul Container on a Chicken."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_slow_falling_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_SLOW_FALLING))
                .parent(NightVisionContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_slow_falling_container");

        Advancement HasteContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_HASTE),
                        Text.literal("The Power of Haste."), Text.literal("Use a Soul Container on a Wither Skeleton."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_haste_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_HASTE))
                .parent(SlowFallingContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_haste_container");

        Advancement SaturationContainerAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUL_CONTAINER_SATURATION),
                        Text.literal("The Power of Saturation."), Text.literal("Use a Soul Container on a Villager."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_saturation_container", InventoryChangedCriterion.Conditions.items(ModItems.SOUL_CONTAINER_SATURATION))
                .parent(HasteContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_saturation_container");

        Advancement GreffedCommandSystemAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModBlocks.GREFFED_COMMAND_SYSTEM),
                        Text.literal("A Command Block in Survival?!"), Text.literal("Craft a Greffed Command System to apply yourself effects."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_greffed_command_system", InventoryChangedCriterion.Conditions.items(ModBlocks.GREFFED_COMMAND_SYSTEM))
                .parent(soulContainerAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_greffed_command_system");




        // -----------------------------------------------------------------------------






        // THESTONE TOOLS -------------------------------------------------------------

        Advancement thestoneSwordAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.THESTONE_SWORD),
                        Text.literal("Fight With The Light!"), Text.literal("Obtain a Thestone Sword."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_thestone_sword", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_SWORD))
                .parent(thestoneIngotAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_thestone_sword");

        Advancement thestonePickaxeAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.THESTONE_PICKAXE),
                        Text.literal("The Rainbow Pickaxe!"), Text.literal("Obtain a Thestone Pickaxe."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_thestone_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_PICKAXE))
                .parent(thestoneSwordAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_thestone_pickaxe");

        Advancement thestoneAxeAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.THESTONE_AXE),
                        Text.literal("You Seems to Like Rainbows.."), Text.literal("Obtain a Thestone Axe."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_thestone_axe", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_AXE))
                .parent(thestonePickaxeAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_thestone_axe");

        Advancement thestoneShovelAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.THESTONE_SHOVEL),
                        Text.literal("Make Paths With The Light."), Text.literal("Obtain a Thestone Shovel."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_thestone_shovel", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_SHOVEL))
                .parent(thestoneAxeAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_thestone_shovel");

        Advancement thestoneHoeAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.THESTONE_HOE),
                        Text.literal("A True Dedication."), Text.literal("Obtain a Thestone Hoe."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_thestone_hoe", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_HOE))
                .parent(thestoneShovelAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_thestone_hoe");

            // --------------------------------------------------------------------------


        Advancement thestoneFullArmorAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.THESTONE_CHESTPLATE),
                        Text.literal("The Luckiest Armor of The Game."), Text.literal("Obtain a full Thestone armor."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_thestone_helmet", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_HELMET))
                .criterion("has_thestone_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_CHESTPLATE))
                .criterion("has_thestone_leggings", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_LEGGINGS))
                .criterion("has_thestone_boots", InventoryChangedCriterion.Conditions.items(ModItems.THESTONE_BOOTS))
                .parent(thestoneIngotAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":obtained_full_thestone_armor");




        Advancement teleportationRemote = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.TELEPORTATION_REMOTE),
                        Text.literal("Get Back Home"), Text.literal("Uses a Teleportation Remote to teleport yourself to your home."),
                        new Identifier(TheLongStory.MOD_ID, "textures/block/carbon_tiles.png"), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_used_teleportation_remote", UsingItemCriterion.Conditions.create(EntityPredicate.Builder.create(),
                        ItemPredicate.Builder.create().items(ModItems.TELEPORTATION_REMOTE)))
                .parent(rootAdvancement)
                .build(consumer, TheLongStory.MOD_ID + ":used_teleportation_remote");
    }
}
