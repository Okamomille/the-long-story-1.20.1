package net.okamiz.thelongstory.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.item.custom.RadarItem;

public class ModItems {

    public static final Item BONE_FRAGMENTS = registerItem("bone_fragments", new Item(new FabricItemSettings()));
    public static final Item CRUSHED_BONES = registerItem("crushed_bones", new Item(new FabricItemSettings()));
    public static final Item INFESTED_FLESH = registerItem("infested_flesh", new Item(new FabricItemSettings()));

    public static final Item BLOOD_BOTTLE = registerItem("blood_bottle", new Item(new FabricItemSettings().maxCount(16)));
    public static final Item SPIDER_SILK = registerItem("spider_silk", new Item(new FabricItemSettings()));

    public static final Item THESTONE_DUST = registerItem("thestone_dust", new Item(new FabricItemSettings()));
    public static final Item THESTONE_INGOT = registerItem("thestone_ingot", new Item(new FabricItemSettings()));
    public static final Item THESTONE_NUGGET = registerItem("thestone_nugget", new Item(new FabricItemSettings()));


    //FUEL ITEMS -----------------

    public static final Item RED_COAL = registerItem("red_coal", new Item(new FabricItemSettings()));

    //ADVANCED ITEMS -----------------

    public static final Item RADAR = registerItem("radar",
            new RadarItem(new FabricItemSettings().maxCount(1).maxDamage(50)));

    //FOOD ITEMS -----------------

    public static final Item EMERALD_APPLE = registerItem("emerald_apple", new Item(new FabricItemSettings().food(ModFoodComponents.EMERALD_APPLE)));
    public static final Item IRON_APPLE = registerItem("iron_apple", new Item(new FabricItemSettings().food(ModFoodComponents.IRON_APPLE)));
    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new Item(new FabricItemSettings().food(ModFoodComponents.DIAMOND_APPLE)));
    public static final Item LAPIS_APPLE = registerItem("lapis_apple", new Item(new FabricItemSettings().food(ModFoodComponents.LAPIS_APPLE)));
    public static final Item AMETHYST_APPLE = registerItem("amethyst_apple", new Item(new FabricItemSettings().food(ModFoodComponents.AMETHYST_APPLE)));
    public static final Item REDSTONE_APPLE = registerItem("redstone_apple", new Item(new FabricItemSettings().food(ModFoodComponents.REDSTONE_APPLE)));




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


    //ARMOR ITEMS -----------------

    public static final Item THESTONE_HELMET = registerItem("thestone_helmet",
            new ArmorItem(ModArmorMaterials.THESTONE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item THESTONE_CHESTPLATE = registerItem("thestone_chestplate",
            new ArmorItem(ModArmorMaterials.THESTONE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item THESTONE_LEGGINGS = registerItem("thestone_leggings",
            new ArmorItem(ModArmorMaterials.THESTONE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item THESTONE_BOOTS = registerItem("thestone_boots",
            new ArmorItem(ModArmorMaterials.THESTONE, ArmorItem.Type.BOOTS, new FabricItemSettings()));






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
