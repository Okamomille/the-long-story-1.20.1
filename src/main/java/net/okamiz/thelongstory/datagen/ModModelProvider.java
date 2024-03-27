package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_SANDSTONE_THESTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TORCH_STONE_THESTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THESTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_THESTONE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IMPURE_ZAROSITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IMPURE_ZAROSITE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TORCH_STONE_PANDAZITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_SANDSTONE_PANDAZITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PANDAZITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PANDAZITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PANDAZITE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ODMENTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_SANDSTONE_ODMENTIUM_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEP_ICE_ZAROSITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZAROSITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRONIUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPIDER_SILK_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_COAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IMPURE_GLITCHED_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURE_GLITCHED_BLOCK);
        blockStateModelGenerator.registerLog(ModBlocks.DEEPSLATE_PILLAR).log(ModBlocks.DEEPSLATE_PILLAR).wood(ModBlocks.DEEPSLATE_PILLAR_ALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SIMULATION_TELEPORTER);

        blockStateModelGenerator.registerLog(ModBlocks.TORCH_STONE_PILLAR).log(ModBlocks.TORCH_STONE_PILLAR).wood(ModBlocks.TORCH_STONE_PILLAR_ALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TORCH_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TORCH_PINK_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRUSHED_BONES_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEP_ICE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTED_ICE);



        BlockStateModelGenerator.BlockTexturePool fadedCactusPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FADED_CACTUS_PLANKS);
        fadedCactusPool.stairs(ModBlocks.FADED_CACTUS_STAIRS);
        fadedCactusPool.slab(ModBlocks.FADED_CACTUS_SLAB);
        blockStateModelGenerator.registerDoor(ModBlocks.FADED_CACTUS_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.FADED_CACTUS_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool torchBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TORCH_STONE);
        torchBricksPool.stairs(ModBlocks.TORCH_STONE_STAIRS);
        torchBricksPool.slab(ModBlocks.TORCH_STONE_SLAB);
        torchBricksPool.wall(ModBlocks.TORCH_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool torchStoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TORCH_STONE_BRICKS);
        torchStoneBricksPool.stairs(ModBlocks.TORCH_STONE_BRICKS_STAIRS);
        torchStoneBricksPool.slab(ModBlocks.TORCH_STONE_BRICKS_SLAB);
        torchStoneBricksPool.wall(ModBlocks.TORCH_STONE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool torchStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TORCH_BRICKS);
        torchStonePool.stairs(ModBlocks.TORCH_BRICKS_STAIRS);
        torchStonePool.slab(ModBlocks.TORCH_BRICKS_SLAB);
        torchStonePool.wall(ModBlocks.TORCH_BRICKS_WALL);




        BlockStateModelGenerator.BlockTexturePool icedStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ICED_STONE);
        icedStonePool.stairs(ModBlocks.ICED_STONE_STAIRS);
        icedStonePool.slab(ModBlocks.ICED_STONE_SLAB);
        icedStonePool.wall(ModBlocks.ICED_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool icedStoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ICED_STONE_BRICKS);
        icedStoneBricksPool.stairs(ModBlocks.ICED_STONE_BRICKS_STAIRS);
        icedStoneBricksPool.slab(ModBlocks.ICED_STONE_BRICKS_SLAB);
        icedStoneBricksPool.wall(ModBlocks.ICED_STONE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool icedCrackedStoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ICED_CRACKED_STONE_BRICKS);
        icedCrackedStoneBricksPool.stairs(ModBlocks.ICED_CRACKED_STONE_BRICKS_STAIRS);
        icedCrackedStoneBricksPool.slab(ModBlocks.ICED_CRACKED_STONE_BRICKS_SLAB);
        icedCrackedStoneBricksPool.wall(ModBlocks.ICED_CRACKED_STONE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool icedChiseledStoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ICED_CHISELED_STONE_BRICKS);
        icedChiseledStoneBricksPool.stairs(ModBlocks.ICED_CHISELED_STONE_BRICKS_STAIRS);
        icedChiseledStoneBricksPool.slab(ModBlocks.ICED_CHISELED_STONE_BRICKS_SLAB);
        icedChiseledStoneBricksPool.wall(ModBlocks.ICED_CHISELED_STONE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool icedCobblestonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ICED_COBBLESTONE);
        icedCobblestonePool.stairs(ModBlocks.ICED_COBBLESTONE_STAIRS);
        icedCobblestonePool.slab(ModBlocks.ICED_COBBLESTONE_SLAB);
        icedCobblestonePool.wall(ModBlocks.ICED_COBBLESTONE_WALL);

        BlockStateModelGenerator.BlockTexturePool labTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAB_TILES);
        labTilesPool.stairs(ModBlocks.LAB_TILES_STAIRS);
        labTilesPool.slab(ModBlocks.LAB_TILES_SLAB);
        labTilesPool.wall(ModBlocks.LAB_TILES_WALL);

        BlockStateModelGenerator.BlockTexturePool mossyLabTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CORRUPTED_LAB_TILES);
        mossyLabTilesPool.stairs(ModBlocks.CORRUPTED_LAB_TILES_STAIRS);
        mossyLabTilesPool.slab(ModBlocks.CORRUPTED_LAB_TILES_SLAB);
        mossyLabTilesPool.wall(ModBlocks.CORRUPTED_LAB_TILES_WALL);


