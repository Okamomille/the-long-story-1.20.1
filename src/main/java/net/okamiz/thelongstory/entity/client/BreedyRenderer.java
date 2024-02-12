package net.okamiz.thelongstory.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.custom.BreedyEntity;
import net.okamiz.thelongstory.entity.variant.BreedyVariant;

import java.util.Map;

public class BreedyRenderer extends MobEntityRenderer<BreedyEntity, BreedyModel<BreedyEntity>> {


    private static final Map<BreedyVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(BreedyVariant.class), map ->{
                map.put(BreedyVariant.DEFAULT,
                        new Identifier(TheLongStory.MOD_ID, "textures/entity/breedy.png"));
                map.put(BreedyVariant.PINK,
                        new Identifier(TheLongStory.MOD_ID, "textures/entity/breedy_pink.png"));
                map.put(BreedyVariant.BLUE,
                        new Identifier(TheLongStory.MOD_ID, "textures/entity/breedy_blue.png"));
                map.put(BreedyVariant.GREEN,
                        new Identifier(TheLongStory.MOD_ID, "textures/entity/breedy_green.png"));
    });

    public BreedyRenderer(EntityRendererFactory.Context context) {
        super(context, new BreedyModel<>(context.getPart(ModModelLayers.BREEDY)), 0.6f);
        this.shadowRadius = 0.25f;
    }

    @Override
    public Identifier getTexture(BreedyEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
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
