package net.okamiz.thelongstory.event;

import net.okamiz.thelongstory.TheLongStory;

public class EventRegister {



    public static void registerEvents(){
        TheLongStory.LOGGER.info("Registering events for " + TheLongStory.MOD_ID);



        ModEvent.EVENT.register(new ModEvent())
        ;
    }
}
