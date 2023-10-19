package net.okamiz.thelongstory.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.item.custom.RadarItem;

public class ModItems {

    public static final Item BONE_FRAGMENTS = registerItem("bone_fragments", new Item(new FabricItemSettings()));
    public static final Item CRUSHED_BONES = registerItem("crushed_bones", new Item(new FabricItemSettings()));
    public static final Item INFESTED_FLESH = registerItem("infested_flesh", new Item(new FabricItemSettings()));

    public static final Item RADAR = registerItem("radar",
            new RadarItem(new FabricItemSettings().maxCount(1).maxDamage(50)));




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
