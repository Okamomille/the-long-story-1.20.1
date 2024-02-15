package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.okamiz.thelongstory.entity.custom.BreedyEntity;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BreedyModel<T extends BreedyEntity> extends SinglePartEntityModel<T> {
	private final ModelPart base;
	private final ModelPart head;
	private final ModelPart wings;

	public BreedyModel(ModelPart root) {
		this.base = root.getChild("base");
		this.head = base.getChild("body").getChild("head");
		this.wings = base.getChild("body").getChild("head").getChild("wings");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 25.0F, 0.0F));

		ModelPartData body = base.addChild("body", ModelPartBuilder.create().uv(12, 14).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Head = body.addChild("head", ModelPartBuilder.create().uv(0, 12).cuboid(-2.0F, -10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Wings = Head.addChild("wings", ModelPartBuilder.create().uv(-16, 27).cuboid(-8.0F, -10.0F, -8.0F, 16.0F, 0.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		//this.animateMovement(ModAnimations.BREEDY_FLY, limbAngle, limbDistance, 2f, 2.5f);
		//this.updateAnimation(entity.idleAnimationState, ModAnimations.BREEDY_IDLE, animationProgress, 1f);
		this.wings.yaw = animationProgress;  // or use .yaw instead of .roll on the model part, depending on what you need
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