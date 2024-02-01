package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.okamiz.thelongstory.entity.animation.ModAnimations;
import net.okamiz.thelongstory.entity.custom.TookiEntity;

public class TookiModel<T extends TookiEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;
	private final ModelPart head;
	public TookiModel(ModelPart root) {
		this.base = root.getChild("base");
		this.head = root.getChild("base").getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = base.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.5F, -4.5F, 6.0F, 5.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.5F, -0.5F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 14).cuboid(-1.0F, -1.0F, 0.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5F, 4.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(18, 14).cuboid(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(21, 5).cuboid(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 3).cuboid(-3.0F, -5.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(1.0F, -5.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, -3.5F));

		ModelPartData leg_front_left = base.addChild("leg_front_left", ModelPartBuilder.create().uv(11, 14).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -2.0F, -3.5F));

		ModelPartData leg_front_right = base.addChild("leg_front_right", ModelPartBuilder.create().uv(5, 5).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -2.0F, -3.5F));

		ModelPartData leg_back_left = base.addChild("leg_back_left", ModelPartBuilder.create().uv(0, 14).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -2.0F, 2.5F));

		ModelPartData leg_back_right = base.addChild("leg_back_right", ModelPartBuilder.create().uv(0, 6).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -2.0F, 2.5F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(TookiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.TOOKI_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.TOOKI_IDLE, ageInTicks, 1f);

	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
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