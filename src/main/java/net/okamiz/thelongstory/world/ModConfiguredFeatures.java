package net.okamiz.thelongstory.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.util.ModTags;
import net.okamiz.thelongstory.world.tree.custom.Egroric.EgroricFoliagePlacer;
import net.okamiz.thelongstory.world.tree.custom.Egroric.EgroricTrunkPlacer;
import net.okamiz.thelongstory.world.tree.custom.Oast.OastFoliagePlacer;
import net.okamiz.thelongstory.world.tree.custom.Oast.OastTrunkPlacer;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> THESTONE_ORE_KEY = registryKey("thestone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IMPURE_ZAROSITE_ORE_KEY = registryKey("impure_zarosite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEP_ICE_ZAROSITE_ORE_KEY = registryKey("deep_ice_zarosite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PANDAZITE_ORE_KEY = registryKey("pandazite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ODMENTIUM_ORE_KEY = registryKey("odmentium_ore");


    public static final RegistryKey<ConfiguredFeature<?,?>> EGRORIC_KEY = registryKey("egroric");
    public static final RegistryKey<ConfiguredFeature<?,?>> OAST_KEY = registryKey("oast");
    public static final RegistryKey<ConfiguredFeature<?,?>> SEPHIN_KEY = registryKey("sephin");
    public static final RegistryKey<ConfiguredFeature<?,?>> KIWI_KEY = registryKey("kiwi");



    public static final RegistryKey<ConfiguredFeature<?,?>> TORN_BUSH_KEY = registryKey("torn_bush_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> TORN_FLOWER_KEY = registryKey("torn_flower_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PINK_PHYGELUS_KEY = registryKey("pink_phygelus_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> YELLOW_PHYGELUS_KEY = registryKey("yellow_phygelus_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> BLUE_OSPET_KEY = registryKey("blue_ospet_key");




    public static final RegistryKey<ConfiguredFeature<?,?>> NOTE_BLOCK_PATCH_KEY = registryKey("note_block_patch_key");



    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest deepIceReplacables = new TagMatchRuleTest(ModTags.Blocks.DEEP_ICE_REPLACABLES);
        RuleTest torchStoneReplacables = new TagMatchRuleTest(ModTags.Blocks.TORCH_STONE_REPLACABLES);
        RuleTest redSandstoneReplacables = new TagMatchRuleTest(ModTags.Blocks.RED_SANDSTONE_REPLACABLES);


        List<OreFeatureConfig.Target> overworldThestoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.THESTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_THESTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(redSandstoneReplacables, ModBlocks.RED_SANDSTONE_THESTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(torchStoneReplacables, ModBlocks.TORCH_STONE_THESTONE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldImpureZarositeOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.IMPURE_ZAROSITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> simulationZarositeOre =
                List.of(OreFeatureConfig.createTarget(deepIceReplacables, ModBlocks.DEEP_ICE_ZAROSITE_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> simulationPandaziteOre =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.PANDAZITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_PANDAZITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(torchStoneReplacables, ModBlocks.TORCH_STONE_PANDAZITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(redSandstoneReplacables, ModBlocks.RED_SANDSTONE_PANDAZITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> simulationOdmentiumOre =
                List.of(OreFeatureConfig.createTarget(torchStoneReplacables, ModBlocks.ODMENTIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(redSandstoneReplacables, ModBlocks.RED_SANDSTONE_ODMENTIUM_ORE.getDefaultState()));




        register(context, THESTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldThestoneOres, 5));
        register(context, IMPURE_ZAROSITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldImpureZarositeOres, 4));

        register(context, PANDAZITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(simulationPandaziteOre, 4));


        register(context, ODMENTIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(simulationOdmentiumOre, 6));

        register(context, DEEP_ICE_ZAROSITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(simulationZarositeOre, 4));


        register(context, TORN_BUSH_KEY, Feature.FLOWER, ConfiguredFeatures.createRandomPatchFeatureConfig(10,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TORN_BUSH)))));

        register(context, TORN_FLOWER_KEY, Feature.FLOWER, ConfiguredFeatures.createRandomPatchFeatureConfig(7,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TORN_FLOWER)))));

        register(context, PINK_PHYGELUS_KEY, Feature.FLOWER, ConfiguredFeatures.createRandomPatchFeatureConfig(20,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_PHYGELUS)))));

        register(context, YELLOW_PHYGELUS_KEY, Feature.FLOWER, ConfiguredFeatures.createRandomPatchFeatureConfig(20,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_PHYGELUS)))));

        register(context, BLUE_OSPET_KEY, Feature.FLOWER, ConfiguredFeatures.createRandomPatchFeatureConfig(5,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_OSPET)))));



        register(context, NOTE_BLOCK_PATCH_KEY, Feature.BLOCK_PILE, new BlockPileFeatureConfig(BlockStateProvider.of(Blocks.NOTE_BLOCK)));





        register(context, EGRORIC_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.EGRORIC_LOG),
                new EgroricTrunkPlacer(5,6,4),

                BlockStateProvider.of(ModBlocks.EGRORIC_LEAVES),
                new EgroricFoliagePlacer(9, ConstantIntProvider.create(-9), ConstantIntProvider.create(5)),

                new TwoLayersFeatureSize(1,0,2)).build());

        register(context, OAST_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.OAST_LOG),
                new OastTrunkPlacer(3,4,3),

                BlockStateProvider.of(ModBlocks.OAST_LEAVES),
                new OastFoliagePlacer(5, ConstantIntProvider.create(-4), ConstantIntProvider.create(6)),

                new TwoLayersFeatureSize(1,0,2)).build());

        register(context, SEPHIN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SEPHIN_LOG),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.of(ModBlocks.SEPHIN_LEAVES),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2))
                .dirtProvider(BlockStateProvider.of(Blocks.SNOW_BLOCK)).build());

        register(context, KIWI_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.KIWI_LOG),
                new StraightTrunkPlacer(5, 2, 0),
                BlockStateProvider.of(ModBlocks.KIWI_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

    }


    public static RegistryKey<ConfiguredFeature<?,?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TheLongStory.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
