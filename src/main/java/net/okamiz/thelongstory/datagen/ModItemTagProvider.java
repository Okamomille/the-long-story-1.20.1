package net.okamiz.thelongstory.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
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
                .add(ModItems.GREEN_SHARD_HELMET,ModItems.GREEN_SHARD_CHESTPLATE,ModItems.GREEN_SHARD_LEGGINGS,ModItems.GREEN_SHARD_BOOTS)
        ;
    }
}
