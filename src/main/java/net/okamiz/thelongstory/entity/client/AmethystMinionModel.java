package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.okamiz.thelongstory.entity.animation.ModAnimations;
import net.okamiz.thelongstory.entity.custom.AmethystMinionEntity;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AmethystMinionModel<T extends AmethystMinionEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;
	private final ModelPart head;
	public AmethystMinionModel(ModelPart root) {
		this.base = root.getChild("base");
		this.head = this.base.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 1.0F, 0.0F));

		ModelPartData body = base.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 11.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(0, 34).cuboid(-3.3F, -7.9F, -1.6F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(0.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -11.0F, 0.0F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-4.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -11.0F, 0.0F));

		ModelPartData left_leg = base.addChild("left_leg", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 11.0F, 0.0F));

		ModelPartData right_leg = base.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 11.0F, 0.0F));
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

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw,headPitch);

		this.animateMovement(ModAnimations.AMETHYST_MINION_WALK,limbAngle, limbDistance, 2f, 2.5f);

		this.updateAnimation(entity.idleAnimationState, ModAnimations.AMETHYST_MINION_IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.AMETHYST_MINION_ATTACK, animationProgress,1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headYaw, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
}