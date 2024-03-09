package net.okamiz.thelongstory.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.item.ModItems;

public class ModLootTableModifiers {

    private static final Identifier CAVE_SPIDER_ID =
            new Identifier("minecraft", "entities/cave_spider");
    private static final Identifier SPIDER_ID =
            new Identifier("minecraft", "entities/spider");
    private static final Identifier SKELETON_ID =
            new Identifier("minecraft", "entities/skeleton");

    private static final Identifier TREPASSEUR_ID =
            new Identifier("thelongstory", "entities/trepasseur");
    private static final Identifier TICKELER_ID =
            new Identifier("thelongstory", "entities/tickeler");

    private static final Identifier GRASS_ID =
            new Identifier("minecraft", "blocks/grass");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(SPIDER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.SPIDER_SILK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }

            if(SKELETON_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.BONE_FRAGMENTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }

            if(SPIDER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.BLOOD_BOTTLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }

            if(CAVE_SPIDER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.SPIDER_SILK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,3.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }

            if(TREPASSEUR_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.89f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.INFESTED_FLESH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }


            if(TICKELER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.87f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(Items.ROTTEN_FLESH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }


            if(GRASS_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.SWEET_PEAR_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }
            if(GRASS_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.VITALY_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }



        }));
    }

}
