package net.okamiz.thelongstory.block.custom.greffed_command_blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.okamiz.thelongstory.block.entity.ModBlockEntities;
import net.okamiz.thelongstory.block.entity.custom.GreffedCommandSystemBlockEntity;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.item.custom.SoulContainerFullItem;
import net.okamiz.thelongstory.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class GreffedCommandSystemBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final IntProperty ON = IntProperty.of("power", 0, 6);

    private static final VoxelShape SHAPE = Block.createCuboidShape(0,0,0,16,16, 16);
    public GreffedCommandSystemBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(ON, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ON);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GreffedCommandSystemBlockEntity(pos, state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GreffedCommandSystemBlockEntity) {
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GreffedCommandSystemBlockEntity) {

                GreffedCommandSystemBlockEntity greffedCommandSystemBlockEntity = (GreffedCommandSystemBlockEntity) blockEntity;

                if(!((GreffedCommandSystemBlockEntity) blockEntity).isActive){


                    Item mainHand = player.getMainHandStack().getItem();

                    if (mainHand == ModItems.SOUL_CONTAINER_NIGHT_VISION){world.setBlockState(pos, state.with(ON, 6));}
                    else if (mainHand == ModItems.SOUL_CONTAINER_RESISTANCE){world.setBlockState(pos, state.with(ON, 1));}
                    else if (mainHand == ModItems.SOUL_CONTAINER_FIRE_RESISTANCE){world.setBlockState(pos, state.with(ON, 5));}
                    else if (mainHand == ModItems.SOUL_CONTAINER_JUMP_BOOST){world.setBlockState(pos, state.with(ON, 3));}
                    else if (mainHand == ModItems.SOUL_CONTAINER_DOLPHIN_GRACE){world.setBlockState(pos, state.with(ON, 4));}
                    else if (mainHand == ModItems.SOUL_CONTAINER_REGENERATION){world.setBlockState(pos, state.with(ON, 2));}
                        else{
                        this.setDefaultState(this.getDefaultState().with(ON, ((GreffedCommandSystemBlockEntity) blockEntity).getCustomState()));
                        }
                }
                greffedCommandSystemBlockEntity.state = this.getDefaultState().get(ON);
                greffedCommandSystemBlockEntity.useBlock(world, pos, state, player, hand); // Calling the useBlock method

            }
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.GREFFED_COMMAND_SYSTEM_BLOCK_ENTITY_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }



}
