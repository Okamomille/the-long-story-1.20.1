package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.custom.AmethystGolemEntity;

public class AmethystGolemRenderer extends MobEntityRenderer<AmethystGolemEntity, AmethystGolemModel<AmethystGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(TheLongStory.MOD_ID, "textures/entity/amethyst_golem.png");

    public AmethystGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new AmethystGolemModel(context.getPart(ModModelLayers.AMETHYST_GOLEM)), 0.6f);

    }

    @Override
    public Identifier getTexture(AmethystGolemEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AmethystGolemEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
