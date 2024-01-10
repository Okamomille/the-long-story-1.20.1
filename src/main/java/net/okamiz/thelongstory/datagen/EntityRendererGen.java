package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.ModEntities;
import net.okamiz.thelongstory.entity.client.*;

public class EntityRendererGen {

    public static void registerEntityRenderer(){
        TheLongStory.LOGGER.info("Registering EntityRenderer for " + TheLongStory.MOD_ID);

        EntityRendererRegistry.register(ModEntities.TREPASSEUR, TrepasseurRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TREPASSEUR, TrepasseurModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.TICKELER, TickelerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TICKELER, TickelerModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.CRAWLER, CrawlerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRAWLER, CrawlerModel::getTexturedModelData);
    }
}
