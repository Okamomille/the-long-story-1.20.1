package net.okamiz.thelongstory.particles;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;

public class ModParticles {
    public static final DefaultParticleType EGRORIC_LEAVES_PARTICLE = registerParticle("egroric_leaves_particle", FabricParticleTypes.simple());


    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(TheLongStory.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        TheLongStory.LOGGER.info("Registering Particles for " + TheLongStory.MOD_ID);
    }

}
