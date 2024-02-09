package net.okamiz.thelongstory.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.item.ModItems;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.THESTONE_HELMET,ModItems.THESTONE_CHESTPLATE,ModItems.THESTONE_LEGGINGS,ModItems.THESTONE_BOOTS)
                .add(ModItems.IMPURE_ZAROSITE_HELMET,ModItems.IMPURE_ZAROSITE_CHESTPLATE,ModItems.IMPURE_ZAROSITE_LEGGINGS,ModItems.IMPURE_ZAROSITE_BOOTS)
                .add(ModItems.GREEN_SHARD_HELMET,ModItems.GREEN_SHARD_CHESTPLATE,ModItems.GREEN_SHARD_LEGGINGS,ModItems.GREEN_SHARD_BOOTS)
                .add(ModItems.ZAROSITE_HELMET,ModItems.ZAROSITE_CHESTPLATE,ModItems.ZAROSITE_LEGGINGS,ModItems.ZAROSITE_BOOTS)
        ;


        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.EGRORIC_PLANKS.asItem())
                .add(ModBlocks.OAST_PLANKS.asItem())
                .add(ModBlocks.SEPHIN_PLANKS.asItem())
                .add(ModBlocks.KIWI_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EGRORIC_LOG.asItem())
                .add(ModBlocks.EGRORIC_WOOD.asItem())
                .add(ModBlocks.STRIPPED_EGRORIC_LOG.asItem())
                .add(ModBlocks.STRIPPED_EGRORIC_WOOD.asItem())

                .add(ModBlocks.OAST_LOG.asItem())
                .add(ModBlocks.OAST_WOOD.asItem())
                .add(ModBlocks.STRIPPED_OAST_LOG.asItem())
                .add(ModBlocks.STRIPPED_OAST_WOOD.asItem())

                .add(ModBlocks.SEPHIN_LOG.asItem())
                .add(ModBlocks.SEPHIN_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SEPHIN_LOG.asItem())
                .add(ModBlocks.STRIPPED_SEPHIN_WOOD.asItem())

                .add(ModBlocks.KIWI_LOG.asItem())
                .add(ModBlocks.KIWI_WOOD.asItem())
                .add(ModBlocks.STRIPPED_KIWI_LOG.asItem())
                .add(ModBlocks.STRIPPED_KIWI_WOOD.asItem());
    }



}
