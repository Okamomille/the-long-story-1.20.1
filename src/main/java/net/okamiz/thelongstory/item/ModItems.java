package net.okamiz.thelongstory.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.entity.ModEntities;
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


    public static final Item RAW_IMPURE_ZAROSITE = registerItem("raw_impure_zarosite", new Item(new FabricItemSettings()));
    public static final Item IMPURE_ZAROSITE_INGOT = registerItem("impure_zarosite_ingot", new Item(new FabricItemSettings()));

    public static final Item ZAROSITE_GEMSTONE = registerItem("zarosite_gemstone", new Item(new FabricItemSettings()));
    public static final Item ZAROSITE_SHARD = registerItem("zarosite_shard", new Item(new FabricItemSettings()));


    public static final Item GREEN_SHARD = registerItem("green_shard", new Item(new FabricItemSettings()));
    public static final Item PURE_AMETHYST_SHARD = registerItem("pure_amethyst_shard", new ModGlintItem(new FabricItemSettings()));
    public static final Item FLAMING_SHARD = registerItem("flaming_shard", new ModGlintItem(new FabricItemSettings()));

    public static final Item DRONIUM_INGOT = registerItem("dronium_ingot", new Item(new FabricItemSettings()));
    public static final Item DRONIUM_POWDER = registerItem("dronium_powder", new Item(new FabricItemSettings()));


    public static final Item RAW_PANDAZITE = registerItem("raw_pandazite", new Item(new FabricItemSettings()));
    public static final Item PANDAZITE_INGOT = registerItem("pandazite_ingot", new Item(new FabricItemSettings()));
    public static final Item PANDAZITE_NUGGET = registerItem("pandazite_nugget", new Item(new FabricItemSettings()));



    // SYSTEMS MATERIALS

    public static final Item WOODEN_PLATE = registerItem("wooden_plate", new Item(new FabricItemSettings()));
    public static final Item IRON_PLATE = registerItem("iron_plate", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_PLATE = registerItem("diamond_plate", new Item(new FabricItemSettings()));
    public static final Item EMERALD_PLATE = registerItem("emerald_plate", new Item(new FabricItemSettings()));
    public static final Item NETHERITE_PLATE = registerItem("netherite_plate", new Item(new FabricItemSettings()));

    public static final Item CARBON_STICK = registerItem("carbon_stick", new Item(new FabricItemSettings()));
    public static final Item PURE_AMETHYST_STICK = registerItem("pure_amethyst_stick", new ModGlintItem(new FabricItemSettings()));
    public static final Item FLAMING_STICK = registerItem("flaming_stick", new ModGlintItem(new FabricItemSettings()));


    public static final Item AMETHYST_KEY = registerItem("amethyst_key", new AmethystKeyItem(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item AMETHYST_CORE = registerItem("amethyst_core", new ModGlintItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item FLAMING_CORE = registerItem("flaming_core", new ModGlintItem(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item EMPTY_CORE = registerItem("empty_core", new Item(new FabricItemSettings()));


    public static final Item COMMAND_SYSTEM = registerItem("command_system", new Item(new FabricItemSettings()));
    public static final Item TELEPORTATION_MODULE = registerItem("teleportation_module", new Item(new FabricItemSettings()));
    public static final Item POWER_MODULE = registerItem("power_module", new Item(new FabricItemSettings()));
    public static final Item DIMENSION_PATTERN = registerItem("dimension_pattern", new Item(new FabricItemSettings()));




    // EFFECT ITEMS
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
    public static final Item SOUL_CONTAINER_SATURATION = registerItem("soul_container_saturation", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));
    public static final Item SOUL_CONTAINER_HASTE = registerItem("soul_container_haste", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));
    public static final Item SOUL_CONTAINER_SLOW_FALLING = registerItem("soul_container_slow_falling", new SoulContainerFullItem(new FabricItemSettings()
            .rarity(Rarity.RARE)));

    //FUEL ITEMS -----------------

    public static final Item RED_COAL = registerItem("red_coal", new Item(new FabricItemSettings()));

    //ADVANCED ITEMS -----------------

    public static final Item BROKEN_TELEPORTATION_REMOTE = registerItem("broken_teleportation_remote",
            new BrokenItem(new FabricItemSettings().maxCount(1).maxDamage(50)));

    public static final Item TELEPORTATION_REMOTE = registerItem("teleportation_remote",
            new TeleportationRemoteItem(new FabricItemSettings().maxCount(1).maxDamage(50)));

    public static final Item POWER_STAR = registerItem("power_star",
            new PowerStarItem(new FabricItemSettings().fireproof()));

    public static final Item SOUL_CONTAINER = registerItem("soul_container",
            new SoulContainerItem(new FabricItemSettings().maxCount(1)));

    public static final Item MOB_CAPSULE = registerItem("mob_capsule",
            new MobCapsuleItem(new FabricItemSettings().maxCount(1)));








    //SEEDS --------------------------------


    public static final Item VITALY_SEEDS = registerItem("vitaly_seeds",
            new AliasedBlockItem(ModBlocks.VITALY_CROP, new FabricItemSettings()));
    public static final Item TORN_CARROT = registerItem("torn_carrot",
            new AliasedBlockItem(ModBlocks.TORN_CARROT_CROP, new FabricItemSettings().food(ModFoodComponents.TORN_CARROT)));

    public static final Item SWEET_PEAR_SEEDS = registerItem("sweet_pear_seeds",
            new AliasedBlockItem(ModBlocks.SWEET_PEAR_CROP, new FabricItemSettings()));







    //FOOD ITEMS -----------------

    public static final Item VITALY_FRUIT = registerItem("vitaly_fruit", new Item(new FabricItemSettings().food(ModFoodComponents.VITALY_FRUIT)));
    public static final Item SWEET_PEAR = registerItem("sweet_pear", new Item(new FabricItemSettings().food(ModFoodComponents.SWEET_PEAR)));

    public static final Item EMERALD_APPLE = registerItem("emerald_apple", new Item(new FabricItemSettings().food(ModFoodComponents.EMERALD_APPLE)));
    public static final Item IRON_APPLE = registerItem("iron_apple", new Item(new FabricItemSettings().food(ModFoodComponents.IRON_APPLE)));
    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new Item(new FabricItemSettings().food(ModFoodComponents.DIAMOND_APPLE)));
    public static final Item LAPIS_APPLE = registerItem("lapis_apple", new Item(new FabricItemSettings().food(ModFoodComponents.LAPIS_APPLE)));
    public static final Item AMETHYST_APPLE = registerItem("amethyst_apple", new Item(new FabricItemSettings().food(ModFoodComponents.AMETHYST_APPLE)));
    public static final Item REDSTONE_APPLE = registerItem("redstone_apple", new Item(new FabricItemSettings().food(ModFoodComponents.REDSTONE_APPLE)));
    public static final Item BREEDY_FLESH = registerItem("breedy_flesh", new Item(new FabricItemSettings().food(ModFoodComponents.BREEDY_FLESH)));
    public static final Item TOOKI_MEAT = registerItem("tooki_meat", new Item(new FabricItemSettings().food(ModFoodComponents.TOOKI_MEAT)));
    public static final Item COOKED_TOOKI_MEAT = registerItem("cooked_tooki_meat", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_TOOKI_MEAT)));




    //SPAWN EGGS ITEMS -----------------


    public static final Item AMETHYST_MINION_SPAWN_EGG = registerItem("amethyst_minion_spawn_egg",
            new SpawnEggItem(ModEntities.AMETHYST_MINION, 1667367,13990655, new FabricItemSettings()));

    public static final Item TREPASSEUR_SPAWN_EGG = registerItem("trepasseur_spawn_egg",
            new SpawnEggItem(ModEntities.TREPASSEUR, 5944735,5477236, new FabricItemSettings()));
    public static final Item TICKELER_SPAWN_EGG = registerItem("tickeler_spawn_egg",
            new SpawnEggItem(ModEntities.TICKELER, 3304518,9103214, new FabricItemSettings()));
    public static final Item CRAWLER_SPAWN_EGG = registerItem("crawler_spawn_egg",
            new SpawnEggItem(ModEntities.CRAWLER, 5339992,1078563, new FabricItemSettings()));
    public static final Item TOOKI_SPAWN_EGG = registerItem("tooki_spawn_egg",
            new SpawnEggItem(ModEntities.TOOKI, 12424932,7356576, new FabricItemSettings()));
    public static final Item COWSMIC_SPAWN_EGG = registerItem("cowsmic_spawn_egg",
            new SpawnEggItem(ModEntities.COWSMIC, 15500214,16777215, new FabricItemSettings()));
    public static final Item BREEDY_SPAWN_EGG = registerItem("breedy_spawn_egg",
            new SpawnEggItem(ModEntities.BREEDY, 16768071,16491304, new FabricItemSettings()));






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


    public static final Item IMPURE_ZAROSITE_PICKAXE = registerItem("impure_zarosite_pickaxe",
            new PickaxeItem(ModToolMaterial.IMPURE_ZAROSITE, 1, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item IMPURE_ZAROSITE_AXE = registerItem("impure_zarosite_axe",
            new AxeItem(ModToolMaterial.IMPURE_ZAROSITE, 6.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item IMPURE_ZAROSITE_SHOVEL = registerItem("impure_zarosite_shovel",
            new ShovelItem(ModToolMaterial.IMPURE_ZAROSITE, 1.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item IMPURE_ZAROSITE_HOE = registerItem("impure_zarosite_hoe",
            new HoeItem(ModToolMaterial.IMPURE_ZAROSITE, -3, -1.0f, new FabricItemSettings().maxCount(1)));
    public static final Item IMPURE_ZAROSITE_SWORD = registerItem("impure_zarosite_sword",
            new SwordItem(ModToolMaterial.IMPURE_ZAROSITE, 3, -2.3f, new FabricItemSettings().maxCount(1)));

    public static final Item IMPURE_ZAROSITE_BOW = registerItem("impure_zarosite_bow",
            new BowItem(new FabricItemSettings().maxCount(1).maxDamage(521)));



    public static final Item ZAROSITE_PICKAXE = registerItem("zarosite_pickaxe",
            new PickaxeItem(ModToolMaterial.ZAROSITE, 1, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item ZAROSITE_AXE = registerItem("zarosite_axe",
            new AxeItem(ModToolMaterial.ZAROSITE, 6.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item ZAROSITE_SHOVEL = registerItem("zarosite_shovel",
            new ShovelItem(ModToolMaterial.ZAROSITE, 1.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item ZAROSITE_HOE = registerItem("zarosite_hoe",
            new HoeItem(ModToolMaterial.ZAROSITE, -3, -1.0f, new FabricItemSettings().maxCount(1)));
    public static final Item ZAROSITE_SWORD = registerItem("zarosite_sword",
            new ZarositeSwordItem(ModToolMaterial.ZAROSITE, 3, -2.3f, new FabricItemSettings().maxCount(1)));


    public static final Item DRONIUM_PICKAXE = registerItem("dronium_pickaxe",
            new PickaxeItem(ModToolMaterial.DRONIUM, 1, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item DRONIUM_AXE = registerItem("dronium_axe",
            new AxeItem(ModToolMaterial.DRONIUM, 6.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item DRONIUM_SHOVEL = registerItem("dronium_shovel",
            new ShovelItem(ModToolMaterial.DRONIUM, 1.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item DRONIUM_HOE = registerItem("dronium_hoe",
            new HoeItem(ModToolMaterial.DRONIUM, -3, -1.0f, new FabricItemSettings().maxCount(1)));
    public static final Item DRONIUM_SWORD = registerItem("dronium_sword",
            new SwordItem(ModToolMaterial.DRONIUM, 3, -2.3f, new FabricItemSettings().maxCount(1)));


    public static final Item PURE_AMETHYST_SWORD = registerItem("pure_amethyst_sword",
            new PureAmethystSwordItem(ModToolMaterial.PURE_AMETHYST, 3, -2.3f, new FabricItemSettings().maxCount(1)));
    public static final Item PURE_AMETHYST_PICKAXE = registerItem("pure_amethyst_pickaxe",
            new PureAmethystPickaxeItem(ModToolMaterial.PURE_AMETHYST, 1, -2.8f, new FabricItemSettings().maxCount(1)));


    public static final Item PANDAZITE_PICKAXE = registerItem("pandazite_pickaxe",
            new PickaxeItem(ModToolMaterial.PANDAZITE, 1, -2.8f, new FabricItemSettings().maxCount(1)));
    public static final Item PANDAZITE_AXE = registerItem("pandazite_axe",
            new AxeItem(ModToolMaterial.PANDAZITE, 6.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item PANDAZITE_SHOVEL = registerItem("pandazite_shovel",
            new ShovelItem(ModToolMaterial.PANDAZITE, 1.5f, -3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item PANDAZITE_HOE = registerItem("pandazite_hoe",
            new HoeItem(ModToolMaterial.PANDAZITE, -3, -1.0f, new FabricItemSettings().maxCount(1)));
    public static final Item PANDAZITE_SWORD = registerItem("pandazite_sword",
            new SwordItem(ModToolMaterial.PANDAZITE, 3, -2.3f, new FabricItemSettings().maxCount(1)));



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
            new ArmorItem(ModArmorMaterials.GREEN_SHARD, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GREEN_SHARD_CHESTPLATE = registerItem("green_shard_chestplate",
            new ArmorItem(ModArmorMaterials.GREEN_SHARD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GREEN_SHARD_LEGGINGS = registerItem("green_shard_leggings",
            new ArmorItem(ModArmorMaterials.GREEN_SHARD, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GREEN_SHARD_BOOTS = registerItem("green_shard_boots",
            new ArmorItem(ModArmorMaterials.GREEN_SHARD, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    public static final Item IMPURE_ZAROSITE_HELMET = registerItem("impure_zarosite_helmet",
            new ArmorItem(ModArmorMaterials.IMPURE_ZAROSITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IMPURE_ZAROSITE_CHESTPLATE = registerItem("impure_zarosite_chestplate",
            new ArmorItem(ModArmorMaterials.IMPURE_ZAROSITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item IMPURE_ZAROSITE_LEGGINGS = registerItem("impure_zarosite_leggings",
            new ArmorItem(ModArmorMaterials.IMPURE_ZAROSITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item IMPURE_ZAROSITE_BOOTS = registerItem("impure_zarosite_boots",
            new ArmorItem(ModArmorMaterials.IMPURE_ZAROSITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item ZAROSITE_HELMET = registerItem("zarosite_helmet",
            new ArmorItem(ModArmorMaterials.ZAROSITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ZAROSITE_CHESTPLATE = registerItem("zarosite_chestplate",
            new ArmorItem(ModArmorMaterials.ZAROSITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ZAROSITE_LEGGINGS = registerItem("zarosite_leggings",
            new ArmorItem(ModArmorMaterials.ZAROSITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ZAROSITE_BOOTS = registerItem("zarosite_boots",
            new ArmorItem(ModArmorMaterials.ZAROSITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item DRONIUM_HELMET = registerItem("dronium_helmet",
            new ArmorItem(ModArmorMaterials.DRONIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DRONIUM_CHESTPLATE = registerItem("dronium_chestplate",
            new ArmorItem(ModArmorMaterials.DRONIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DRONIUM_LEGGINGS = registerItem("dronium_leggings",
            new ArmorItem(ModArmorMaterials.DRONIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item DRONIUM_BOOTS = registerItem("dronium_boots",
            new ArmorItem(ModArmorMaterials.DRONIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));



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
