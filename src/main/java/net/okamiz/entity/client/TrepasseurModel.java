package net.okamiz.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.okamiz.entity.animation.ModAnimations;
import net.okamiz.entity.custom.TrepasseurEntity;

public class TrepasseurModel<T extends TrepasseurEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;
	private final ModelPart head;

	public TrepasseurModel(ModelPart root) {
		this.base = root.getChild("base");
		this.head = base.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = base.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -5.0F, 8.0F, 9.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData headwear = head.addChild("headwear", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -10.0F, 0.0F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -10.0F, 0.0F));

		ModelPartData left_leg = base.addChild("left_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));

		ModelPartData right_leg = base.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));
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

		this.animateMovement(ModAnimations.TREPASSEUR_WALK,limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.TREPASSEUR_IDLE, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headYaw, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

}