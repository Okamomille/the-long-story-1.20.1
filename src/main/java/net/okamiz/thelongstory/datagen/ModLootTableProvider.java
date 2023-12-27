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
        addDrop(ModBlocks.PINK_GREFFED_COMMAND_SYSTEM);
        addDrop(ModBlocks.LIME_GREFFED_COMMAND_SYSTEM);
        addDrop(ModBlocks.ORANGE_GREFFED_COMMAND_SYSTEM);
        addDrop(ModBlocks.MOLD_BLOCK);
        addDrop(ModBlocks.RED_COAL_BLOCK);
        addDrop(ModBlocks.SPIDER_SILK_BLOCK);


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
