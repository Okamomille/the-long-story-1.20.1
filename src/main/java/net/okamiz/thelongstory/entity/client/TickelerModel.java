package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.okamiz.thelongstory.entity.animation.ModAnimations;
import net.okamiz.thelongstory.entity.custom.TickelerEntity;

// Made with Blockbench 4.9.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class TickelerModel<T extends TickelerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;
	private final ModelPart head;
	private PlayerEntity player;

	public TickelerModel(ModelPart root) {
		this.base = root.getChild("base");
		this.head = base.getChild("down_body").getChild("up_body").getChild("Head1");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData right_leg = base.addChild("right_leg", ModelPartBuilder.create().uv(28, 26).cuboid(-2.1F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

		ModelPartData left_leg = base.addChild("left_leg", ModelPartBuilder.create().uv(0, 30).cuboid(-1.9F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));

		ModelPartData down_body = base.addChild("down_body", ModelPartBuilder.create().uv(24, 0).cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData up_body = down_body.addChild("up_body", ModelPartBuilder.create().uv(0, 16).cuboid(-5.0F, -7.0F, -3.0F, 10.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

		ModelPartData left_arm = up_body.addChild("left_arm", ModelPartBuilder.create().uv(40, 40).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		ModelPartData right_arm = up_body.addChild("right_arm", ModelPartBuilder.create().uv(16, 40).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		ModelPartData Head1 = up_body.addChild("Head1", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -6.0F, 0.0F));

		ModelPartData head_r1 = Head1.addChild("head_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -4.0F, -1.0F, 0.1745F, 0.0F, -0.2618F));

		ModelPartData Head2 = up_body.addChild("Head2", ModelPartBuilder.create(), ModelTransform.of(3.0F, -6.0F, -1.0F, 0.0F, 0.0F, 0.0873F));

		ModelPartData head_r2 = Head2.addChild("head_r2", ModelPartBuilder.create().uv(26, 10).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.8854F, -2.6005F, 0.417F, 0.0246F, -0.0746F, 0.2127F));
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

		this.animateMovement(ModAnimations.TICKELER_WALK,limbAngle, limbDistance, 2f, 2.5f);

		this.updateAnimation(entity.idleAnimationState, ModAnimations.TICKELER_IDLE, animationProgress, 1f);
		this.updateAnimation(entity.chaseAnimationState, ModAnimations.TICKELER_CHASE, animationProgress,1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.TICKELER_ATTACK, animationProgress,2f);
	}
}