package net.okamiz.thelongstory.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.gen.GenerationStep;
import net.okamiz.thelongstory.util.ModTags;
import net.okamiz.thelongstory.world.ModPlacedFeatures;
import net.okamiz.thelongstory.world.biome.ModBiomes;

public class ModOreGeneration {

    public static void generateOres(){

        // THESTONE GENERATION -----------------------------------------------------------------------
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.THESTONE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TEARS_VALLEY),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.THESTONE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.GOLDEN_LANDS),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.THESTONE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FOREST_OF_MELODY),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.THESTONE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TORCH_DESERT),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.THESTONE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TORCH_PINK_DESERT),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.THESTONE_ORE_PLACED_KEY);


        // IMPURE ZAROSITE GENERATION -----------------------------------------------------------------------
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.IMPURE_ZAROSITE_ORE_PLACED_KEY);



        // ZAROSITE GENERATION -----------------------------------------------------------------------
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.SNOW_FOREST),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_ICE_ZAROSITE_ORE_PLACED_KEY);



        // PANDAZITE GENERATION -----------------------------------------------------------------------
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TEARS_VALLEY),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PANDAZITE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.GOLDEN_LANDS),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PANDAZITE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FOREST_OF_MELODY),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PANDAZITE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TORCH_DESERT),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PANDAZITE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TORCH_PINK_DESERT),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PANDAZITE_ORE_PLACED_KEY);



        //ODMENTIUM GENERATION -----------------------------------------------------------------------
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TORCH_DESERT),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ODMENTIUM_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TORCH_PINK_DESERT),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ODMENTIUM_ORE_PLACED_KEY);

    }
}
