package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.custom.CowsmicEntity;
import org.joml.Vector3f;

public class CowsmicRenderer extends MobEntityRenderer<CowsmicEntity, CowsmicModel<CowsmicEntity>> {

    private static final Identifier TEXTURE = new Identifier(TheLongStory.MOD_ID, "textures/entity/cowsmic.png");

    public CowsmicRenderer(EntityRendererFactory.Context context) {
        super(context, new CowsmicModel<>(context.getPart(ModModelLayers.COWSMIC)), 0.6f);
    }

    @Override
    public Identifier getTexture(CowsmicEntity entity) {
        return TEXTURE;
    }



    @Override
    public void render(CowsmicEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {


        if(mobEntity.isBaby()){
            matrixStack.scale(0.75f,0.75f,0.75f);
            }else{
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
