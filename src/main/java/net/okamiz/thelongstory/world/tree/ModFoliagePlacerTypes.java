package net.okamiz.thelongstory.world.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.mixin.FoliagePlacerTypeInvoker;
import net.okamiz.thelongstory.world.tree.custom.EgroricFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> EGRORIC_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("egroric_foliage_placer", EgroricFoliagePlacer.CODEC);

    public static void register(){
        TheLongStory.LOGGER.info("Registering Foliage Placer for "+ TheLongStory.MOD_ID);
    }
}
