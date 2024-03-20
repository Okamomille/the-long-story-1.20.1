package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
                .add(ModBlocks.DEEPSLATE_THESTONE_ORE)
        .add(ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE)
                .add(ModBlocks.IMPURE_ZAROSITE_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.DEEP_ICE_REPLACABLES)
                .add(ModBlocks.DEEP_ICE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_THESTONE_ORE)
                .add(ModBlocks.THESTONE_ORE)
                .add(ModBlocks.DRONIUM_BLOCK)



                .add(ModBlocks.DEEP_ICE)
                .add(ModBlocks.ICED_COBBLESTONE)
                .add(ModBlocks.ICED_COBBLESTONE_SLAB)
                .add(ModBlocks.ICED_COBBLESTONE_STAIRS)
                .add(ModBlocks.ICED_COBBLESTONE_WALL)
                .add(ModBlocks.ICED_STONE)
                .add(ModBlocks.ICED_STONE_SLAB)
                .add(ModBlocks.ICED_STONE_STAIRS)
                .add(ModBlocks.ICED_STONE_WALL)
                .add(ModBlocks.ICED_CHISELED_STONE_BRICKS)
                .add(ModBlocks.ICED_CHISELED_STONE_BRICKS_SLAB)
                .add(ModBlocks.ICED_CHISELED_STONE_BRICKS_WALL)
                .add(ModBlocks.ICED_CHISELED_STONE_BRICKS_STAIRS)
                .add(ModBlocks.ICED_CRACKED_STONE_BRICKS)
                .add(ModBlocks.ICED_CRACKED_STONE_BRICKS_SLAB)
                .add(ModBlocks.ICED_CRACKED_STONE_BRICKS_STAIRS)
                .add(ModBlocks.ICED_CRACKED_STONE_BRICKS_WALL)
                .add(ModBlocks.ICED_STONE_BRICKS_SLAB)
                .add(ModBlocks.ICED_STONE_BRICKS_STAIRS)
                .add(ModBlocks.ICED_STONE_BRICKS_WALL)
                .add(ModBlocks.ICED_STONE_BRICKS)
                .add(ModBlocks.LAB_TILES)
                .add(ModBlocks.LAB_TILES_SLAB)
                .add(ModBlocks.LAB_TILES_STAIRS)
                .add(ModBlocks.LAB_TILES_WALL)
                .add(ModBlocks.CORRUPTED_LAB_TILES)
                .add(ModBlocks.CORRUPTED_LAB_TILES_SLAB)
                .add(ModBlocks.CORRUPTED_LAB_TILES_STAIRS)
                .add(ModBlocks.CORRUPTED_LAB_TILES_WALL)

                .add(ModBlocks.IMPURE_ZAROSITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE)
                .add(ModBlocks.IMPURE_ZAROSITE_ORE)

                .add(ModBlocks.PANDAZITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_PANDAZITE_ORE)
                .add(ModBlocks.PANDAZITE_ORE)

                .add(ModBlocks.ZAROSITE_BLOCK)
                .add(ModBlocks.DEEP_ICE_ZAROSITE_ORE)

                .add(ModBlocks.RED_COAL_BLOCK)
                .add(ModBlocks.IMPURE_GLITCHED_BLOCK)
                .add(ModBlocks.PURE_GLITCHED_BLOCK)
                .add(ModBlocks.GREFFED_COMMAND_SYSTEM)
                .add(ModBlocks.BROKEN_GREFFED_COMMAND_SYSTEM)
                .add(ModBlocks.BROKEN_SIMULATION_TELEPORTER)
                .add(ModBlocks.SIMULATION_TELEPORTER)
                .add(ModBlocks.MATERIAL_PROCESSOR)
                .add(ModBlocks.RED_COAL_GENERATOR)
        ;





        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.EGRORIC_LOG)
                .add(ModBlocks.EGRORIC_WOOD)
                .add(ModBlocks.STRIPPED_EGRORIC_LOG)
                .add(ModBlocks.STRIPPED_EGRORIC_WOOD)
                .add(ModBlocks.EGRORIC_PLANKS)

                .add(ModBlocks.OAST_LOG)
                .add(ModBlocks.OAST_WOOD)
                .add(ModBlocks.STRIPPED_OAST_LOG)
                .add(ModBlocks.STRIPPED_OAST_WOOD)
                .add(ModBlocks.OAST_PLANKS)


                .add(ModBlocks.SEPHIN_LOG)
                .add(ModBlocks.SEPHIN_WOOD)
                .add(ModBlocks.STRIPPED_SEPHIN_LOG)
                .add(ModBlocks.STRIPPED_SEPHIN_WOOD)
                .add(ModBlocks.SEPHIN_PLANKS)

                .add(ModBlocks.KIWI_LOG)
                .add(ModBlocks.KIWI_WOOD)
                .add(ModBlocks.STRIPPED_KIWI_LOG)
                .add(ModBlocks.STRIPPED_KIWI_WOOD)
                .add(ModBlocks.KIWI_PLANKS)
        ;


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.DEEP_ICE)
                .add(ModBlocks.MATERIAL_PROCESSOR)
                .add(ModBlocks.RED_COAL_GENERATOR)
                .add(ModBlocks.IMPURE_GLITCHED_BLOCK)
                .add(ModBlocks.PURE_GLITCHED_BLOCK)
                ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.IMPURE_ZAROSITE_BLOCK)
                .add(ModBlocks.ZAROSITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE)
                .add(ModBlocks.IMPURE_ZAROSITE_ORE)

                .add(ModBlocks.PANDAZITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_PANDAZITE_ORE)
                .add(ModBlocks.PANDAZITE_ORE)

                .add(ModBlocks.DEEPSLATE_THESTONE_ORE)
                .add(ModBlocks.THESTONE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEP_ICE_ZAROSITE_ORE)

                ;

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_4")))
                ;

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.OAST_FENCE)
                .add(ModBlocks.KIWI_FENCE)
                .add(ModBlocks.SEPHIN_FENCE)
                .add(ModBlocks.EGRORIC_FENCE)
        ;

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.OAST_FENCE_GATE)
                .add(ModBlocks.KIWI_FENCE_GATE)
                .add(ModBlocks.SEPHIN_FENCE_GATE)
                .add(ModBlocks.EGRORIC_FENCE_GATE)
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.EGRORIC_DOOR)
                .add(ModBlocks.OAST_DOOR)
                .add(ModBlocks.OAST_DOOR)
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EGRORIC_TRAPDOOR)
                .add(ModBlocks.OAST_TRAPDOOR)
                .add(ModBlocks.SEPHIN_TRAPDOOR)
                .add(ModBlocks.KIWI_TRAPDOOR)
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.EGRORIC_SLAB)
                .add(ModBlocks.OAST_SLAB)
                .add(ModBlocks.SEPHIN_SLAB)
                .add(ModBlocks.KIWI_SLAB)
        ;

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.ICED_STONE_SLAB)
                .add(ModBlocks.ICED_COBBLESTONE_SLAB)
                .add(ModBlocks.ICED_CRACKED_STONE_BRICKS_SLAB)
                .add(ModBlocks.ICED_CHISELED_STONE_BRICKS_SLAB)
                .add(ModBlocks.ICED_STONE_BRICKS_SLAB)
        ;

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.ICED_STONE_STAIRS)
                .add(ModBlocks.ICED_COBBLESTONE_STAIRS)
                .add(ModBlocks.ICED_CRACKED_STONE_BRICKS_STAIRS)
                .add(ModBlocks.ICED_CHISELED_STONE_BRICKS_STAIRS)
                .add(ModBlocks.ICED_STONE_BRICKS_STAIRS)
        ;

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ICED_STONE_WALL)
                .add(ModBlocks.ICED_COBBLESTONE_WALL)
                .add(ModBlocks.ICED_CRACKED_STONE_BRICKS_WALL)
                .add(ModBlocks.ICED_CHISELED_STONE_BRICKS_WALL)
                .add(ModBlocks.ICED_STONE_BRICKS_WALL)
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.EGRORIC_STAIRS)
                .add(ModBlocks.OAST_STAIRS)
                .add(ModBlocks.SEPHIN_STAIRS)
                .add(ModBlocks.KIWI_STAIRS)
        ;


        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.EGRORIC_LOG)
                .add(ModBlocks.EGRORIC_WOOD)
                .add(ModBlocks.STRIPPED_EGRORIC_LOG)
                .add(ModBlocks.STRIPPED_EGRORIC_WOOD)

                .add(ModBlocks.OAST_LOG)
                .add(ModBlocks.OAST_WOOD)
                .add(ModBlocks.STRIPPED_OAST_LOG)
                .add(ModBlocks.STRIPPED_OAST_WOOD)

                .add(ModBlocks.SEPHIN_LOG)
                .add(ModBlocks.SEPHIN_WOOD)
                .add(ModBlocks.STRIPPED_SEPHIN_LOG)
                .add(ModBlocks.STRIPPED_SEPHIN_WOOD)

                .add(ModBlocks.KIWI_LOG)
                .add(ModBlocks.KIWI_WOOD)
                .add(ModBlocks.STRIPPED_KIWI_LOG)
                .add(ModBlocks.STRIPPED_KIWI_WOOD)
        ;

        getOrCreateTagBuilder(BlockTags.SAND)
                .add(ModBlocks.TORCH_SAND)
                .add(ModBlocks.TORCH_PINK_SAND)
        ;



    }




}
