package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.custom.CrawlerEntity;

public class CrawlerRenderer extends MobEntityRenderer<CrawlerEntity, CrawlerModel<CrawlerEntity>> {
    private static final Identifier TEXTURE = new Identifier(TheLongStory.MOD_ID, "textures/entity/crawler.png");

    public CrawlerRenderer(EntityRendererFactory.Context context) {
        super(context, new CrawlerModel(context.getPart(ModModelLayers.CRAWLER)), 0.6f);

    }

    @Override
    public Identifier getTexture(CrawlerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CrawlerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
