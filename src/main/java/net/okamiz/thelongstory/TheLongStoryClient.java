package net.okamiz.thelongstory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.okamiz.thelongstory.entity.ModEntities;
import net.okamiz.thelongstory.entity.client.*;
import net.okamiz.thelongstory.block.ModBlocks;

public class TheLongStoryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGRORIC_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGRORIC_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_OSPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_RED_OSPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OSPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_BLUE_OSPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_OSPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_GREEN_OSPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_OSPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_YELLOW_OSPET, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.TREPASSEUR, TrepasseurRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TREPASSEUR, TrepasseurModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.TICKELER, TickelerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TICKELER, TickelerModel::getTexturedModelData);
    }
}
