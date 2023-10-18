package net.okamiz.thelongstory;

import net.fabricmc.api.ModInitializer;

import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.item.ModItemGroups;
import net.okamiz.thelongstory.item.ModItems;
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
	}
}