package net.okamiz.thelongstory.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.okamiz.thelongstory.block.entity.ModBlockEntities;
import net.okamiz.thelongstory.block.entity.custom.MaterialProcessorBlockEntity;
import org.jetbrains.annotations.Nullable;

public class MaterialProcessorBlock extends BlockWithEntity {

        public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
        private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);

    public MaterialProcessorBlock(Settings settings) {
            super(settings);
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return SHAPE;
        }

        @Nullable
        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(FACING);
        }


        @Nullable
        @Override
        public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
            return new MaterialProcessorBlockEntity(pos, state);
        }

        @Override
        public BlockRenderType getRenderType(BlockState state) {
            return BlockRenderType.MODEL;
        }

        @Override
        public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
            if (state.getBlock() != newState.getBlock()) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof MaterialProcessorBlockEntity) {
                    ItemScatterer.spawn(world, pos, (MaterialProcessorBlockEntity)blockEntity);
                    world.updateComparators(pos,this);
                }
                super.onStateReplaced(state, world, pos, newState, moved);
            }
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (!world.isClient) {
                NamedScreenHandlerFactory screenHandlerFactory = ((MaterialProcessorBlockEntity) world.getBlockEntity(pos));

                if (screenHandlerFactory != null) {
                    player.openHandledScreen(screenHandlerFactory);
                }
            }

            return ActionResult.SUCCESS;
        }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.MATERIAL_PROCESSOR_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
