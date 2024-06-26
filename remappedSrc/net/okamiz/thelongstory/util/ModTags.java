package net.okamiz.thelongstory.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;

public class ModTags {
    public static class Blocks
    {

        public static final TagKey<Block> DEEP_ICE_REPLACABLES =
                createTag("deep_ice_replacable");



        public static final TagKey<Block> RADAR_DETECTABLE_BLOCKS =
                createTag("radar_detectable_blocks");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TheLongStory.MOD_ID, name));
        }
    }

    public static class Items
    {


        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(TheLongStory.MOD_ID, name));
        }
    }

}
