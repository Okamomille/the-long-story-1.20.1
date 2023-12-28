package net.okamiz.thelongstory.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.mixin.TrunkPlacerTypeInvoker;
import net.okamiz.thelongstory.world.tree.custom.EgroricTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> EGRORIC_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("egroric_trunk_placer", EgroricTrunkPlacer.CODEC);


    public static void register(){
        TheLongStory.LOGGER.info("Registering Trunk Placers for " + TheLongStory.MOD_ID);
    }

}
