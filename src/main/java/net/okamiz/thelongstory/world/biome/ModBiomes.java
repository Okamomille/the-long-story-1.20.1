package net.okamiz.thelongstory.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.ModEntities;
import net.okamiz.thelongstory.world.ModPlacedFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> SNOW_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheLongStory.MOD_ID, "snow_forest"));

    public static final RegistryKey<Biome> GOLDEN_LANDS = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheLongStory.MOD_ID, "golden_lands"));

    public static final RegistryKey<Biome> TEARS_VALLEY = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheLongStory.MOD_ID, "tears_valley"));

    public static final RegistryKey<Biome> FOREST_OF_MELODY = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheLongStory.MOD_ID, "forest_of_melody"));





    public static void boostrap(Registerable<Biome> context) {
        context.register(SNOW_FOREST, snowForest(context));
        context.register(GOLDEN_LANDS, goldenLands(context));
        context.register(TEARS_VALLEY, tearsValley(context));
        context.register(FOREST_OF_MELODY, forestOfMelody(context));
    }

    /*
    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }
    */


    public static Biome snowForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
       // spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.TREPASSEUR, 80, 1, 4));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 5, 4, 4));

        DefaultBiomeFeatures.addSnowyMobs(spawnBuilder);
        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        //globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SEPHIN_PLACED_KEY);
        //biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, );
        //DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        DefaultBiomeFeatures.addFrozenTopLayer(biomeBuilder);


        //DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.5f)
                .temperature(0f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(3750089)
                        .waterFogColor(329011)
                        .skyColor(13759743)
                        .grassColor(2723393)
                        .foliageColor(2723393)
                        .fogColor(15069183)
                        .build())
                .build();
    }

    public static Biome goldenLands(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        //spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.TICKELER, 80, 1, 4));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ALLAY, 5, 1, 4));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        //globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OAST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINK_PHYGELUS_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_CHERRY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FOREST_FLOWERS);
        //biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, );
        DefaultBiomeFeatures.addForestGrass(biomeBuilder);
        //DefaultBiomeFeatures.addLargeFerns(biomeBuilder);


        //DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.6f)
                .temperature(0.6f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(OverworldBiomeCreator.getSkyColor(0.7f))
                        .grassColor(11983713)
                        .foliageColor(11983713)
                        .fogColor(12638463)
                        .build())
                .build();
    }

    public static Biome tearsValley(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.TOOKI, 10, 1, 3));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        //globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.EGRORIC_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TORN_BUSH_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_OSPET_PLACED_KEY);
        //biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, );
        DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
        DefaultBiomeFeatures.addJungleGrass(biomeBuilder);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);


        //DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(7444166)
                        .grassColor(11826687)
                        .foliageColor(11826687)
                        .fogColor(4940970)
                        .build())
                .build();
    }

    public static Biome forestOfMelody(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        //spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities.TICKELER, 80, 1, 4));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PARROT, 5, 1, 4));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        //globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.KIWI_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YELLOW_PHYGELUS_PLACED_KEY);
        //biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, );
        DefaultBiomeFeatures.addForestGrass(biomeBuilder);
        //DefaultBiomeFeatures.addLargeFerns(biomeBuilder);


        //DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.6f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(OverworldBiomeCreator.getSkyColor(0.7f))
                        .grassColor(11983713)
                        .foliageColor(11983713)
                        .fogColor(12638463)
                        .build())
                .build();
    }




}
