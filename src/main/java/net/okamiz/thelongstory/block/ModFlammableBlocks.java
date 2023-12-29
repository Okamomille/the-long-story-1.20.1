package net.okamiz.thelongstory.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.okamiz.thelongstory.TheLongStory;

public class ModFlammableBlocks {

    public static void registerModFlammableBlocks(){

        TheLongStory.LOGGER.info("Registering Flammables Blocks for " + TheLongStory.MOD_ID);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_PLANKS,5,20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_LEAVES,30,60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EGRORIC_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EGRORIC_LOG,5,5);

    }
}
