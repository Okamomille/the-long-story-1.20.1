package net.okamiz.thelongstory;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.okamiz.entity.ModEntities;
import net.okamiz.entity.custom.TrepasseurEntity;
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

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		FuelRegistry.INSTANCE.add(ModItems.RED_COAL, 3200);
		FuelRegistry.INSTANCE.add(ModBlocks.RED_COAL_BLOCK, 32000);

		FabricDefaultAttributeRegistry.register(ModEntities.TREPASSEUR, TrepasseurEntity.createTrepasseurAttributes());
	}
}