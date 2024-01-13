package net.okamiz.thelongstory.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.world.biome.ModBiomes;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final MaterialRules.MaterialRule SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);

    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final MaterialRules.MaterialRule MAGMA_BLOCK = makeStateRule(Blocks.MAGMA_BLOCK);
    private static final MaterialRules.MaterialRule LAVA = makeStateRule(Blocks.LAVA);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule snowSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, SNOW_BLOCK), PACKED_ICE);
        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.verticalGradient
                        ("snow_forest_bedrock", YOffset.aboveBottom(0),YOffset.aboveBottom(3)), BEDROCK),
                 MaterialRules.condition(MaterialRules.verticalGradient
                        ("snow_forest_bedrock", YOffset.aboveBottom(3),YOffset.aboveBottom(6)), MAGMA_BLOCK),
                MaterialRules.condition(MaterialRules.verticalGradient
                        ("snow_forest_bedrock", YOffset.aboveBottom(5),YOffset.aboveBottom(10)), LAVA),



                MaterialRules.condition(MaterialRules.biome(ModBiomes.SNOW_FOREST), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, SNOW_BLOCK)),
                MaterialRules.condition(MaterialRules.biome(ModBiomes.SNOW_FOREST), PACKED_ICE)
        );


    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
