package net.okamiz.thelongstory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.okamiz.thelongstory.datagen.EntityRendererGen;
import net.okamiz.thelongstory.datagen.RenderCutout;
import net.okamiz.thelongstory.particles.ModParticles;
import net.okamiz.thelongstory.particles.TSLParticles.EgroricLeavesParticle;
import net.okamiz.thelongstory.particles.TSLParticles.KiwiLeavesParticle;
import net.okamiz.thelongstory.screen.AmethystProcessorScreen;
import net.okamiz.thelongstory.screen.ModScreenHandlers;
import net.okamiz.thelongstory.screen.MaterialProcessorScreen;
import net.okamiz.thelongstory.screen.RedCoalGeneratorScreen;
import net.okamiz.thelongstory.util.ModModelPredicateProvider;

public class TheLongStoryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        RenderCutout.registerBlockRenders();

        EntityRendererGen.registerEntityRenderer();

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.EGRORIC_LEAVES_PARTICLE, EgroricLeavesParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.EGRORIC_LEAVES_PARTICLE, KiwiLeavesParticle.Factory::new);



        HandledScreens.register(ModScreenHandlers.MATERIAL_PROCESSOR_SCREEN_HANDLER, MaterialProcessorScreen::new);
        HandledScreens.register(ModScreenHandlers.RED_COAL_GENERATOR_SCREEN_HANDLER, RedCoalGeneratorScreen::new);
        HandledScreens.register(ModScreenHandlers.AMETHYST_PROCESSOR_SCREEN_HANDLER, AmethystProcessorScreen::new);
    }
}
