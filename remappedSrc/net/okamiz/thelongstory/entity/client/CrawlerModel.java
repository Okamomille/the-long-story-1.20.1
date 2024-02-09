package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.okamiz.thelongstory.entity.animation.ModAnimations;
import net.okamiz.thelongstory.entity.custom.CrawlerEntity;

// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class CrawlerModel<T extends CrawlerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;
	private final ModelPart head;

	public CrawlerModel(ModelPart root) {
		this.base = root.getChild("base");
		this.head = base.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 23.0F, 9.0F));

		ModelPartData body = base.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, -9.0F, 1.2654F, 0.0F, 0.0F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(0, 32).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 2.0F, 0.0F, -2.5744F, 0.0F, 0.0F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(24, 16).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, 2.0F, 0.0F, -2.5744F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, -0.7854F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return base;
	}


	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headYaw, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw,headPitch);

		this.animateMovement(ModAnimations.CRAWLER_WALK,limbAngle, limbDistance, 2f, 2.5f);

		this.updateAnimation(entity.idleAnimationState, ModAnimations.CRAWLER_IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.CRAWLER_ATTACK, animationProgress,2f);
	}
}