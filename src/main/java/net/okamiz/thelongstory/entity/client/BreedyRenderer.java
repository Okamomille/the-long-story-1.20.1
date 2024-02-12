package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.custom.BreedyEntity;

public class BreedyRenderer extends MobEntityRenderer<BreedyEntity, BreedyModel<BreedyEntity>> {

    private static final Identifier TEXTURE = new Identifier(TheLongStory.MOD_ID, "textures/entity/breedy.png");

    public BreedyRenderer(EntityRendererFactory.Context context) {
        super(context, new BreedyModel<>(context.getPart(ModModelLayers.BREEDY)), 0.6f);
        this.shadowRadius = 0.25f;
    }

    @Override
    public Identifier getTexture(BreedyEntity entity) {
        return TEXTURE;
    }



    @Override
    public void render(BreedyEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
            }else{
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
