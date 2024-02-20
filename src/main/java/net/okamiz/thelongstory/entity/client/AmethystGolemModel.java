package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.okamiz.thelongstory.entity.animation.ModAnimations;
import net.okamiz.thelongstory.entity.custom.AmethystGolemEntity;
import net.okamiz.thelongstory.entity.custom.TrepasseurEntity;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AmethystGolemModel<T extends AmethystGolemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;
	private final ModelPart head;
	public AmethystGolemModel(ModelPart root) {
		this.base = root.getChild("base");
		this.head = this.base.getChild("body").getChild("up_body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = base.addChild("body", ModelPartBuilder.create().uv(51, 46).cuboid(-7.0F, -14.0F, -3.0F, 14.0F, 14.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -31.0F, 0.0F));

		ModelPartData up_body = body.addChild("up_body", ModelPartBuilder.create().uv(0, 0).cuboid(-10.0F, -20.0F, -4.0F, 20.0F, 20.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData head = up_body.addChild("head", ModelPartBuilder.create().uv(0, 29).cuboid(-8.0F, -11.0F, -6.0F, 16.0F, 11.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -20.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(59, 16).cuboid(17.0F, -81.0F, -1.0F, 16.0F, 16.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 63.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(25, 68).cuboid(-28.0F, 8.0F, -2.0F, 15.0F, 15.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(35.0F, -9.0F, 1.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData right_arm = up_body.addChild("right_arm", ModelPartBuilder.create().uv(0, 53).cuboid(-3.0F, -1.0F, -1.0F, 3.0F, 48.0F, 3.0F, new Dilation(0.0F))
		.uv(81, 68).cuboid(-8.0F, 26.0F, 0.0F, 7.0F, 16.0F, 0.0F, new Dilation(0.0F))
		.uv(60, 0).cuboid(-14.0F, -7.0F, 0.0F, 16.0F, 16.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, -19.0F, 0.0F));

		ModelPartData left_arm = up_body.addChild("left_arm", ModelPartBuilder.create().uv(12, 53).cuboid(0.0F, -1.0F, -2.0F, 3.0F, 48.0F, 3.0F, new Dilation(0.0F))
		.uv(24, 84).cuboid(2.0F, 1.0F, 0.0F, 7.0F, 16.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(10.0F, -19.0F, 1.0F));

		ModelPartData left_leg = base.addChild("left_leg", ModelPartBuilder.create().uv(56, 67).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 32.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -31.0F, 0.0F));

		ModelPartData right_leg = base.addChild("right_leg", ModelPartBuilder.create().uv(68, 67).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 32.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -31.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return base;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw,headPitch);

		this.animateMovement(ModAnimations.AMETHYST_GOLEM_WALK,limbAngle, limbDistance, 2f, 2.5f);

		this.updateAnimation(entity.idleAnimationState, ModAnimations.AMETHYST_GOLEM_IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.AMETHYST_GOLEM_ATTACK, animationProgress,1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headYaw, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
}