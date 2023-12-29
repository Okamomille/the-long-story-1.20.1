package net.okamiz.thelongstory.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.okamiz.thelongstory.entity.ModEntities;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.item.custom.*;

public class ModItems {

    public static final Item BONE_FRAGMENTS = registerItem("bone_fragments", new Item(new FabricItemSettings()));
    public static final Item CRUSHED_BONES = registerItem("crushed_bones", new Item(new FabricItemSettings()));
    public static final Item INFESTED_FLESH = registerItem("infested_flesh", new Item(new FabricItemSettings().food(ModFoodComponents.INFESTED_FLESH)));

    public static final Item BLOOD_BOTTLE = registerItem("blood_bottle", new Item(new FabricItemSettings().maxCount(16)));
    public static final Item SPIDER_SILK = registerItem("spider_silk", new Item(new FabricItemSettings()));


    //ORE/MATERIAL ITEMS -------------------

    public static final Item THESTONE_DUST = registerItem("thestone_dust", new Item(new FabricItemSettings()));
    public static final Item THESTONE_INGOT = registerItem("thestone_ingot", new Item(new FabricItemSettings()));
    public static final Item THESTONE_NUGGET = registerItem("thestone_nugget", new Item(new FabricItemSettings()));


    public static final Item GREEN_SHARD = registerItem("green_shard", new Item(new FabricItemSettings()));


    public static final Item WOODEN_PLATE = registerItem("wooden_plate", new Item(new FabricItemSettings()));
    public static final Item IRON_PLATE = registerItem("iron_plate", new Item(new FabricItemSettings()));
    public static final Item COMMAND_SYSTEM = registerItem("command_system", new Item(new FabricItemSettings()));


