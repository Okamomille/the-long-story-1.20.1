package net.okamiz.thelongstory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.okamiz.thelongstory.datagen.EntityRendererGen;
import net.okamiz.thelongstory.datagen.RenderCutout;
import net.okamiz.thelongstory.particles.ModParticles;
import net.okamiz.thelongstory.particles.TSLParticles.EgroricLeavesParticle;
import net.okamiz.thelongstory.particles.TSLParticles.KiwiLeavesParticle;
import net.okamiz.thelongstory.screen.ModScreenHandlers;

public class TheLongStoryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        RenderCutout.registerBlockRenders();

        EntityRendererGen.registerEntityRenderer();


        ParticleFactoryRegistry.getInstance().register(ModParticles.EGRORIC_LEAVES_PARTICLE, EgroricLeavesParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.EGRORIC_LEAVES_PARTICLE, KiwiLeavesParticle.Factory::new);



        //HandledScreens.register(ModScreenHandlers.GREFFED_COMMAND_SYSTEM_SCREEN_HANDLER, GreffedCommandSystemScreen::new);
    }
}
