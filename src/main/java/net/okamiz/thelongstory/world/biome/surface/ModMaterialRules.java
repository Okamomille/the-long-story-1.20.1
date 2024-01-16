package net.okamiz.thelongstory.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.world.biome.ModBiomes;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final MaterialRules.MaterialRule SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final MaterialRules.MaterialRule WHITE_SAND = makeStateRule(Blocks.WHITE_CONCRETE_POWDER);

    private static final MaterialRules.MaterialRule BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final MaterialRules.MaterialRule MAGMA_BLOCK = makeStateRule(Blocks.MAGMA_BLOCK);
    private static final MaterialRules.MaterialRule LAVA = makeStateRule(Blocks.LAVA);
    private static final MaterialRules.MaterialRule DEEP_ICE = makeStateRule(ModBlocks.DEEP_ICE);

    public static MaterialRules.MaterialRule makeRules() {

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.verticalGradient
                        ("snow_forest_bedrock", YOffset.aboveBottom(0),YOffset.aboveBottom(3)), BEDROCK),
                 MaterialRules.condition(MaterialRules.verticalGradient
                        ("snow_forest_magma", YOffset.aboveBottom(3),YOffset.aboveBottom(6)), MAGMA_BLOCK),
                MaterialRules.condition(MaterialRules.verticalGradient
                        ("snow_forest_lava", YOffset.aboveBottom(5),YOffset.aboveBottom(10)), LAVA),


                MaterialRules.condition(MaterialRules.biome(ModBiomes.SNOW_FOREST),(MaterialRules.condition(MaterialRules.verticalGradient
                        ("snow_forest_bedrock", YOffset.aboveBottom(10),YOffset.aboveBottom(64)), DEEP_ICE))),
                MaterialRules.condition(MaterialRules.biome(ModBiomes.SNOW_FOREST), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, SNOW_BLOCK)),
                MaterialRules.condition(MaterialRules.biome(ModBiomes.SNOW_FOREST), PACKED_ICE),


                MaterialRules.condition(MaterialRules.biome(ModBiomes.WHITE_BEACH), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, WHITE_SAND))

        );


    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
