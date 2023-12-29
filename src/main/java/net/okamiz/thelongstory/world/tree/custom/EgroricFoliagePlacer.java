package net.okamiz.thelongstory.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.okamiz.thelongstory.world.tree.ModFoliagePlacerTypes;

public class EgroricFoliagePlacer extends FoliagePlacer {

/*public static final Codec<EgroricFoliagePlacer> CODEC = RecordCodecBuilder.create(egroricFoliagePlacerInstance ->
        fillFoliagePlacerFields(egroricFoliagePlacerInstance).and(Codec.intRange(0,12).fieldOf("height")
                .forGetter(instance -> instance.height)).apply(egroricFoliagePlacerInstance, EgroricFoliagePlacer::new));
    private final int height;

    public EgroricFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }
*/

    protected final int height;
    protected final IntProvider radius;

    public static final Codec<EgroricFoliagePlacer > CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.intRange(0,16).fieldOf("height").forGetter((foliagePlacer) -> {
                return foliagePlacer.height;
            }), IntProvider.createValidatingCodec(-16, 16).fieldOf("offset").forGetter((foliagePlacer) -> {
                return foliagePlacer.offset;
            }), IntProvider.createValidatingCodec(0, 16).fieldOf("radius").forGetter((foliagePlacer) -> {
                return foliagePlacer.radius;
            })).apply(instance, EgroricFoliagePlacer ::new));

    public EgroricFoliagePlacer (int height, IntProvider offset, IntProvider radius) {
        super(radius, offset);
        this.height = height;
        this.radius = radius;
    }


    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.EGRORIC_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {

        // generateSquare(world, placer, random, config, treeNode.getCenter());
        // radius on how many blocks it extends into x and z direction
        // y how much offset in the y direction from treeNode.getCenter()
        // y if it is dependent on i, also offsets each new layer in the y direction



        /*
        generateSquare(world, placer, random, config, treeNode.getCenter().down(0), 0, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(0), 0, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(1), 1, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(2), 1, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(3), 2, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(4), 2, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(5), 3, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(6), 3, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(7), 3, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(8), 4, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(9), 4, 0, treeNode.isGiantTrunk());

        generateSquare(world, placer, random, config, treeNode.getCenter().down(10), 4, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(11), 4, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(12), 4, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(13), 4, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(14), 3, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(15), 3, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(16), 2, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(17), 1, 0, treeNode.isGiantTrunk());
        */
        generateSquare(world, placer, random, config, treeNode.getCenter().down(0), 0, 2, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(0), 0, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(0), 1, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(1), 1, 0, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().down(2), 1, 0, treeNode.isGiantTrunk());

        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for(int x = -radius; x <= radius; ++x) {
            for(int z = -radius; z <= radius; ++z) {
                for(int y = -height; y <= height; ++y) {
                    // Every block inside your rectangle will be called here!
                    if(isPointInside(x,y,z,radius)){mutable.set(treeNode.getCenter(), x, offset + y, z);
                        placeFoliageBlock(world, placer, random, config, mutable);}

                }
            }
        }

    }


    private boolean isPointInside(int x, int y, int z, int radius) {
        float randomness = -0.25f + (float) (Math.random() * 0.7f);


        float squareRadius = (radius + randomness) * (radius + randomness);
        float squareHeight = (height + randomness) * (height + randomness);
        float deltaX = (float)(x*x) / squareRadius;
        float deltaY = (float)(y*y) / squareHeight;
        float deltaZ = (float)(z*z) / squareRadius;

        return (deltaX + deltaY + deltaZ <= 1);
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx == radius && dz == radius && radius > 0;
    }
}
