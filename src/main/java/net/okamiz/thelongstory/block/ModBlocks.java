package net.okamiz.thelongstory.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;

public class ModBlocks {


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(TheLongStory.MOD_ID, name), block);
    }



    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TheLongStory.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks(){
        TheLongStory.LOGGER.info("Registering Blocks for " + TheLongStory.MOD_ID);
    }
}
