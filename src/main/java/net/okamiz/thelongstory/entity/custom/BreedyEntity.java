package net.okamiz.thelongstory.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.okamiz.thelongstory.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class BreedyEntity extends AnimalEntity  {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public BreedyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }


    @Override
    protected void initGoals() {
            this.goalSelector.add(5, new BreedyEntity.BreedyMoveControl.FlyRandomlyGoal(this));
            this.goalSelector.add(7, new BreedyEntity.BreedyMoveControl.LookAtTargetGoal(this));
            this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
            this.goalSelector.add(3, new AnimalMateGoal(this, 1.0));
            this.goalSelector.add(4, new TemptGoal(this, 1.2, Ingredient.ofItems(Items.GLOW_BERRIES), false));
            this.goalSelector.add(5, new FollowParentGoal(this, 1.1));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.BREEDY.create(world);
    }


    static class BreedyMoveControl extends MoveControl {
        private final BreedyEntity breedy;
        private int collisionCheckCooldown;

        public BreedyMoveControl(BreedyEntity breedy) {
            super(breedy);
            this.breedy = breedy;
        }

        public void tick() {
            if (this.state == State.MOVE_TO) {
                if (this.collisionCheckCooldown-- <= 0) {
                    this.collisionCheckCooldown += this.breedy.getRandom().nextInt(5) + 2;
                    Vec3d vec3d = new Vec3d(this.targetX - this.breedy.getX(), this.targetY - this.breedy.getY(), this.targetZ - this.breedy.getZ());
                    double d = vec3d.length();
                    vec3d = vec3d.normalize();
                    if (this.willCollide(vec3d, MathHelper.ceil(d))) {
                        this.breedy.setVelocity(this.breedy.getVelocity().add(vec3d.multiply(0.1)));
                    } else {
                        this.state = State.WAIT;
                    }
                }

            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.breedy.getBoundingBox();

            for (int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (!this.breedy.getWorld().isSpaceEmpty(this.breedy, box)) {
                    return false;
                }
            }

            return true;
        }

        private static class FlyRandomlyGoal extends Goal {
            private final BreedyEntity breedy;

            public FlyRandomlyGoal(BreedyEntity breedy) {
                this.breedy = breedy;
                this.setControls(EnumSet.of(Control.MOVE));
            }

            public boolean canStart() {
                MoveControl moveControl = this.breedy.getMoveControl();
                if (!moveControl.isMoving()) {
                    return true;
                } else {
                    double d = moveControl.getTargetX() - this.breedy.getX();
                    double e = moveControl.getTargetY() - this.breedy.getY();
                    double f = moveControl.getTargetZ() - this.breedy.getZ();
                    double g = d * d + e * e + f * f;
                    return g < 1.0 || g > 3600.0;
                }
            }

            public boolean shouldContinue() {
                return false;
            }

            public void start() {
                Random random = this.breedy.getRandom();
                double d = this.breedy.getX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                double e = this.breedy.getY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                double f = this.breedy.getZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                this.breedy.getMoveControl().moveTo(d, e, f, 1.0);
            }
        }

        static class LookAtTargetGoal extends Goal {
            private final BreedyEntity breedy;

            public LookAtTargetGoal(BreedyEntity breedy) {
                this.breedy = breedy;
                this.setControls(EnumSet.of(Control.LOOK));
            }

            public boolean canStart() {
                return true;
            }

            public boolean shouldRunEveryTick() {
                return true;
            }

            public void tick() {
                if (this.breedy.getTarget() == null) {
                    Vec3d vec3d = this.breedy.getVelocity();
                    this.breedy.setYaw(-((float) MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776F);
                    this.breedy.bodyYaw = this.breedy.getYaw();
                } else {
                    LivingEntity livingEntity = this.breedy.getTarget();
                    double d = 64.0;
                    if (livingEntity.squaredDistanceTo(this.breedy) < 4096.0) {
                        double e = livingEntity.getX() - this.breedy.getX();
                        double f = livingEntity.getZ() - this.breedy.getZ();
                        this.breedy.setYaw(-((float) MathHelper.atan2(e, f)) * 57.295776F);
                        this.breedy.bodyYaw = this.breedy.getYaw();
                    }
                }

            }
        }


        public static DefaultAttributeContainer.Builder createBreedyAttributes() {
            return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                    .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0);
        }




        public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
            return ModEntities.BREEDY.create(world);
        }



        public boolean isBreedingItem(ItemStack stack) {
            return stack.isOf(Items.POTATO);
        }


        public SoundCategory getSoundCategory() {
            return SoundCategory.HOSTILE;
        }
/*
        protected SoundEvent getAmbientSound() {
            return SoundEvents.ENTITY_BREEDY_AMBIENT;
        }

        protected SoundEvent getHurtSound(DamageSource source) {
            return SoundEvents.ENTITY_BREEDY_HURT;
        }

        protected SoundEvent getDeathSound() {
            return SoundEvents.ENTITY_BREEDY_DEATH;
        }
*/
    }
}
