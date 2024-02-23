package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.custom.AmethystMinionEntity;
import net.okamiz.thelongstory.entity.custom.TrepasseurEntity;

public class AmethystMinionRenderer extends MobEntityRenderer<AmethystMinionEntity, AmethystMinionModel<AmethystMinionEntity>> {
    private static final Identifier TEXTURE = new Identifier(TheLongStory.MOD_ID, "textures/entity/amethyst_minion.png");

    public AmethystMinionRenderer(EntityRendererFactory.Context context) {
        super(context, new AmethystMinionModel<>(context.getPart(ModModelLayers.AMETHYST_MINION)), 0.6f);
    }

    @Override
    public Identifier getTexture(AmethystMinionEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AmethystMinionEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
