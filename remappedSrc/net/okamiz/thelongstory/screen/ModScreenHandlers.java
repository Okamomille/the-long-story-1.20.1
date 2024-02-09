package net.okamiz.thelongstory.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;

public class ModScreenHandlers {
    public static final ScreenHandlerType<MaterialProcessorScreenHandler> MATERIAL_PROCESSOR_SCREEN_HANDLER =
          Registry.register(Registries.SCREEN_HANDLER, new Identifier(TheLongStory.MOD_ID, "material_processor_screen_handler"),
                   new ExtendedScreenHandlerType<>(MaterialProcessorScreenHandler::new));

    public static void registerScreenHandlers() {
        TheLongStory.LOGGER.info("Registering Screen Handlers for " + TheLongStory.MOD_ID);


    }
}
