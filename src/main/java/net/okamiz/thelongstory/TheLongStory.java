package net.okamiz.thelongstory;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.okamiz.thelongstory.effect.ModEffects;
import net.okamiz.thelongstory.entity.ModEntities;
import net.okamiz.thelongstory.entity.custom.CrawlerEntity;
import net.okamiz.thelongstory.entity.custom.TickelerEntity;
import net.okamiz.thelongstory.entity.custom.TrepasseurEntity;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.item.ModItemGroups;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.util.ModCustomTrades;
import net.okamiz.thelongstory.util.ModLootTableModifiers;
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
		ModEntities.registerModEntities();

		ModEffects.registerEffects();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		FuelRegistry.INSTANCE.add(ModItems.RED_COAL, 3200);
		FuelRegistry.INSTANCE.add(ModBlocks.RED_COAL_BLOCK, 32000);

		FabricDefaultAttributeRegistry.register(ModEntities.TREPASSEUR, TrepasseurEntity.createTrepasseurAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.TICKELER, TickelerEntity.createTickelerAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER, CrawlerEntity.createCrawlerAttributes());

		StrippableBlockRegistry.register(ModBlocks.EGRORIC_LOG, ModBlocks.STRIPPED_EGRORIC_LOG);
		StrippableBlockRegistry.register(ModBlocks.EGRORIC_WOOD, ModBlocks.STRIPPED_EGRORIC_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_PLANKS,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_LEAVES,30,60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EGRORIC_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EGRORIC_LOG,5,5);
	}
}