package net.okamiz.thelongstory.world;

import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlantsPlacement {

    public static List<PlacementModifier> modifiers(PlacementModifier countModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count) {
        return modifiers(CountPlacementModifier.of(count));
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance) {
        return modifiers(RarityFilterPlacementModifier.of(chance));
    }
}
