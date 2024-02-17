package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.item.ModItems;


public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.SIMULATION_TELEPORTER);
        addDrop(ModBlocks.GREFFED_COMMAND_SYSTEM);
        addDrop(ModBlocks.BROKEN_GREFFED_COMMAND_SYSTEM);
        addDrop(ModBlocks.BROKEN_SIMULATION_TELEPORTER);
        addDrop(ModBlocks.MATERIAL_PROCESSOR);
        addDrop(ModBlocks.RED_COAL_GENERATOR);
        addDrop(ModBlocks.DRONIUM_BLOCK);


        addDrop(ModBlocks.MOLD_BLOCK);
        addDrop(ModBlocks.RED_COAL_BLOCK);
        addDrop(ModBlocks.SPIDER_SILK_BLOCK);
        addDrop(ModBlocks.DEEP_ICE);
        addDrop(ModBlocks.IMPURE_GLITCHED_BLOCK);
        addDrop(ModBlocks.PURE_GLITCHED_BLOCK);

        addDrop(ModBlocks.ICED_COBBLESTONE);
        addDrop(ModBlocks.ICED_CHISELED_STONE_BRICKS);
        addDrop(ModBlocks.ICED_CHISELED_STONE_BRICKS_STAIRS);
        addDrop(ModBlocks.ICED_CHISELED_STONE_BRICKS_SLAB);
        addDrop(ModBlocks.ICED_CHISELED_STONE_BRICKS_WALL);

        addDrop(ModBlocks.ICED_STONE);
        addDrop(ModBlocks.ICED_STONE_STAIRS);
        addDrop(ModBlocks.ICED_STONE_SLAB);
        addDrop(ModBlocks.ICED_STONE_WALL);

        addDrop(ModBlocks.ICED_CRACKED_STONE_BRICKS);
        addDrop(ModBlocks.ICED_CRACKED_STONE_BRICKS_STAIRS);
        addDrop(ModBlocks.ICED_CRACKED_STONE_BRICKS_SLAB);
        addDrop(ModBlocks.ICED_CRACKED_STONE_BRICKS_WALL);

        addDrop(ModBlocks.ICED_STONE_BRICKS);
        addDrop(ModBlocks.ICED_STONE_BRICKS_STAIRS);
        addDrop(ModBlocks.ICED_STONE_BRICKS_SLAB);
        addDrop(ModBlocks.ICED_STONE_BRICKS_WALL);
        addDrop(ModBlocks.IMPURE_ZAROSITE_BLOCK);
        addDrop(ModBlocks.ZAROSITE_BLOCK);

        addDrop(ModBlocks.LAB_TILES);
        addDrop(ModBlocks.LAB_TILES_STAIRS);
        addDrop(ModBlocks.LAB_TILES_SLAB);
        addDrop(ModBlocks.LAB_TILES_WALL);

        addDrop(ModBlocks.CORRUPTED_LAB_TILES);
        addDrop(ModBlocks.CORRUPTED_LAB_TILES_STAIRS);
        addDrop(ModBlocks.CORRUPTED_LAB_TILES_SLAB);
        addDrop(ModBlocks.CORRUPTED_LAB_TILES_WALL);


        //EGRORIC LOOTS ------------------------------------
        addDrop(ModBlocks.EGRORIC_LEAVES, leavesDrops(ModBlocks.EGRORIC_LEAVES, ModBlocks.EGRORIC_SAPLING, 0.025f));
        addDrop(ModBlocks.EGRORIC_SAPLING);
        addDrop(ModBlocks.EGRORIC_LOG);
        addDrop(ModBlocks.STRIPPED_EGRORIC_LOG);
        addDrop(ModBlocks.EGRORIC_WOOD);
        addDrop(ModBlocks.STRIPPED_EGRORIC_WOOD);
        addDrop(ModBlocks.EGRORIC_PLANKS);
        addDrop(ModBlocks.EGRORIC_STAIRS);
        addDrop(ModBlocks.EGRORIC_TRAPDOOR);
        addDrop(ModBlocks.EGRORIC_PRESSURE_PLATE);
        addDrop(ModBlocks.EGRORIC_BUTTON);
        addDrop(ModBlocks.EGRORIC_FENCE_GATE);
        addDrop(ModBlocks.EGRORIC_FENCE);
        addDrop(ModBlocks.EGRORIC_DOOR, doorDrops(ModBlocks.EGRORIC_DOOR));
        addDrop(ModBlocks.EGRORIC_SLAB, slabDrops(ModBlocks.EGRORIC_SLAB));

        //OAST LOOTS ------------------------------------
        addDrop(ModBlocks.OAST_LEAVES, leavesDrops(ModBlocks.OAST_LEAVES, ModBlocks.OAST_SAPLING, 0.025f));
        addDrop(ModBlocks.OAST_SAPLING);
        addDrop(ModBlocks.OAST_LOG);
        addDrop(ModBlocks.STRIPPED_OAST_LOG);
        addDrop(ModBlocks.OAST_WOOD);
        addDrop(ModBlocks.STRIPPED_OAST_WOOD);
        addDrop(ModBlocks.OAST_PLANKS);
        addDrop(ModBlocks.OAST_STAIRS);
        addDrop(ModBlocks.OAST_PRESSURE_PLATE);
        addDrop(ModBlocks.OAST_BUTTON);
        addDrop(ModBlocks.OAST_FENCE_GATE);
        addDrop(ModBlocks.OAST_FENCE);
        addDrop(ModBlocks.OAST_SLAB, slabDrops(ModBlocks.OAST_SLAB));
        addDrop(ModBlocks.OAST_DOOR, doorDrops(ModBlocks.OAST_DOOR));
        addDrop(ModBlocks.OAST_TRAPDOOR);

        //SEPHIN LOOTS ------------------------------------
        addDrop(ModBlocks.SEPHIN_LEAVES, leavesDrops(ModBlocks.SEPHIN_LEAVES, ModBlocks.SEPHIN_SAPLING, 0.025f));
        addDrop(ModBlocks.SEPHIN_SAPLING);
        addDrop(ModBlocks.SEPHIN_LOG);
        addDrop(ModBlocks.STRIPPED_SEPHIN_LOG);
        addDrop(ModBlocks.SEPHIN_WOOD);
        addDrop(ModBlocks.STRIPPED_SEPHIN_WOOD);
        addDrop(ModBlocks.SEPHIN_PLANKS);
        addDrop(ModBlocks.SEPHIN_STAIRS);
        addDrop(ModBlocks.SEPHIN_PRESSURE_PLATE);
        addDrop(ModBlocks.SEPHIN_BUTTON);
        addDrop(ModBlocks.SEPHIN_FENCE_GATE);
        addDrop(ModBlocks.SEPHIN_FENCE);
        addDrop(ModBlocks.SEPHIN_SLAB, slabDrops(ModBlocks.SEPHIN_SLAB));
        addDrop(ModBlocks.SEPHIN_DOOR, doorDrops(ModBlocks.SEPHIN_DOOR));
        addDrop(ModBlocks.SEPHIN_TRAPDOOR);

        //SEPHIN LOOTS ------------------------------------
        addDrop(ModBlocks.KIWI_LEAVES, leavesDrops(ModBlocks.KIWI_LEAVES, ModBlocks.KIWI_SAPLING, 0.025f));
        addDrop(ModBlocks.KIWI_SAPLING);
        addDrop(ModBlocks.KIWI_LOG);
        addDrop(ModBlocks.STRIPPED_KIWI_LOG);
        addDrop(ModBlocks.KIWI_WOOD);
        addDrop(ModBlocks.STRIPPED_KIWI_WOOD);
        addDrop(ModBlocks.KIWI_PLANKS);
        addDrop(ModBlocks.KIWI_STAIRS);
        addDrop(ModBlocks.KIWI_PRESSURE_PLATE);
        addDrop(ModBlocks.KIWI_BUTTON);
        addDrop(ModBlocks.KIWI_FENCE_GATE);
        addDrop(ModBlocks.KIWI_FENCE);
        addDrop(ModBlocks.KIWI_SLAB, slabDrops(ModBlocks.KIWI_SLAB));
        addDrop(ModBlocks.KIWI_DOOR, doorDrops(ModBlocks.KIWI_DOOR));
        addDrop(ModBlocks.KIWI_TRAPDOOR);




        addDropWithSilkTouch(ModBlocks.TORN_BUSH);



        addDrop(ModBlocks.TORN_FLOWER);
        addDrop(ModBlocks.PINK_PHYGELUS);
        addDrop(ModBlocks.YELLOW_PHYGELUS);
        addDrop(ModBlocks.RED_OSPET);
        addDrop(ModBlocks.BLUE_OSPET);
        addDrop(ModBlocks.GREEN_OSPET);
        addDrop(ModBlocks.YELLOW_OSPET);

        addPottedPlantDrops(ModBlocks.POTTED_RED_OSPET);
        addPottedPlantDrops(ModBlocks.POTTED_BLUE_OSPET);
        addPottedPlantDrops(ModBlocks.POTTED_GREEN_OSPET);
        addPottedPlantDrops(ModBlocks.POTTED_YELLOW_OSPET);

        addDrop(ModBlocks.THESTONE_ORE, copperLikeOreDrops(ModBlocks.THESTONE_ORE, ModItems.THESTONE_DUST));
        addDrop(ModBlocks.DEEPSLATE_THESTONE_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_THESTONE_ORE, ModItems.THESTONE_DUST));

        oreDrops(ModBlocks.IMPURE_ZAROSITE_ORE, ModItems.RAW_IMPURE_ZAROSITE);
        oreDrops(ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE, ModItems.RAW_IMPURE_ZAROSITE);

        addDrop(ModBlocks.DEEP_ICE_ZAROSITE_ORE, copperLikeOreDrops(ModBlocks.DEEP_ICE_ZAROSITE_ORE, ModItems.ZAROSITE_SHARD));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item){
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f,5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

}
