package net.okamiz.thelongstory;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.okamiz.thelongstory.datagen.EntityRendererGen;
import net.okamiz.thelongstory.datagen.RenderCutout;
import net.okamiz.thelongstory.screen.GreffedCommandSystemScreen;
import net.okamiz.thelongstory.screen.ModScreenHandlers;

public class TheLongStoryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        RenderCutout.registerBlockRenders();

        EntityRendererGen.registerEntityRenderer();


        HandledScreens.register(ModScreenHandlers.GREFFED_COMMAND_SYSTEM_SCREEN_HANDLER, GreffedCommandSystemScreen::new);
    }
}
