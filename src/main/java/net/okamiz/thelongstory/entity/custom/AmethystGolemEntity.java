package net.okamiz.thelongstory.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.okamiz.thelongstory.entity.ai.AmethystGolemAttackGoal;
import net.okamiz.thelongstory.entity.ai.TrepasseurAttackGoal;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class AmethystGolemEntity extends SpellcastingIllagerEntity {
    private PlayerEntity player;
    private Boolean setAttacking;

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(AmethystGolemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public int idleAnimationCooldown = 0;
    public int attackAnimationCooldown = 0;


    private final ServerBossBar bossBar = new ServerBossBar(Text.translatable("bossbar.thelongstory.amethyst_golem"),
            BossBar.Color.PURPLE, BossBar.Style.NOTCHED_6);



    public AmethystGolemEntity(EntityType<? extends AmethystGolemEntity> entityType, World world) {
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
    protected SoundEvent getCastSpellSound() {
        return SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL;
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, false));
        this.goalSelector.add(2, new AmethystGolemAttackGoal(this, 1.2D, true));
        this.goalSelector.add(4, new SummonVexGoal());

        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));


    }



    class SummonVexGoal
            extends AmethystGolemEntity.CastSpellGoal {
        private final TargetPredicate closeVexPredicate;

        SummonVexGoal() {
            this.closeVexPredicate = TargetPredicate.createNonAttackable().setBaseMaxDistance(16.0).ignoreVisibility().ignoreDistanceScalingFactor();
        }

        @Override
        public boolean canStart() {
            if (!super.canStart()) {
                return false;
            }
            int i = AmethystGolemEntity.this.getWorld().getTargets(VexEntity.class, this.closeVexPredicate, AmethystGolemEntity.this, AmethystGolemEntity.this.getBoundingBox().expand(16.0)).size();
            return AmethystGolemEntity.this.random.nextInt(8) + 1 > i;
        }

        @Override
        protected int getSpellTicks() {
            return 100;
        }

        @Override
        protected int startTimeDelay() {
            return 340;
        }

        @Override
        protected void castSpell() {
            ServerWorld serverWorld = (ServerWorld)AmethystGolemEntity.this.getWorld();
            for (int i = 0; i < 2; ++i) {
                BlockPos blockPos = AmethystGolemEntity.this.getBlockPos().add(-2 + AmethystGolemEntity.this.random.nextInt(5), 1, -2 + AmethystGolemEntity.this.random.nextInt(5));
                VexEntity vexEntity = EntityType.VEX.create(AmethystGolemEntity.this.getWorld());
                if (vexEntity == null) continue;
                vexEntity.refreshPositionAndAngles(blockPos, 0.0f, 0.0f);
                vexEntity.initialize(serverWorld, AmethystGolemEntity.this.getWorld().getLocalDifficulty(blockPos), SpawnReason.MOB_SUMMONED, null, null);
                vexEntity.setOwner(AmethystGolemEntity.this);
                vexEntity.setBounds(blockPos);
                vexEntity.setLifeTicks(20 * (20 + AmethystGolemEntity.this.random.nextInt(90)));
                serverWorld.spawnEntityAndPassengers(vexEntity);
            }
        }

        @Override
        protected SoundEvent getSoundPrepare() {
            return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON;
        }

        @Override
        protected AmethystGolemEntity.Spell getSpell() {
            return AmethystGolemEntity.Spell.SUMMON_VEX;
        }
    }





    @Override
    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);
        ItemEntity itemEntity = this.dropItem(ModItems.AMETHYST_CORE);
        if (itemEntity != null) {
            itemEntity.setCovetedItem();
        }
    }


    @Override
    public boolean isUndead() {
        return false;
    }

    public static DefaultAttributeContainer.Builder createAmethystGolemAttributes(){
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 90.0f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25f)
                .add(EntityAttributes.GENERIC_ARMOR, 2.2f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 100f);
    }



    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    @Override
    public void addBonusForWave(int wave, boolean unused) {

    }

    @Override
    public SoundEvent getCelebratingSound() {
        return ModSounds.AMETHYST_GOLEM_AMBIENT;
    }

    @Override
    public boolean canJoinRaid() {
        return false;
    }

    @Override
    public boolean isPatrolLeader() {
        return false;
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 4.25F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.AMETHYST_GOLEM_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.AMETHYST_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.AMETHYST_GOLEM_DEATH;
    }



    // BOSS BAR


    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }
}