    public static final Item POTION_RECEPTACLE = registerItem("potion_receptacle", new Item(new FabricItemSettings()));
    public static final Item POTION_CORE = registerItem("potion_core", new ModGlintItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item SOUL_CONTAINER_REGENERATION = registerItem("soul_container_regeneration", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));
    public static final Item SOUL_CONTAINER_FIRE_RESISTANCE = registerItem("soul_container_fire_resistance", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));
    public static final Item SOUL_CONTAINER_JUMP_BOOST = registerItem("soul_container_jump_boost", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));
    public static final Item SOUL_CONTAINER_DOLPHIN_GRACE = registerItem("soul_container_dolphin_grace", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));
    public static final Item SOUL_CONTAINER_NIGHT_VISION = registerItem("soul_container_night_vision", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));
    public static final Item SOUL_CONTAINER_RESISTANCE = registerItem("soul_container_resistance", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));


    //FUEL ITEMS -----------------

    public static final Item RED_COAL = registerItem("red_coal", new Item(new FabricItemSettings()));

    //ADVANCED ITEMS -----------------

    public static final Item RADAR = registerItem("radar",
            new RadarItem(new FabricItemSettings().maxCount(1).maxDamage(50)));

    public static final Item POWER_STAR = registerItem("power_star",
            new PowerStarItem(new FabricItemSettings().fireproof()));

    public static final Item SOUL_CONTAINER = registerItem("soul_container",
            new SoulContainerItem(new FabricItemSettings().maxCount(1)));

    //FOOD ITEMS -----------------

    public static final Item EMERALD_APPLE = registerItem("emerald_apple", new Item(new FabricItemSettings().food(ModFoodComponents.EMERALD_APPLE)));
    public static final Item IRON_APPLE = registerItem("iron_apple", new Item(new FabricItemSettings().food(ModFoodComponents.IRON_APPLE)));
    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new Item(new FabricItemSettings().food(ModFoodComponents.DIAMOND_APPLE)));
    public static final Item LAPIS_APPLE = registerItem("lapis_apple", new Item(new FabricItemSettings().food(ModFoodComponents.LAPIS_APPLE)));
    public static final Item AMETHYST_APPLE = registerItem("amethyst_apple", new Item(new FabricItemSettings().food(ModFoodComponents.AMETHYST_APPLE)));
    public static final Item REDSTONE_APPLE = registerItem("redstone_apple", new Item(new FabricItemSettings().food(ModFoodComponents.REDSTONE_APPLE)));




    //SPAWN EGGS ITEMS -----------------


    public static final Item TREPASSEUR_SPAWN_EGG = registerItem("trepasseur_spawn_egg",
            new SpawnEggItem(ModEntities.TREPASSEUR, 5944735,5477236, new FabricItemSettings()));

    public static final Item TICKELER_SPAWN_EGG = registerItem("tickeler_spawn_egg",
            new SpawnEggItem(ModEntities.TICKELER, 3304518,9103214, new FabricItemSettings()));

    public static final Item CRAWLER_SPAWN_EGG = registerItem("crawler_spawn_egg",
            new SpawnEggItem(ModEntities.CRAWLER, 5339992,1078563, new FabricItemSettings()));





    //TOOLS ITEMS -----------------

    public static final Item THESTONE_PICKAXE = registerItem("thestone_pickaxe",
            new PickaxeItem(ModToolMaterial.THESTONE, 1, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item THESTONE_AXE = registerItem("thestone_axe",
            new AxeItem(ModToolMaterial.THESTONE, 6.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item THESTONE_SHOVEL = registerItem("thestone_shovel",
            new ShovelItem(ModToolMaterial.THESTONE, 1.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item THESTONE_HOE = registerItem("thestone_hoe",
            new HoeItem(ModToolMaterial.THESTONE, -2, -1.0f, new FabricItemSettings().maxCount(1)));
    public static final Item THESTONE_SWORD = registerItem("thestone_sword",
            new SwordItem(ModToolMaterial.THESTONE, 3, -2.0f, new FabricItemSettings().maxCount(1)));


    public static final Item GREEN_SHARD_PICKAXE = registerItem("green_shard_pickaxe",
            new PickaxeItem(ModToolMaterial.GREEN_SHARD, 1, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item GREEN_SHARD_AXE = registerItem("green_shard_axe",
            new AxeItem(ModToolMaterial.GREEN_SHARD, 6.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item GREEN_SHARD_SHOVEL = registerItem("green_shard_shovel",
            new ShovelItem(ModToolMaterial.GREEN_SHARD, 1.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item GREEN_SHARD_HOE = registerItem("green_shard_hoe",
            new HoeItem(ModToolMaterial.GREEN_SHARD, -2, -1.0f, new FabricItemSettings().maxCount(1)));
    public static final Item GREEN_SHARD_SWORD = registerItem("green_shard_sword",
            new SwordItem(ModToolMaterial.GREEN_SHARD, 3, -2.0f, new FabricItemSettings().maxCount(1)));


    //ARMOR ITEMS -----------------

    public static final Item THESTONE_HELMET = registerItem("thestone_helmet",
            new ModArmorItem(ModArmorMaterials.THESTONE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item THESTONE_CHESTPLATE = registerItem("thestone_chestplate",
            new ModArmorItem(ModArmorMaterials.THESTONE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item THESTONE_LEGGINGS = registerItem("thestone_leggings",
            new ModArmorItem(ModArmorMaterials.THESTONE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item THESTONE_BOOTS = registerItem("thestone_boots",
            new ModArmorItem(ModArmorMaterials.THESTONE, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    public static final Item GREEN_SHARD_HELMET = registerItem("green_shard_helmet",
            new ModArmorItem(ModArmorMaterials.GREEN_SHARD, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GREEN_SHARD_CHESTPLATE = registerItem("green_shard_chestplate",
            new ModArmorItem(ModArmorMaterials.GREEN_SHARD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GREEN_SHARD_LEGGINGS = registerItem("green_shard_leggings",
            new ModArmorItem(ModArmorMaterials.GREEN_SHARD, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GREEN_SHARD_BOOTS = registerItem("green_shard_boots",
            new ModArmorItem(ModArmorMaterials.GREEN_SHARD, ArmorItem.Type.BOOTS, new FabricItemSettings()));






    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){

    }



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TheLongStory.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TheLongStory.LOGGER.info("Registering Mod Items for " + TheLongStory.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
