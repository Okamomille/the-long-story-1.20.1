package net.okamiz.thelongstory.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheLongStory.MOD_ID, "modgroup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.modgroup"))
                    .icon(() -> new ItemStack(ModItems.BONE_FRAGMENTS)).entries((displayContext, entries) -> {

                        entries.add(ModItems.INFESTED_FLESH);
                        entries.add(ModItems.BONE_FRAGMENTS);
                        entries.add(ModItems.CRUSHED_BONES);


                        entries.add(ModBlocks.CRUSHED_BONES_BLOCK);
                        entries.add(ModBlocks.MOLD_BLOCK);


                    }).build());
    public static void registerItemGroups(){
        TheLongStory.LOGGER.info("Registering Item Groups for " + TheLongStory.MOD_ID);
    }

}
