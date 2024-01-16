package net.okamiz.thelongstory.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


public class TornBrushBlock extends PlantBlock {
    public TornBrushBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape LARGE_SHAPE = Block.createCuboidShape(0.8, 0.0, 0.8, 15.0, 16.0, 15.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LARGE_SHAPE;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getType() == EntityType.FOX || entity.getType() == EntityType.BEE) {
            return;
        }
        entity.slowMovement(state, new Vec3d(0.8f, 0.75, 0.8f));
        if (!(world.isClient || entity.lastRenderX == entity.getX() && entity.lastRenderZ == entity.getZ())) {
            double d = Math.abs(entity.getX() - entity.lastRenderX);
            double e = Math.abs(entity.getZ() - entity.lastRenderZ);
        }
    }


}
