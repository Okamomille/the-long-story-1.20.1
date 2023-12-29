package net.okamiz.thelongstory.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.world.tree.custom.EgroricFoliagePlacer;
import net.okamiz.thelongstory.world.tree.custom.EgroricTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> THESTONE_ORE_KEY = registryKey("thestone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IMPURE_ZAROSITE_ORE_KEY = registryKey("impure_zarosite_ore");


    public static final RegistryKey<ConfiguredFeature<?,?>> EGRORIC_KEY = registryKey("egroric");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreFeatureConfig.Target> overworldThestoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.THESTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_THESTONE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldImpureZarositeOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.IMPURE_ZAROSITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE.getDefaultState()));


        register(context, THESTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldThestoneOres, 4));
        register(context, IMPURE_ZAROSITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldImpureZarositeOres, 4));



        register(context, EGRORIC_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.EGRORIC_LOG),
                new EgroricTrunkPlacer(5,6,4),

                BlockStateProvider.of(ModBlocks.EGRORIC_LEAVES),
                new EgroricFoliagePlacer(9, ConstantIntProvider.create(-9), ConstantIntProvider.create(5)),

                new TwoLayersFeatureSize(1,0,2)).build());
    }


    public static RegistryKey<ConfiguredFeature<?,?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TheLongStory.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
