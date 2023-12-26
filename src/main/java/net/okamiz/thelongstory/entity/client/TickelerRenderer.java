package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.entity.custom.TickelerEntity;
import net.okamiz.thelongstory.TheLongStory;

public class TickelerRenderer extends MobEntityRenderer<TickelerEntity, TickelerModel<TickelerEntity>> {
    private static final Identifier TEXTURE = new Identifier(TheLongStory.MOD_ID, "textures/entity/tickeler.png");

    public TickelerRenderer(EntityRendererFactory.Context context) {
        super(context, new TickelerModel(context.getPart(ModModelLayers.TICKELER)), 0.6f);

    }

    @Override
    public Identifier getTexture(TickelerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TickelerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