//--------------------------------------------------------------------------------------



        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROKEN_SIMULATION_TELEPORTER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROKEN_GREFFED_COMMAND_SYSTEM);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LOCKED_AMETHYST_CORE);





//--------------------------------------------------------------------------------------

        //EGRORIC MODELS ------------------------------------
        blockStateModelGenerator.registerLog(ModBlocks.EGRORIC_LOG).log(ModBlocks.EGRORIC_LOG).wood(ModBlocks.EGRORIC_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EGRORIC_LOG).log(ModBlocks.STRIPPED_EGRORIC_LOG).wood(ModBlocks.STRIPPED_EGRORIC_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EGRORIC_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.EGRORIC_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


        BlockStateModelGenerator.BlockTexturePool egroricPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EGRORIC_PLANKS);
        egroricPool.stairs(ModBlocks.EGRORIC_STAIRS);
        egroricPool.slab(ModBlocks.EGRORIC_SLAB);
        egroricPool.button(ModBlocks.EGRORIC_BUTTON);
        egroricPool.pressurePlate(ModBlocks.EGRORIC_PRESSURE_PLATE);
        egroricPool.fence(ModBlocks.EGRORIC_FENCE);
        egroricPool.fenceGate(ModBlocks.EGRORIC_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.EGRORIC_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.EGRORIC_TRAPDOOR);


        //OAST MODELS ------------------------------------
        blockStateModelGenerator.registerLog(ModBlocks.OAST_LOG).log(ModBlocks.OAST_LOG).wood(ModBlocks.OAST_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_OAST_LOG).log(ModBlocks.STRIPPED_OAST_LOG).wood(ModBlocks.STRIPPED_OAST_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OAST_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.OAST_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool oastPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OAST_PLANKS);
        oastPool.stairs(ModBlocks.OAST_STAIRS);
        oastPool.slab(ModBlocks.OAST_SLAB);
        oastPool.button(ModBlocks.OAST_BUTTON);
        oastPool.pressurePlate(ModBlocks.OAST_PRESSURE_PLATE);
        oastPool.fence(ModBlocks.OAST_FENCE);
        oastPool.fenceGate(ModBlocks.OAST_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.OAST_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.OAST_TRAPDOOR);

        //SEPHIN MODELS ------------------------------------
        blockStateModelGenerator.registerLog(ModBlocks.SEPHIN_LOG).log(ModBlocks.SEPHIN_LOG).wood(ModBlocks.SEPHIN_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SEPHIN_LOG).log(ModBlocks.STRIPPED_SEPHIN_LOG).wood(ModBlocks.STRIPPED_SEPHIN_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SEPHIN_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SEPHIN_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool sephinPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SEPHIN_PLANKS);
        sephinPool.stairs(ModBlocks.SEPHIN_STAIRS);
        sephinPool.slab(ModBlocks.SEPHIN_SLAB);
        sephinPool.button(ModBlocks.SEPHIN_BUTTON);
        sephinPool.pressurePlate(ModBlocks.SEPHIN_PRESSURE_PLATE);
        sephinPool.fence(ModBlocks.SEPHIN_FENCE);
        sephinPool.fenceGate(ModBlocks.SEPHIN_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.SEPHIN_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.SEPHIN_TRAPDOOR);

        //KIWI MODELS ------------------------------------
        blockStateModelGenerator.registerLog(ModBlocks.KIWI_LOG).log(ModBlocks.KIWI_LOG).wood(ModBlocks.KIWI_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_KIWI_LOG).log(ModBlocks.STRIPPED_KIWI_LOG).wood(ModBlocks.STRIPPED_KIWI_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KIWI_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.KIWI_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool kiwiPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KIWI_PLANKS);
        kiwiPool.stairs(ModBlocks.KIWI_STAIRS);
        kiwiPool.slab(ModBlocks.KIWI_SLAB);
        kiwiPool.button(ModBlocks.KIWI_BUTTON);
        kiwiPool.pressurePlate(ModBlocks.KIWI_PRESSURE_PLATE);
        kiwiPool.fence(ModBlocks.KIWI_FENCE);
        kiwiPool.fenceGate(ModBlocks.KIWI_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.KIWI_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.KIWI_TRAPDOOR);

