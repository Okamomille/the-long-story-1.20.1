package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ModTags.Blocks.RADAR_DETECTABLE_BLOCKS)
                .add(ModBlocks.THESTONE_ORE)
                .add(ModBlocks.DEEPSLATE_THESTONE_ORE);


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_THESTONE_ORE)
                .add(ModBlocks.THESTONE_ORE)
                .add(ModBlocks.RED_COAL_BLOCK)
                .add(ModBlocks.PINK_GREFFED_COMMAND_SYSTEM);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.EGRORIC_PLANKS);


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_THESTONE_ORE)
                .add(ModBlocks.THESTONE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                ;

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_4")))
                ;

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.EGRORIC_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.EGRORIC_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.EGRORIC_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EGRORIC_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.EGRORIC_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.EGRORIC_STAIRS);

    }
}