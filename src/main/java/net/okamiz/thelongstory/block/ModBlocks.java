package net.okamiz.thelongstory.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.custom.*;
import net.okamiz.thelongstory.block.custom.greffed_command_blocks.*;
import net.okamiz.thelongstory.world.tree.custom.Egroric.EgroricSaplingGenerator;
import net.okamiz.thelongstory.world.tree.custom.Kiwi.KiwiSaplingGenerator;
import net.okamiz.thelongstory.world.tree.custom.Oast.OastSaplingGenerator;
import net.okamiz.thelongstory.world.tree.custom.Sephin.SephinSaplingGenerator;

public class ModBlocks {


    public static final Block CRUSHED_BONES_BLOCK = registerBlock("crushed_bones_block",
            new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)));
    public static final Block MOLD_BLOCK = registerBlock("mold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD)));
    public static final Block SPIDER_SILK_BLOCK = registerBlock("spider_silk_block",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

    public static final Block DEEP_ICE = registerBlock("deep_ice",
            new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(3.0F, 6.0F).sounds(BlockSoundGroup.GLASS)));

    public static final Block THESTONE_ORE = registerBlock("thestone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(3.0f,3.0f), UniformIntProvider.create(1, 5)));

    public static final Block DEEPSLATE_THESTONE_ORE = registerBlock("deepslate_thestone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4.5f,3.0f), UniformIntProvider.create(2, 6)));

    public static final Block IMPURE_ZAROSITE_ORE = registerBlock("impure_zarosite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(3.0f,3.0f), UniformIntProvider.create(2, 4)));

    public static final Block DEEPSLATE_IMPURE_ZAROSITE_ORE = registerBlock("deepslate_impure_zarosite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4.5f,3.0f), UniformIntProvider.create(3, 7)));

    public static final Block IMPURE_ZAROSITE_BLOCK = registerBlock("impure_zarosite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));


    // FUEL BLOCKS ------------------

    public static final Block RED_COAL_BLOCK = registerBlock("red_coal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK)));


    // WOOD BLOCKS --------------------- VVVVVVVVVV ------------


    // >> EGRORIC ---------------------


    public static final Block EGRORIC_SAPLING = registerBlock("egroric_sapling",
            new SaplingBlock(new EgroricSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block EGRORIC_LEAVES = registerBlock("egroric_leaves",
            new EgroricLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    public static final Block EGRORIC_LOG = registerBlock("egroric_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(3f)));
    public static final Block EGRORIC_WOOD = registerBlock("egroric_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(3f)));
    public static final Block STRIPPED_EGRORIC_LOG = registerBlock("stripped_egroric_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final Block STRIPPED_EGRORIC_WOOD = registerBlock("stripped_egroric_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final Block EGRORIC_PLANKS = registerBlock("egroric_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block EGRORIC_STAIRS = registerBlock("egroric_stairs",
            new StairsBlock(ModBlocks.EGRORIC_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block EGRORIC_SLAB = registerBlock("egroric_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block EGRORIC_BUTTON = registerBlock("egroric_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK, 20, true));
    public static final Block EGRORIC_PRESSURE_PLATE = registerBlock("egroric_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS),BlockSetType.OAK));

    public static final Block EGRORIC_FENCE = registerBlock("egroric_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block EGRORIC_FENCE_GATE = registerBlock("egroric_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), WoodType.OAK));


    public static final Block EGRORIC_DOOR = registerBlock("egroric_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR),BlockSetType.OAK));
    public static final Block EGRORIC_TRAPDOOR = registerBlock("egroric_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR),BlockSetType.OAK));




    // >>> OAST

    public static final Block OAST_SAPLING = registerBlock("oast_sapling",
            new SaplingBlock(new OastSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block OAST_LEAVES = registerBlock("oast_leaves",
            new OastLeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque()));

    public static final Block OAST_LOG = registerBlock("oast_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(3f)));
    public static final Block OAST_WOOD = registerBlock("oast_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(3f)));
    public static final Block STRIPPED_OAST_LOG = registerBlock("stripped_oast_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final Block STRIPPED_OAST_WOOD = registerBlock("stripped_oast_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final Block OAST_PLANKS = registerBlock("oast_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block OAST_STAIRS = registerBlock("oast_stairs",
            new StairsBlock(ModBlocks.OAST_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block OAST_SLAB = registerBlock("oast_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block OAST_BUTTON = registerBlock("oast_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK, 20, true));
    public static final Block OAST_PRESSURE_PLATE = registerBlock("oast_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS),BlockSetType.OAK));

    public static final Block OAST_FENCE = registerBlock("oast_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block OAST_FENCE_GATE = registerBlock("oast_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), WoodType.OAK));

    public static final Block OAST_DOOR = registerBlock("oast_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR),BlockSetType.OAK));
    public static final Block OAST_TRAPDOOR = registerBlock("oast_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR),BlockSetType.OAK));



    // >>> SEPHIN

    public static final Block SEPHIN_SAPLING = registerBlock("sephin_sapling",
            new CustomSaplingBlock(new SephinSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING), () -> Blocks.SNOW_BLOCK));
    public static final Block SEPHIN_LEAVES = registerBlock("sephin_leaves",
            new SephinLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    public static final Block SEPHIN_LOG = registerBlock("sephin_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(3f)));
    public static final Block SEPHIN_WOOD = registerBlock("sephin_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(3f)));
    public static final Block STRIPPED_SEPHIN_LOG = registerBlock("stripped_sephin_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final Block STRIPPED_SEPHIN_WOOD = registerBlock("stripped_sephin_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final Block SEPHIN_PLANKS = registerBlock("sephin_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block SEPHIN_STAIRS = registerBlock("sephin_stairs",
            new StairsBlock(ModBlocks.SEPHIN_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block SEPHIN_SLAB = registerBlock("sephin_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block SEPHIN_BUTTON = registerBlock("sephin_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK, 20, true));
    public static final Block SEPHIN_PRESSURE_PLATE = registerBlock("sephin_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS),BlockSetType.OAK));

    public static final Block SEPHIN_FENCE = registerBlock("sephin_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block SEPHIN_FENCE_GATE = registerBlock("sephin_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), WoodType.OAK));

    public static final Block SEPHIN_DOOR = registerBlock("sephin_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR),BlockSetType.OAK));
    public static final Block SEPHIN_TRAPDOOR = registerBlock("sephin_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR),BlockSetType.OAK));

    // -------------------------------------

    // >>> KIWI

    public static final Block KIWI_SAPLING = registerBlock("kiwi_sapling",
            new SaplingBlock(new KiwiSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block KIWI_LEAVES = registerBlock("kiwi_leaves",
            new KiwiLeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    public static final Block KIWI_LOG = registerBlock("kiwi_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(3f)));
    public static final Block KIWI_WOOD = registerBlock("kiwi_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(3f)));
    public static final Block STRIPPED_KIWI_LOG = registerBlock("stripped_kiwi_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final Block STRIPPED_KIWI_WOOD = registerBlock("stripped_kiwi_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final Block KIWI_PLANKS = registerBlock("kiwi_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block KIWI_STAIRS = registerBlock("kiwi_stairs",
            new StairsBlock(ModBlocks.KIWI_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block KIWI_SLAB = registerBlock("kiwi_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block KIWI_BUTTON = registerBlock("kiwi_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK, 20, true));
    public static final Block KIWI_PRESSURE_PLATE = registerBlock("kiwi_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS),BlockSetType.OAK));

    public static final Block KIWI_FENCE = registerBlock("kiwi_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block KIWI_FENCE_GATE = registerBlock("kiwi_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), WoodType.OAK));

    public static final Block KIWI_DOOR = registerBlock("kiwi_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR),BlockSetType.OAK));
    public static final Block KIWI_TRAPDOOR = registerBlock("kiwi_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR),BlockSetType.OAK));

    // -------------------------------------






    // BUSHES ----

    public static final Block TORN_BUSH = registerBlock("torn_bush",
            new TornBrushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH).nonOpaque().noCollision()));


    // GRASSES ----

    // FLOWERS ----

    public static final Block PINK_PHYGELUS = registerBlock("pink_phygelus",
            new FlowerBlock(StatusEffects.REGENERATION, 30,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block RED_OSPET = registerBlock("red_ospet",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 40,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block POTTED_RED_OSPET = Registry.register(Registries.BLOCK, new Identifier(TheLongStory.MOD_ID, "potted_red_ospet"),
            new FlowerPotBlock(RED_OSPET, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block BLUE_OSPET = registerBlock("blue_ospet",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 30,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block POTTED_BLUE_OSPET = Registry.register(Registries.BLOCK, new Identifier(TheLongStory.MOD_ID, "potted_blue_ospet"),
            new FlowerPotBlock(BLUE_OSPET, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block GREEN_OSPET = registerBlock("green_ospet",
            new FlowerBlock(StatusEffects.JUMP_BOOST, 30,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block POTTED_GREEN_OSPET = Registry.register(Registries.BLOCK, new Identifier(TheLongStory.MOD_ID, "potted_green_ospet"),
            new FlowerPotBlock(GREEN_OSPET, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block YELLOW_OSPET = registerBlock("yellow_ospet",
            new FlowerBlock(StatusEffects.GLOWING, 30,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block POTTED_YELLOW_OSPET = Registry.register(Registries.BLOCK, new Identifier(TheLongStory.MOD_ID, "potted_yellow_ospet"),
            new FlowerPotBlock(YELLOW_OSPET, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));



    // ADVANCED BLOCKS ------------------

    public static final Block GREFFED_COMMAND_SYSTEM = registerBlock("greffed_command_system",
            new GreffedCommandSystemBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));

    public static final Block SIMULATION_TELEPORTER = registerBlock("simulation_teleporter",
            new SimulationTeleporterBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));



    // ----------------




    // --------------











    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(TheLongStory.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TheLongStory.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TheLongStory.LOGGER.info("Registering Blocks for " + TheLongStory.MOD_ID);
    }
}
