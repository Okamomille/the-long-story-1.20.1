package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THESTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_THESTONE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IMPURE_ZAROSITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IMPURE_ZAROSITE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPIDER_SILK_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_COAL_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GREFFED_COMMAND_SYSTEM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIME_GREFFED_COMMAND_SYSTEM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_GREFFED_COMMAND_SYSTEM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYAN_GREFFED_COMMAND_SYSTEM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_GREFFED_COMMAND_SYSTEM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAY_GREFFED_COMMAND_SYSTEM);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRUSHED_BONES_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEP_ICE);

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
        blockStateModelGenerator.registerTrapdoor(ModBlocks.EGRORIC_TRAPDOOR);


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
        blockStateModelGenerator.registerTrapdoor(ModBlocks.OAST_TRAPDOOR);

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
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SEPHIN_TRAPDOOR);

//--------------------------------------------------------------------------------------


        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.RED_OSPET, ModBlocks.POTTED_RED_OSPET, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BLUE_OSPET, ModBlocks.POTTED_BLUE_OSPET, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GREEN_OSPET, ModBlocks.POTTED_GREEN_OSPET, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.YELLOW_OSPET, ModBlocks.POTTED_YELLOW_OSPET, BlockStateModelGenerator.TintType.NOT_TINTED);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.THESTONE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.THESTONE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.THESTONE_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_IMPURE_ZAROSITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IMPURE_ZAROSITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.GREEN_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.EMERALD_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDSTONE_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RED_COAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.BONE_FRAGMENTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUSHED_BONES, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPIDER_SILK, Models.GENERATED);
        itemModelGenerator.register(ModItems.INFESTED_FLESH, Models.GENERATED);

        itemModelGenerator.register(ModItems.RADAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_REGENERATION, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_FIRE_RESISTANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_JUMP_BOOST, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_DOLPHIN_GRACE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_NIGHT_VISION, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_CONTAINER_RESISTANCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.POWER_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMMAND_SYSTEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.POTION_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_RECEPTACLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.WOODEN_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_PLATE, Models.GENERATED);



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



        itemModelGenerator.register(ModItems.TREPASSEUR_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));

        itemModelGenerator.register(ModItems.TICKELER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));

        itemModelGenerator.register(ModItems.CRAWLER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")),Optional.empty()));


    }
}
