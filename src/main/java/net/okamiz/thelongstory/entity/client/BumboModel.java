// Made with Blockbench 4.10.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.okamiz.thelongstory.entity.animation.ModAnimations;
import net.okamiz.thelongstory.entity.custom.BumboEntity;
import net.okamiz.thelongstory.entity.custom.TookiEntity;

public class BumboModel<T extends BumboEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;

	public BumboModel(ModelPart root) {
		this.base = root.getChild("base");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 23.0F, 0.0F));

		ModelPartData body = base.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData mouthleft = body.addChild("mouthleft", ModelPartBuilder.create(), ModelTransform.of(1.6F, 0.0F, -1.6F, 0.0F, -0.0436F, 0.0F));

		ModelPartData cube_r1 = mouthleft.addChild("cube_r1", ModelPartBuilder.create().uv(4, 7).cuboid(-3.4823F, 0.0F, -2.6272F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -0.5F, 0.0F, -3.1416F, -1.0036F, 3.1416F));

		ModelPartData mouthright = body.addChild("mouthright", ModelPartBuilder.create(), ModelTransform.of(-0.6F, 0.0F, -1.4F, 0.0F, 0.0873F, 0.0F));

		ModelPartData cube_r2 = mouthright.addChild("cube_r2", ModelPartBuilder.create().uv(0, 7).cuboid(0.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.5F, 0.0F, 0.0F, 0.5236F, 0.0F));

		ModelPartData leg2left = base.addChild("leg2left", ModelPartBuilder.create(), ModelTransform.pivot(2.1F, 0.0F, 0.7F));

		ModelPartData cube_r3 = leg2left.addChild("cube_r3", ModelPartBuilder.create().uv(6, 8).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.9F, -0.4F, 0.5F, 0.0F, 0.0F, -0.6981F));

		ModelPartData leg3left = base.addChild("leg3left", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 0.0F, 2.3F));

		ModelPartData cube_r4 = leg3left.addChild("cube_r4", ModelPartBuilder.create().uv(4, 8).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -0.4F, 0.4F, 0.0F, 0.0F, -0.6981F));

		ModelPartData leg3right = base.addChild("leg3right", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, 2.2F));

		ModelPartData cube_r5 = leg3right.addChild("cube_r5", ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.4F, -0.5F, 3.1416F, 0.0F, -2.4435F));

		ModelPartData left2right = base.addChild("left2right", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, 0.7F));

		ModelPartData cube_r6 = left2right.addChild("cube_r6", ModelPartBuilder.create().uv(0, 8).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.4F, -0.5F, 3.1416F, 0.0F, -2.4435F));

		ModelPartData leg1right = base.addChild("leg1right", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, -1.0F));

		ModelPartData cube_r7 = leg1right.addChild("cube_r7", ModelPartBuilder.create().uv(2, 8).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.4F, -0.5F, 3.1416F, 0.0F, -2.4435F));

		ModelPartData leg1left = base.addChild("leg1left", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, 0.0F, -0.9F));

		ModelPartData cube_r8 = leg1left.addChild("cube_r8", ModelPartBuilder.create().uv(8, 8).cuboid(-1.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.1F, -0.4F, 0.4F, 0.0F, 0.0F, -0.6981F));
		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void setAngles(BumboEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ModAnimations.BUMBO_WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.BUMBO_IDLE, animationProgress, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return base;
	}
}