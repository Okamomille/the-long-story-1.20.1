package net.okamiz.thelongstory.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
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

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(SPIDER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.SPIDER_SILK))
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
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }

            if(CAVE_SPIDER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33f)) // 1f = 100% of the time
                        .with(ItemEntry.builder(ModItems.BLOOD_BOTTLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }



        }));
    }

}
