package net.okamiz.thelongstory.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.okamiz.thelongstory.effect.ModEffects;
import net.okamiz.thelongstory.entity.custom.AmethystMinionEntity;

public class AmethystMinionAttackGoal extends MeleeAttackGoal {
    private final AmethystMinionEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 15;
    private boolean shouldCountTillNextAttack = false;

    private PlayerEntity player;

    public AmethystMinionAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((AmethystMinionEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 10;
        ticksUntilNextAttack = 15;
    }

    @Override
    protected void attack(LivingEntity pEnemy, double squaredDistance) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                entity.setAttacking(true);
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }

        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationCooldown = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy){
        return this.entity.distanceTo(pEnemy) <= 3.0f;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
        //pEnemy.addStatusEffect(new StatusEffectInstance(ModEffects.INFECTED, 400, 1));
    }





    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);

        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}