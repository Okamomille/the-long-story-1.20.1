package net.okamiz.thelongstory.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GreffedCommandSystemScreenHandler> GREFFED_COMMAND_SYSTEM_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(TheLongStory.MOD_ID, "greffed_command_system"),
                    new ExtendedScreenHandlerType<>(GreffedCommandSystemScreenHandler::new));

    public static void registerScreenHandlers() {
        TheLongStory.LOGGER.info("Registering Screen Handlers for " + TheLongStory.MOD_ID);
    }
}
