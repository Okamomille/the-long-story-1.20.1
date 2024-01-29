package net.okamiz.thelongstory.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheLongStory.MOD_ID, "modgroup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.modgroup"))
                    .icon(() -> new ItemStack(ModItems.BONE_FRAGMENTS)).entries((displayContext, entries) -> {

                        entries.add(ModItems.INFESTED_FLESH);
                        entries.add(ModItems.BONE_FRAGMENTS);
                        entries.add(ModItems.CRUSHED_BONES);
                        entries.add(ModItems.BLOOD_BOTTLE);
                        entries.add(ModItems.SPIDER_SILK);

                        entries.add(ModItems.WOODEN_PLATE);
                        entries.add(ModItems.IRON_PLATE);
                        entries.add(ModItems.DIAMOND_PLATE);
                        entries.add(ModItems.EMERALD_PLATE);
                        entries.add(ModItems.NETHERITE_PLATE);

                        entries.add(ModItems.COMMAND_SYSTEM);
                        entries.add(ModItems.POWER_MODULE);
                        entries.add(ModItems.TELEPORTATION_MODULE);

                        entries.add(ModItems.POWER_STAR);
                        entries.add(ModItems.SOUL_CONTAINER);
                        entries.add(ModItems.SOUL_CONTAINER_REGENERATION);
                        entries.add(ModItems.SOUL_CONTAINER_FIRE_RESISTANCE);
                        entries.add(ModItems.SOUL_CONTAINER_JUMP_BOOST);
                        entries.add(ModItems.SOUL_CONTAINER_DOLPHIN_GRACE);
                        entries.add(ModItems.SOUL_CONTAINER_NIGHT_VISION);
                        entries.add(ModItems.SOUL_CONTAINER_RESISTANCE);

                        entries.add(ModItems.POTION_RECEPTACLE);
                        entries.add(ModItems.POTION_CORE);

                        entries.add(ModItems.THESTONE_DUST);
                        entries.add(ModItems.THESTONE_INGOT);
                        entries.add(ModItems.THESTONE_NUGGET);

                        entries.add(ModItems.RAW_IMPURE_ZAROSITE);
                        entries.add(ModItems.IMPURE_ZAROSITE_INGOT);

                        entries.add(ModItems.GREEN_SHARD);


                        entries.add(ModItems.THESTONE_SWORD);
                        entries.add(ModItems.THESTONE_PICKAXE);
                        entries.add(ModItems.THESTONE_AXE);
                        entries.add(ModItems.THESTONE_SHOVEL);
                        entries.add(ModItems.THESTONE_HOE);

                        entries.add(ModItems.GREEN_SHARD_SWORD);
                        entries.add(ModItems.GREEN_SHARD_PICKAXE);
                        entries.add(ModItems.GREEN_SHARD_AXE);
                        entries.add(ModItems.GREEN_SHARD_SHOVEL);
                        entries.add(ModItems.GREEN_SHARD_HOE);

                        entries.add(ModItems.IMPURE_ZAROSITE_SWORD);
                        entries.add(ModItems.IMPURE_ZAROSITE_PICKAXE);
                        entries.add(ModItems.IMPURE_ZAROSITE_AXE);
                        entries.add(ModItems.IMPURE_ZAROSITE_SHOVEL);
                        entries.add(ModItems.IMPURE_ZAROSITE_HOE);


                        entries.add(ModItems.THESTONE_HELMET);
                        entries.add(ModItems.THESTONE_CHESTPLATE);
                        entries.add(ModItems.THESTONE_LEGGINGS);
                        entries.add(ModItems.THESTONE_BOOTS);

                        entries.add(ModItems.GREEN_SHARD_HELMET);
                        entries.add(ModItems.GREEN_SHARD_CHESTPLATE);
                        entries.add(ModItems.GREEN_SHARD_LEGGINGS);
                        entries.add(ModItems.GREEN_SHARD_BOOTS);

                        entries.add(ModItems.IMPURE_ZAROSITE_HELMET);
                        entries.add(ModItems.IMPURE_ZAROSITE_CHESTPLATE);
                        entries.add(ModItems.IMPURE_ZAROSITE_LEGGINGS);
                        entries.add(ModItems.IMPURE_ZAROSITE_BOOTS);



                        entries.add(ModItems.TELEPORTATION_REMOTE);
                        entries.add(ModItems.RED_COAL);
                        entries.add(ModBlocks.DEEP_ICE);

                        entries.add(ModBlocks.CRUSHED_BONES_BLOCK);
                        entries.add(ModBlocks.MOLD_BLOCK);
                        entries.add(ModBlocks.SPIDER_SILK_BLOCK);
                        entries.add(ModBlocks.RED_COAL_BLOCK);

                        entries.add(ModBlocks.GREFFED_COMMAND_SYSTEM);
                        entries.add(ModBlocks.SIMULATION_TELEPORTER);

                        entries.add(ModBlocks.THESTONE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_THESTONE_ORE);

                        entries.add(ModBlocks.IMPURE_ZAROSITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE);
                        entries.add(ModBlocks.IMPURE_ZAROSITE_BLOCK);

                        //EGRORIC
                        entries.add(ModBlocks.EGRORIC_SAPLING);
                        entries.add(ModBlocks.EGRORIC_LEAVES);
                        entries.add(ModBlocks.EGRORIC_LOG);
                        entries.add(ModBlocks.EGRORIC_WOOD);
                        entries.add(ModBlocks.STRIPPED_EGRORIC_LOG);
                        entries.add(ModBlocks.STRIPPED_EGRORIC_WOOD);
                        entries.add(ModBlocks.EGRORIC_PLANKS);
                        entries.add(ModBlocks.EGRORIC_STAIRS);
                        entries.add(ModBlocks.EGRORIC_SLAB);
                        entries.add(ModBlocks.EGRORIC_BUTTON);
                        entries.add(ModBlocks.EGRORIC_PRESSURE_PLATE);
                        entries.add(ModBlocks.EGRORIC_DOOR);
                        entries.add(ModBlocks.EGRORIC_TRAPDOOR);
                        entries.add(ModBlocks.EGRORIC_FENCE);
                        entries.add(ModBlocks.EGRORIC_FENCE_GATE);

                        //OAST
                        entries.add(ModBlocks.OAST_SAPLING);
                        entries.add(ModBlocks.OAST_LEAVES);
                        entries.add(ModBlocks.OAST_LOG);
                        entries.add(ModBlocks.OAST_WOOD);
                        entries.add(ModBlocks.STRIPPED_OAST_LOG);
                        entries.add(ModBlocks.STRIPPED_OAST_WOOD);
                        entries.add(ModBlocks.OAST_PLANKS);
                        entries.add(ModBlocks.OAST_STAIRS);
                        entries.add(ModBlocks.OAST_SLAB);
                        entries.add(ModBlocks.OAST_BUTTON);
                        entries.add(ModBlocks.OAST_PRESSURE_PLATE);
                        entries.add(ModBlocks.OAST_DOOR);
                        entries.add(ModBlocks.OAST_TRAPDOOR);
                        entries.add(ModBlocks.OAST_FENCE);
                        entries.add(ModBlocks.OAST_FENCE_GATE);

                        //SEPHIN
                        entries.add(ModBlocks.SEPHIN_SAPLING);
                        entries.add(ModBlocks.SEPHIN_LEAVES);
                        entries.add(ModBlocks.SEPHIN_LOG);
                        entries.add(ModBlocks.SEPHIN_WOOD);
                        entries.add(ModBlocks.STRIPPED_SEPHIN_LOG);
                        entries.add(ModBlocks.STRIPPED_SEPHIN_WOOD);
                        entries.add(ModBlocks.SEPHIN_PLANKS);
                        entries.add(ModBlocks.SEPHIN_STAIRS);
                        entries.add(ModBlocks.SEPHIN_SLAB);
                        entries.add(ModBlocks.SEPHIN_BUTTON);
                        entries.add(ModBlocks.SEPHIN_PRESSURE_PLATE);
                        entries.add(ModBlocks.SEPHIN_DOOR);
                        entries.add(ModBlocks.SEPHIN_TRAPDOOR);
                        entries.add(ModBlocks.SEPHIN_FENCE);
                        entries.add(ModBlocks.SEPHIN_FENCE_GATE);

                        entries.add(ModBlocks.TORN_BUSH);
                        entries.add(ModBlocks.RED_OSPET);
                        entries.add(ModBlocks.BLUE_OSPET);
                        entries.add(ModBlocks.GREEN_OSPET);
                        entries.add(ModBlocks.YELLOW_OSPET);

                        entries.add(ModItems.TREPASSEUR_SPAWN_EGG);
                        entries.add(ModItems.TICKELER_SPAWN_EGG);
                        entries.add(ModItems.CRAWLER_SPAWN_EGG);


                    }).build());

    public static final ItemGroup FOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheLongStory.MOD_ID, "foodgroup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.foodgroup"))
                    .icon(() -> new ItemStack(ModItems.REDSTONE_APPLE)).entries((displayContext, entries) -> {

                        entries.add(ModItems.EMERALD_APPLE);
                        entries.add(ModItems.IRON_APPLE);
                        entries.add(ModItems.DIAMOND_APPLE);
                        entries.add(ModItems.LAPIS_APPLE);
                        entries.add(ModItems.REDSTONE_APPLE);
                        entries.add(ModItems.AMETHYST_APPLE);


                    }).build());

    public static void registerItemGroups(){
        TheLongStory.LOGGER.info("Registering Item Groups for " + TheLongStory.MOD_ID);
    }

}