//--------------------------------------------------------------------------------------

        blockStateModelGenerator.registerTintableCross(ModBlocks.TORN_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TORN_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.PINK_PHYGELUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.YELLOW_PHYGELUS, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.RED_OSPET, ModBlocks.POTTED_RED_OSPET, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BLUE_OSPET, ModBlocks.POTTED_BLUE_OSPET, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GREEN_OSPET, ModBlocks.POTTED_GREEN_OSPET, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.YELLOW_OSPET, ModBlocks.POTTED_YELLOW_OSPET, BlockStateModelGenerator.TintType.NOT_TINTED);


        //registerGreffedCommandSystem(blockStateModelGenerator);
    }

/*
    private void registerGreffedCommandSystem(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.GREFFED_COMMAND_SYSTEM, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.GREFFED_COMMAND_SYSTEM, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GREFFED_COMMAND_SYSTEM)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(GreffedCommandSystemBlock.ON, identifier2, identifier)));
    }

*/



    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.THESTONE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.THESTONE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.THESTONE_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_IMPURE_ZAROSITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IMPURE_ZAROSITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_PANDAZITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANDAZITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANDAZITE_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CARBON_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_ODMENTIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ODMENTIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ZAROSITE_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZAROSITE_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.GREEN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_AMETHYST_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLAMING_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.FADED_CACTUS_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARBON_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_AMETHYST_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLAMING_STICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMETHYST_KEY, Models.GENERATED);

        itemModelGenerator.register(ModItems.EMERALD_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDSTONE_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BREEDY_FLESH, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOOKI_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_TOOKI_MEAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.RED_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRONIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRONIUM_POWDER, Models.GENERATED);

        itemModelGenerator.register(ModItems.BONE_FRAGMENTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUSHED_BONES, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPIDER_SILK, Models.GENERATED);
        itemModelGenerator.register(ModItems.INFESTED_FLESH, Models.GENERATED);

        itemModelGenerator.register(ModItems.BROKEN_TELEPORTATION_REMOTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TELEPORTATION_REMOTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOB_CAPSULE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_REGENERATION, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_FIRE_RESISTANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_JUMP_BOOST, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_DOLPHIN_GRACE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_NIGHT_VISION, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_RESISTANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_SLOW_FALLING, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_HASTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_SATURATION, Models.GENERATED);

        itemModelGenerator.register(ModItems.POWER_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIMENSION_PATTERN, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMMAND_SYSTEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.POWER_MODULE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TELEPORTATION_MODULE, Models.GENERATED);

        itemModelGenerator.register(ModItems.POTION_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_RECEPTACLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLAMING_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_CORE, Models.GENERATED);

        itemModelGenerator.register(ModItems.WOODEN_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARBON_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_PLATE, Models.GENERATED);



        itemModelGenerator.register(ModItems.THESTONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.THESTONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.THESTONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.THESTONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.THESTONE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.GREEN_SHARD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GREEN_SHARD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GREEN_SHARD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GREEN_SHARD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GREEN_SHARD_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.IMPURE_ZAROSITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IMPURE_ZAROSITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IMPURE_ZAROSITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IMPURE_ZAROSITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IMPURE_ZAROSITE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PANDAZITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PANDAZITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PANDAZITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PANDAZITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PANDAZITE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ODMENTIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ODMENTIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ODMENTIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ODMENTIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ODMENTIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.FADED_CACTUS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FADED_CACTUS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FADED_CACTUS_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FADED_CACTUS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FADED_CACTUS_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ZAROSITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZAROSITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZAROSITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZAROSITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZAROSITE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.DRONIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRONIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRONIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRONIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRONIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PURE_AMETHYST_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PURE_AMETHYST_SWORD, Models.HANDHELD);



        itemModelGenerator.register(ModItems.VITALY_SEEDS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VITALY_FRUIT, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TORN_CARROT, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SWEET_PEAR_SEEDS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SWEET_PEAR, Models.HANDHELD);

        
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.THESTONE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.THESTONE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.THESTONE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.THESTONE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GREEN_SHARD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GREEN_SHARD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GREEN_SHARD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GREEN_SHARD_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IMPURE_ZAROSITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IMPURE_ZAROSITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IMPURE_ZAROSITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IMPURE_ZAROSITE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZAROSITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZAROSITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZAROSITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZAROSITE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DRONIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DRONIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DRONIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.DRONIUM_BOOTS));


        itemModelGenerator.register(ModItems.AMETHYST_MINION_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));

        itemModelGenerator.register(ModItems.TREPASSEUR_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));

        itemModelGenerator.register(ModItems.TICKELER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));

        itemModelGenerator.register(ModItems.CRAWLER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));

        itemModelGenerator.register(ModItems.TOOKI_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));

        itemModelGenerator.register(ModItems.COWSMIC_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));

        itemModelGenerator.register(ModItems.BREEDY_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));



    }
}
