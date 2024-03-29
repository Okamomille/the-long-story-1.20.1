package net.okamiz.thelongstory.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.okamiz.thelongstory.TheLongStory;

import java.util.OptionalLong;

public class ModDimensions {

    public static final RegistryKey<DimensionOptions> SIMULATION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(TheLongStory.MOD_ID, "simulation"));
    public static final RegistryKey<World> SIMULATION_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(TheLongStory.MOD_ID, "simulation"));
    public static final RegistryKey<DimensionType> SIMULATION_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(TheLongStory.MOD_ID, "simulation_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(SIMULATION_DIM_TYPE, new DimensionType(
                OptionalLong.of(7000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                16.0, // coordinateScale
                false, // bedWorks
                true, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, true, UniformIntProvider.create(0, 7), 0)));
    }

}
