package net.okamiz.thelongstory.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.okamiz.thelongstory.TheLongStory;

public class ModStrippableBlocks {

    public static void registerStrippableBlocks(){

        TheLongStory.LOGGER.info("Registering Strippable Blocks for " + TheLongStory.MOD_ID);

        StrippableBlockRegistry.register(ModBlocks.EGRORIC_LOG, ModBlocks.STRIPPED_EGRORIC_LOG);
        StrippableBlockRegistry.register(ModBlocks.EGRORIC_WOOD, ModBlocks.STRIPPED_EGRORIC_WOOD);
    }
}
