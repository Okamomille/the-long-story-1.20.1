package net.okamiz.thelongstory.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlocks {

    public static void registerModFlammableBlocks(){

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_PLANKS,5,20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_LEAVES,30,60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGRORIC_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EGRORIC_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EGRORIC_LOG,5,5);

    }
}
