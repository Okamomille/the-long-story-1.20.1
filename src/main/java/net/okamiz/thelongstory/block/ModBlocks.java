package net.okamiz.thelongstory.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.custom.PinkGreffedCommandSystemBlock;

public class ModBlocks {


    public static final Block CRUSHED_BONES_BLOCK = registerBlock("crushed_bones_block",
            new Block(FabricBlockSettings.copyOf(Blocks.SAND)));
    public static final Block MOLD_BLOCK = registerBlock("mold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD)));
    public static final Block SPIDER_SILK_BLOCK = registerBlock("spider_silk_block",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

    public static final Block THESTONE_ORE = registerBlock("thestone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(3.0f,3.0f), UniformIntProvider.create(1, 5)));

    public static final Block DEEPSLATE_THESTONE_ORE = registerBlock("deepslate_thestone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4.5f,3.0f), UniformIntProvider.create(2, 6)));


    // FUEL BLOCKS ------------------

    public static final Block RED_COAL_BLOCK = registerBlock("red_coal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK)));


    // WOOD BLOCKS ---------------------


    // EGRORIC ---------------------

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



    // -------------------------------------


    // ADVANCED BLOCKS ------------------

    public static final Block PINK_GREFFED_COMMAND_SYSTEM = registerBlock("pink_greffed_command_system",
            new PinkGreffedCommandSystemBlock(FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE)));


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
