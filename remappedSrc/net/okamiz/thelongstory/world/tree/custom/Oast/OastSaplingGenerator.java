package net.okamiz.thelongstory.world.tree.custom.Oast;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.okamiz.thelongstory.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class OastSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.OAST_KEY;
    }
}
