package net.okamiz.thelongstory.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.okamiz.thelongstory.entity.custom.CrawlerEntity;

public class CrawlerAttackGoal extends MeleeAttackGoal {
    private final CrawlerEntity entity;
    private int attackDelay;
    private int ticksUntilNextAttack = 15;
    private boolean shouldCountTillNextAttack = false;

    private PlayerEntity player;

    public CrawlerAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((CrawlerEntity) mob);
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
        return this.entity.distanceTo(pEnemy) <= 2.0f;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);

        }


        /* It means :
        if (this.getTarget() == player){
            setChasing(true);
        }else{
            setChasing(false);
        }
        */

    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}