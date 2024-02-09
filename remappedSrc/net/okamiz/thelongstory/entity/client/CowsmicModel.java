package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.okamiz.thelongstory.entity.animation.ModAnimations;
import net.okamiz.thelongstory.entity.custom.CowsmicEntity;

public class CowsmicModel<T extends CowsmicEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;
	private final ModelPart head;

	public CowsmicModel(ModelPart root) {
		this.base = root.getChild("base");
		this.head = root.getChild("base").getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = base.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(22, 0).cuboid(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(22, 0).cuboid(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -20.0F, -8.0F));

		ModelPartData boddy = body.addChild("boddy", ModelPartBuilder.create().uv(18, 4).cuboid(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new Dilation(0.0F))
		.uv(52, 0).cuboid(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData leg4 = base.addChild("leg4", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -12.0F, -6.0F));

		ModelPartData leg3 = base.addChild("leg3", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -12.0F, -6.0F));

		ModelPartData leg2 = base.addChild("leg2", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -12.0F, 7.0F));

		ModelPartData leg1 = base.addChild("leg1", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -12.0F, 7.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}
	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(ModAnimations.COWSMIC_WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.COWSMIC_IDLE, animationProgress, 1f);
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

	public ModelPart getHead() {
		return head;
	}


}