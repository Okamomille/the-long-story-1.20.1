package net.okamiz.thelongstory.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.custom.AmethystGolemEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MobCapsuleItem extends Item {
    private EntityType entityType;

    public MobCapsuleItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        World world = user.getWorld();
        Identifier entityId = EntityType.getId(entity.getType());
        var entityNbt = entity.writeNbt(new NbtCompound());

        if (!world.isClient) {

            if (entity instanceof PlayerEntity) {
                user.sendMessage(Text.literal("Entity Not Compatible"), false);
            }
            if (entity instanceof WitherEntity || entity instanceof WardenEntity || entity instanceof GolemEntity || entity instanceof EnderDragonEntity
                    || entity instanceof AmethystGolemEntity) {
                user.sendMessage(Text.literal("Entity is too big"), false);
            }

            else {

                NbtCompound toolNbt = user.getMainHandStack().getOrCreateNbt();
                toolNbt.putString("entityId", entityId.toString());
                toolNbt.put("entityNbt", entity.writeNbt(entityNbt));

                entity.discard();
            }
        }

        return super.useOnEntity(stack, user, entity, hand);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        if (stack.hasNbt()) {
            String entityId = stack.getNbt().getString("entityId");
            entityType = EntityType.get(entityId).orElse(null);

            if(entityType != null){
                tooltip.add(Text.literal("Contains: " + entityType));
            }
            else{
                tooltip.add(Text.translatable("tooltip.thelongstory.mob_capsule"));
            }

        }

        else {
            tooltip.add(Text.translatable("tooltip.thelongstory.mob_capsule"));
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        BlockPos positionClicked = context.getBlockPos().up();

        if (context.getStack().hasNbt()) {

            World world = context.getWorld();
            NbtCompound nbt = context.getStack().getSubNbt("entityNbt");
            String entityId = context.getStack().getNbt().getString("entityId");


            entityType = EntityType.get(entityId).orElse(null);

            if (entityType != null)  {

                Entity entity = entityType.create(world);
                entity.readNbt(nbt);

                entity.setPos(positionClicked.getX(), positionClicked.getY(), positionClicked.getZ());
                world.spawnEntity(entity);

                world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, positionClicked);

                entityType = null;
                context.getStack().getNbt().remove("entityId");
                context.getStack().getNbt().remove("entityNbt");
                hasGlint(context.getStack());

            }

        }

        return super.useOnBlock(context);
    }


    @Override
    public boolean hasGlint(ItemStack stack) {
        if (stack.hasNbt()) {
            String entityId = stack.getNbt().getString("entityId");
            entityType = EntityType.get(entityId).orElse(null);

            if(entityType != null){
                return true;
            }
            else{
                return false;
            }

        }

        else {
            return false;
        }
    }
}
