package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.entity.custom.TrepasseurEntity;
import net.okamiz.thelongstory.TheLongStory;

public class TrepasseurRenderer extends MobEntityRenderer<TrepasseurEntity, TrepasseurModel<TrepasseurEntity>> {
    private static final Identifier TEXTURE = new Identifier(TheLongStory.MOD_ID, "textures/entity/trepasseur.png");

    public TrepasseurRenderer(EntityRendererFactory.Context context) {
        super(context, new TrepasseurModel<>(context.getPart(ModModelLayers.TREPASSEUR)), 0.6f);
    }

    @Override
    public Identifier getTexture(TrepasseurEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TrepasseurEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
