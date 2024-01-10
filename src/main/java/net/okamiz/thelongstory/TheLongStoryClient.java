package net.okamiz.thelongstory;

import net.fabricmc.api.ClientModInitializer;
import net.okamiz.thelongstory.datagen.EntityRendererGen;
import net.okamiz.thelongstory.datagen.RenderCutout;

public class TheLongStoryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        RenderCutout.registerBlockRenders();

        EntityRendererGen.registerEntityRenderer();

    }
}
