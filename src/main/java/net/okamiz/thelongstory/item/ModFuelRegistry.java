package net.okamiz.thelongstory.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.okamiz.thelongstory.block.ModBlocks;

public class ModFuelRegistry {
    public static void registerModFuels(){
        FuelRegistry.INSTANCE.add(ModItems.RED_COAL, 3200);
        FuelRegistry.INSTANCE.add(ModBlocks.RED_COAL_BLOCK, 32000);
    }
}
