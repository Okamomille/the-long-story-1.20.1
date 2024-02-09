package net.okamiz.thelongstory;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.block.ModFlammableBlocks;
import net.okamiz.thelongstory.block.ModStrippableBlocks;
import net.okamiz.thelongstory.block.custom.FrostedIceModBlock;
import net.okamiz.thelongstory.block.entity.ModBlockEntities;
import net.okamiz.thelongstory.effect.ModEffects;
import net.okamiz.thelongstory.entity.ModEntities;
import net.okamiz.thelongstory.entity.ModEntitiesAttributes;
import net.okamiz.thelongstory.entity.custom.CrawlerEntity;
import net.okamiz.thelongstory.entity.custom.TickelerEntity;
import net.okamiz.thelongstory.entity.custom.TrepasseurEntity;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.event.EventRegister;
import net.okamiz.thelongstory.item.ModFuelRegistry;
import net.okamiz.thelongstory.item.ModItemGroups;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.particles.ModParticles;
import net.okamiz.thelongstory.recipe.ModRecipes;
import net.okamiz.thelongstory.screen.ModScreenHandlers;
import net.okamiz.thelongstory.sound.ModSounds;
import net.okamiz.thelongstory.util.ModCustomTrades;
import net.okamiz.thelongstory.util.ModLootTableModifiers;
import net.okamiz.thelongstory.world.gen.ModWorldGeneration;
import net.okamiz.thelongstory.world.tree.ModFoliagePlacerTypes;
import net.okamiz.thelongstory.world.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheLongStory implements ModInitializer {
	public static final String MOD_ID = "thelongstory";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModEntities.registerModEntities();

		ModEffects.registerEffects();
		ModScreenHandlers.registerScreenHandlers();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModFuelRegistry.registerModFuels();
		ModTrunkPlacerTypes.register();
		ModFoliagePlacerTypes.register();

		ModEntitiesAttributes.registerEntitiesAttributes();
		ModParticles.registerParticles();
		ModSounds.registerSounds();
		EventRegister.registerEvents();

		ModStrippableBlocks.registerStrippableBlocks();
		ModFlammableBlocks.registerModFlammableBlocks();

		ModWorldGeneration.generateModWorldGen();
		ModRecipes.registerRecipes();

	}
}