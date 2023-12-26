package net.okamiz.thelongstory.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.okamiz.thelongstory.entity.ai.TrepasseurAttackGoal;

public class TrepasseurEntity extends ZombieEntity {

    private PlayerEntity player;

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(TrepasseurEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> CHASING =
            DataTracker.registerData(TrepasseurEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState chaseAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public int idleAnimationCooldown = 0;
    public int chaseAnimationCooldown = 0;
    public int attackAnimationCooldown = 0;


    public TrepasseurEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }


    private void setupAnimationStates() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }

        if(this.isAttacking() && attackAnimationCooldown <= 0) {
            attackAnimationCooldown = 15;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationCooldown;
        }

        if(!this.isAttacking()){
            if(this.isChasing() && chaseAnimationCooldown <= 0) {
                chaseAnimationCooldown = 20;
                chaseAnimationState.start(this.age);
            } else {
                --this.chaseAnimationCooldown;
            }
        }else{
            chaseAnimationState.stop();
        }


        //if(!this.isAttacking()) {
        //    attackAnimationState.stop();
        //}
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
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1,new AvoidSunlightGoal(this));
        this.goalSelector.add(2, new TrepasseurAttackGoal(this, 1D, true));

        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));

        this.goalSelector.add(6, new MoveThroughVillageGoal(this, 1.0, true, 4, this::canBreakDoors));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>((MobEntity)this, PlayerEntity.class, true));
    }



    public static DefaultAttributeContainer.Builder createTrepasseurAttributes(){
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.24f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0f)
                .add(EntityAttributes.GENERIC_ARMOR, 2.2f)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }



    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    public void setChasing(boolean chasing) {
        this.dataTracker.set(CHASING, chasing);
    }


    public boolean isChasing() {
        return this.dataTracker.get(CHASING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(CHASING, false);
    }



    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DROWNED_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_DROWNED_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DROWNED_DEATH;
    }
}
