package net.okamiz.thelongstory.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;

public class ModSounds {

    public static final SoundEvent TELEPORTATION = registerSoundEvent("teleportation");
    public static final SoundEvent GREFFED_COMMAND_SYSTEM_GIVE_EFFECT = registerSoundEvent("greffed_command_system_give_effect");
    public static final SoundEvent GREFFED_COMMAND_SYSTEM_FAIL = registerSoundEvent("greffed_command_system_fail");
    public static final SoundEvent GREFFED_COMMAND_SYSTEM_ACTIVATE = registerSoundEvent("greffed_command_system_activate");
    public static final SoundEvent TOOKI_IDLE = registerSoundEvent("tooki_idle");
    public static final SoundEvent TOOKI_HURT = registerSoundEvent("tooki_hurt");
    public static final SoundEvent TOOKI_DEATH = registerSoundEvent("tooki_death");






    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(TheLongStory.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        TheLongStory.LOGGER.info("Registering sounds for " + TheLongStory.MOD_ID);
    }
}
