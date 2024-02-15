package net.okamiz.thelongstory.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.okamiz.thelongstory.world.ModPlacedFeatures;
import net.okamiz.thelongstory.world.biome.ModBiomes;

public class ModOreGeneration {

    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.THESTONE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.IMPURE_ZAROSITE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.SNOW_FOREST),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.DEEP_ICE_ZAROSITE_ORE_PLACED_KEY);
    }
}
