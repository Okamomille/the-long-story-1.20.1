package net.okamiz.thelongstory.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.okamiz.thelongstory.world.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class EgroricTrunkPlacer extends TrunkPlacer {
    public static final Codec<EgroricTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, EgroricTrunkPlacer::new));

    public EgroricTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.EGRORIC_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                                 Random random, int height, BlockPos startPos, TreeFeatureConfig config) {

        setToDirt(world,replacer,random,startPos.down(),config);
        int height_ = height + random.nextBetween(firstRandomHeight, firstRandomHeight + 2) + random.nextBetween(secondRandomHeight - 1, secondRandomHeight + 1);

        for(int i = 0; i < height_; i++){
            getAndSetState(world, replacer, random, startPos.up(i), config);


            for(int x = 1; x <= 1; x++){
                int distance = 14;
                replacer.accept(startPos.up(height_-distance).offset(Direction.NORTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.SOUTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.EAST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.WEST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
            }

            for(int x = 1; x <= 2; x++){
                int distance = 11;
                replacer.accept(startPos.up(height_-distance).offset(Direction.NORTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.SOUTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.EAST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.WEST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
            }

            for(int x = 1; x <= 2; x++){
                int distance = 8;
                replacer.accept(startPos.up(height_-distance).offset(Direction.NORTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.SOUTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.EAST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.WEST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
            }

            for(int x = 1; x <= 1; x++){
                int distance = 5;
                replacer.accept(startPos.up(height_-distance).offset(Direction.NORTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.SOUTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.EAST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.WEST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.UP, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.UP, x)).with(PillarBlock.AXIS, Direction.Axis.Y)));
            }

            for(int x = 1; x <= 1; x++){
                int distance = 3;
                replacer.accept(startPos.up(height_-distance).offset(Direction.NORTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.SOUTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.EAST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                replacer.accept(startPos.up(height_-distance).offset(Direction.WEST, x), (BlockState) Function.identity().apply(config.trunkProvider
                        .get(random, startPos.up(height_-distance).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
            }







            /*
            if(i % 2 == 0 && random.nextBoolean()){
                if(random.nextFloat() > 0.25f){
                    for(int x = 1; x <= 3; x++){
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }

                if(random.nextFloat() > 0.25f){
                    for(int x = 1; x <= 3; x++){
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }

                if(random.nextFloat() > 0.25f){
                    for(int x = 1; x <= 3; x++){
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                }

                if(random.nextFloat() > 0.25f){
                    for(int x = 1; x <= 3; x++){
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }
            */

        }




        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height_), 0, false));
    }
}
