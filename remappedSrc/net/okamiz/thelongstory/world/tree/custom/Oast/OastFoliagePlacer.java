package net.okamiz.thelongstory.world.tree.custom.Oast;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.okamiz.thelongstory.world.tree.ModFoliagePlacerTypes;

public class OastFoliagePlacer extends FoliagePlacer {

 protected final int height;
    protected final IntProvider radius;

    public static final Codec<OastFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.intRange(0,16).fieldOf("height").forGetter((foliagePlacer) -> {
                return foliagePlacer.height;
            }), IntProvider.createValidatingCodec(-16, 16).fieldOf("offset").forGetter((foliagePlacer) -> {
                return foliagePlacer.offset;
            }), IntProvider.createValidatingCodec(0, 16).fieldOf("radius").forGetter((foliagePlacer) -> {
                return foliagePlacer.radius;
            })).apply(instance, OastFoliagePlacer::new));

    public OastFoliagePlacer(int height, IntProvider offset, IntProvider radius) {
        super(radius, offset);
        this.height = height;
        this.radius = radius;
    }


    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.OAST_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {



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
