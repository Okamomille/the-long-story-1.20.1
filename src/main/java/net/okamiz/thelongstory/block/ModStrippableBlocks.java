package net.okamiz.thelongstory.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlocks {

    public static void registerStrippableBlocks(){
        StrippableBlockRegistry.register(ModBlocks.EGRORIC_LOG, ModBlocks.STRIPPED_EGRORIC_LOG);
        StrippableBlockRegistry.register(ModBlocks.EGRORIC_WOOD, ModBlocks.STRIPPED_EGRORIC_WOOD);
    }
}
