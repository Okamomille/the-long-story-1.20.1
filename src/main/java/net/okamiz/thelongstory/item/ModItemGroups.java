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


                        entries.add(ModItems.RED_COAL);
                        entries.add(ModItems.THESTONE_INGOT);
                        entries.add(ModItems.THESTONE_DUST);
                        entries.add(ModItems.THESTONE_NUGGET);

                        entries.add(ModItems.RAW_IMPURE_ZAROSITE);
                        entries.add(ModItems.IMPURE_ZAROSITE_INGOT);

                        entries.add(ModItems.RAW_PANDAZITE);
                        entries.add(ModItems.PANDAZITE_INGOT);
                        entries.add(ModItems.PANDAZITE_NUGGET);

                        entries.add(ModItems.RAW_ODMENTIUM);
                        entries.add(ModItems.ODMENTIUM_INGOT);

                        entries.add(ModItems.CARBON_INGOT);

                        entries.add(ModItems.ZAROSITE_GEMSTONE);
                        entries.add(ModItems.ZAROSITE_SHARD);

                        entries.add(ModItems.GREEN_SHARD);
                        entries.add(ModItems.PURE_AMETHYST_SHARD);
                        entries.add(ModItems.FLAMING_SHARD);

                        entries.add(ModItems.DRONIUM_INGOT);
                        entries.add(ModItems.DRONIUM_POWDER);

                        entries.add(ModItems.FLUORITE);

                        entries.add(ModBlocks.THESTONE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_THESTONE_ORE);
                        entries.add(ModBlocks.TORCH_STONE_THESTONE_ORE);
                        entries.add(ModBlocks.RED_SANDSTONE_THESTONE_ORE);

                        entries.add(ModBlocks.IMPURE_ZAROSITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE);
                        entries.add(ModBlocks.IMPURE_ZAROSITE_BLOCK);

                        entries.add(ModBlocks.PANDAZITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PANDAZITE_ORE);
                        entries.add(ModBlocks.TORCH_STONE_PANDAZITE_ORE);
                        entries.add(ModBlocks.RED_SANDSTONE_PANDAZITE_ORE);
                        entries.add(ModBlocks.PANDAZITE_BLOCK);

                        entries.add(ModBlocks.ODMENTIUM_ORE);
                        entries.add(ModBlocks.RED_SANDSTONE_ODMENTIUM_ORE);

                        entries.add(ModBlocks.DEEP_ICE_ZAROSITE_ORE);
                        entries.add(ModBlocks.ZAROSITE_BLOCK);
                        entries.add(ModBlocks.DEEP_ICE_FLUORITE_ORE);
                        entries.add(ModBlocks.DRONIUM_BLOCK);


                        entries.add(ModBlocks.CRUSHED_BONES_BLOCK);
                        entries.add(ModBlocks.MOLD_BLOCK);
                        entries.add(ModBlocks.SPIDER_SILK_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_PILLAR);
                        entries.add(ModBlocks.RED_COAL_BLOCK);
                        entries.add(ModBlocks.IMPURE_GLITCHED_BLOCK);
                        entries.add(ModBlocks.PURE_GLITCHED_BLOCK);

                        entries.add(ModBlocks.DEEP_ICE);
                        entries.add(ModBlocks.FROSTED_ICE);
                        entries.add(ModBlocks.TORCH_SAND);
                        entries.add(ModBlocks.TORCH_PINK_SAND);

                        entries.add(ModBlocks.CARBON_BLOCK);
                        entries.add(ModBlocks.CHISELED_CARBON_BLOCK);
                        entries.add(ModBlocks.CARBON_BRICKS);
                        entries.add(ModBlocks.CARBON_TILES);


                        entries.add(ModBlocks.FLUORITE_PILLAR);
                        entries.add(ModBlocks.FLUORITE_BLOCK);
                        entries.add(ModBlocks.FLUORITE_BLOCK_STAIRS);
                        entries.add(ModBlocks.FLUORITE_BLOCK_SLAB);
                        entries.add(ModBlocks.FLUORITE_BLOCK_WALL);

                        entries.add(ModBlocks.CHISELED_FLUORITE_BLOCK);
                        entries.add(ModBlocks.CHISELED_FLUORITE_BLOCK_STAIRS);
                        entries.add(ModBlocks.CHISELED_FLUORITE_BLOCK_SLAB);
                        entries.add(ModBlocks.CHISELED_FLUORITE_BLOCK_WALL);

                        entries.add(ModBlocks.FLUORITE_BRICKS);
                        entries.add(ModBlocks.FLUORITE_BRICKS_STAIRS);
                        entries.add(ModBlocks.FLUORITE_BRICKS_SLAB);
                        entries.add(ModBlocks.FLUORITE_BRICKS_WALL);

                        entries.add(ModBlocks.STONED_MAGMA_BLOCK);
                        entries.add(ModBlocks.COLD_STONED_MAGMA_BLOCK);

                        entries.add(ModBlocks.TORCH_STONE_PILLAR);
                        entries.add(ModBlocks.TORCH_STONE);
                        entries.add(ModBlocks.TORCH_STONE_STAIRS);
                        entries.add(ModBlocks.TORCH_STONE_SLAB);
                        entries.add(ModBlocks.TORCH_STONE_WALL);

                        entries.add(ModBlocks.TORCH_STONE_BRICKS);
                        entries.add(ModBlocks.TORCH_STONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.TORCH_STONE_BRICKS_SLAB);
                        entries.add(ModBlocks.TORCH_STONE_BRICKS_WALL);

                        entries.add(ModBlocks.TORCH_BRICKS);
                        entries.add(ModBlocks.TORCH_BRICKS_STAIRS);
                        entries.add(ModBlocks.TORCH_BRICKS_SLAB);
                        entries.add(ModBlocks.TORCH_BRICKS_WALL);



                        entries.add(ModBlocks.ICED_STONE);
                        entries.add(ModBlocks.ICED_STONE_STAIRS);
                        entries.add(ModBlocks.ICED_STONE_SLAB);
                        entries.add(ModBlocks.ICED_STONE_WALL);

                        entries.add(ModBlocks.ICED_COBBLESTONE);
                        entries.add(ModBlocks.ICED_COBBLESTONE_STAIRS);
                        entries.add(ModBlocks.ICED_COBBLESTONE_SLAB);
                        entries.add(ModBlocks.ICED_COBBLESTONE_WALL);

                        entries.add(ModBlocks.ICED_STONE_BRICKS);
                        entries.add(ModBlocks.ICED_STONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.ICED_STONE_BRICKS_SLAB);
                        entries.add(ModBlocks.ICED_STONE_BRICKS_WALL);

                        entries.add(ModBlocks.ICED_CRACKED_STONE_BRICKS);
                        entries.add(ModBlocks.ICED_CRACKED_STONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.ICED_CRACKED_STONE_BRICKS_SLAB);
                        entries.add(ModBlocks.ICED_CRACKED_STONE_BRICKS_WALL);

                        entries.add(ModBlocks.ICED_CHISELED_STONE_BRICKS);
                        entries.add(ModBlocks.ICED_CHISELED_STONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.ICED_CHISELED_STONE_BRICKS_SLAB);
                        entries.add(ModBlocks.ICED_CHISELED_STONE_BRICKS_WALL);

                        entries.add(ModBlocks.LAB_TILES);
                        entries.add(ModBlocks.LAB_TILES_STAIRS);
                        entries.add(ModBlocks.LAB_TILES_SLAB);
                        entries.add(ModBlocks.LAB_TILES_WALL);

                        entries.add(ModBlocks.CORRUPTED_LAB_TILES);
                        entries.add(ModBlocks.CORRUPTED_LAB_TILES_STAIRS);
                        entries.add(ModBlocks.CORRUPTED_LAB_TILES_SLAB);
                        entries.add(ModBlocks.CORRUPTED_LAB_TILES_WALL);


                        entries.add(ModBlocks.FADED_CACTUS_PLANKS);
                        entries.add(ModBlocks.FADED_CACTUS_STAIRS);
                        entries.add(ModBlocks.FADED_CACTUS_SLAB);
                        entries.add(ModBlocks.FADED_CACTUS_DOOR);
                        entries.add(ModBlocks.FADED_CACTUS_TRAPDOOR);


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

                        //KIWI
                        entries.add(ModBlocks.KIWI_SAPLING);
                        entries.add(ModBlocks.KIWI_LEAVES);
                        entries.add(ModBlocks.KIWI_LOG);
                        entries.add(ModBlocks.KIWI_WOOD);
                        entries.add(ModBlocks.STRIPPED_KIWI_LOG);
                        entries.add(ModBlocks.STRIPPED_KIWI_WOOD);
                        entries.add(ModBlocks.KIWI_PLANKS);
                        entries.add(ModBlocks.KIWI_STAIRS);
                        entries.add(ModBlocks.KIWI_SLAB);
                        entries.add(ModBlocks.KIWI_BUTTON);
                        entries.add(ModBlocks.KIWI_PRESSURE_PLATE);
                        entries.add(ModBlocks.KIWI_DOOR);
                        entries.add(ModBlocks.KIWI_TRAPDOOR);
                        entries.add(ModBlocks.KIWI_FENCE);
                        entries.add(ModBlocks.KIWI_FENCE_GATE);


                        entries.add(ModBlocks.FADED_CACTUS);

                        entries.add(ModBlocks.TORN_BUSH);
                        entries.add(ModBlocks.TORN_FLOWER);

                        entries.add(ModBlocks.BULBO_FLOWER);

                        entries.add(ModBlocks.PINK_PHYGELUS);
                        entries.add(ModBlocks.YELLOW_PHYGELUS);

                        entries.add(ModBlocks.RED_OSPET);
                        entries.add(ModBlocks.BLUE_OSPET);
                        entries.add(ModBlocks.GREEN_OSPET);
                        entries.add(ModBlocks.YELLOW_OSPET);


                    }).build());


    public static final ItemGroup TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheLongStory.MOD_ID, "toolsgroup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.toolsgroup"))
                    .icon(() -> new ItemStack(ModItems.ZAROSITE_SWORD)).entries((displayContext, entries) -> {


                        //SWORDS
                        entries.add(ModItems.FADED_CACTUS_SWORD);
                        entries.add(ModItems.THESTONE_SWORD);
                        entries.add(ModItems.ODMENTIUM_SWORD);
                        entries.add(ModItems.GREEN_SHARD_SWORD);
                        entries.add(ModItems.IMPURE_ZAROSITE_SWORD);
                        entries.add(ModItems.PANDAZITE_SWORD);
                        entries.add(ModItems.ZAROSITE_SWORD);
                        entries.add(ModItems.DRONIUM_SWORD);
                        entries.add(ModItems.PURE_AMETHYST_SWORD);


                        //PICKAXES
                        entries.add(ModItems.FADED_CACTUS_PICKAXE);
                        entries.add(ModItems.THESTONE_PICKAXE);
                        entries.add(ModItems.ODMENTIUM_PICKAXE);
                        entries.add(ModItems.GREEN_SHARD_PICKAXE);
                        entries.add(ModItems.IMPURE_ZAROSITE_PICKAXE);
                        entries.add(ModItems.PANDAZITE_PICKAXE);
                        entries.add(ModItems.ZAROSITE_PICKAXE);
                        entries.add(ModItems.DRONIUM_PICKAXE);
                        entries.add(ModItems.PURE_AMETHYST_PICKAXE);

                        //AXES
                        entries.add(ModItems.FADED_CACTUS_AXE);
                        entries.add(ModItems.THESTONE_AXE);
                        entries.add(ModItems.ODMENTIUM_AXE);
                        entries.add(ModItems.GREEN_SHARD_AXE);
                        entries.add(ModItems.IMPURE_ZAROSITE_AXE);
                        entries.add(ModItems.PANDAZITE_AXE);
                        entries.add(ModItems.ZAROSITE_AXE);
                        entries.add(ModItems.DRONIUM_AXE);

                        //SHOVELS
                        entries.add(ModItems.FADED_CACTUS_SHOVEL);
                        entries.add(ModItems.THESTONE_SHOVEL);
                        entries.add(ModItems.ODMENTIUM_SHOVEL);
                        entries.add(ModItems.GREEN_SHARD_SHOVEL);
                        entries.add(ModItems.IMPURE_ZAROSITE_SHOVEL);
                        entries.add(ModItems.PANDAZITE_SHOVEL);
                        entries.add(ModItems.ZAROSITE_SHOVEL);
                        entries.add(ModItems.DRONIUM_SHOVEL);

                        //HOES
                        entries.add(ModItems.FADED_CACTUS_HOE);
                        entries.add(ModItems.THESTONE_HOE);
                        entries.add(ModItems.ODMENTIUM_HOE);
                        entries.add(ModItems.GREEN_SHARD_HOE);
                        entries.add(ModItems.IMPURE_ZAROSITE_HOE);
                        entries.add(ModItems.PANDAZITE_HOE);
                        entries.add(ModItems.ZAROSITE_HOE);
                        entries.add(ModItems.DRONIUM_HOE);

                        //BOWS
                        entries.add(ModItems.IMPURE_ZAROSITE_BOW);

                        //ARMORS
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

                        entries.add(ModItems.ZAROSITE_HELMET);
                        entries.add(ModItems.ZAROSITE_CHESTPLATE);
                        entries.add(ModItems.ZAROSITE_LEGGINGS);
                        entries.add(ModItems.ZAROSITE_BOOTS);

                        entries.add(ModItems.DRONIUM_HELMET);
                        entries.add(ModItems.DRONIUM_CHESTPLATE);
                        entries.add(ModItems.DRONIUM_LEGGINGS);
                        entries.add(ModItems.DRONIUM_BOOTS);



                    }).build());



    public static final ItemGroup MISC_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheLongStory.MOD_ID, "miscgroup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.miscgroup"))
                    .icon(() -> new ItemStack(ModItems.TELEPORTATION_REMOTE)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.LOCKED_AMETHYST_CORE);
                        entries.add(ModBlocks.BROKEN_GREFFED_COMMAND_SYSTEM);
                        entries.add(ModBlocks.BROKEN_SIMULATION_TELEPORTER);

                        entries.add(ModBlocks.GREFFED_COMMAND_SYSTEM);
                        entries.add(ModBlocks.SIMULATION_TELEPORTER);
                        entries.add(ModBlocks.MATERIAL_PROCESSOR);
                        entries.add(ModBlocks.AMETHYST_PROCESSOR);
                        //entries.add(ModBlocks.RED_COAL_GENERATOR);


                        //ITEMS
                        entries.add(ModItems.INFESTED_FLESH);
                        entries.add(ModItems.BONE_FRAGMENTS);
                        entries.add(ModItems.CRUSHED_BONES);
                        entries.add(ModItems.BLOOD_BOTTLE);
                        entries.add(ModItems.SPIDER_SILK);

                        entries.add(ModItems.WOODEN_PLATE);
                        entries.add(ModItems.IRON_PLATE);
                        entries.add(ModItems.DIAMOND_PLATE);
                        entries.add(ModItems.EMERALD_PLATE);
                        entries.add(ModItems.CARBON_PLATE);
                        entries.add(ModItems.NETHERITE_PLATE);

                        entries.add(ModItems.AMETHYST_KEY);

                        entries.add(ModItems.FADED_CACTUS_STICK);
                        entries.add(ModItems.CARBON_STICK);
                        entries.add(ModItems.PURE_AMETHYST_STICK);
                        entries.add(ModItems.FLAMING_STICK);
                        entries.add(ModItems.EMPTY_CORE);
                        entries.add(ModItems.AMETHYST_CORE);
                        entries.add(ModItems.FLAMING_CORE);

                        entries.add(ModItems.DIMENSION_PATTERN);
                        entries.add(ModItems.COMMAND_SYSTEM);
                        entries.add(ModItems.POWER_MODULE);
                        entries.add(ModItems.TELEPORTATION_MODULE);

                        entries.add(ModItems.POTION_RECEPTACLE);
                        entries.add(ModItems.POTION_CORE);

                        entries.add(ModItems.BROKEN_TELEPORTATION_REMOTE);
                        entries.add(ModItems.TELEPORTATION_REMOTE);
                        entries.add(ModItems.MOB_CAPSULE);

                        entries.add(ModItems.POWER_STAR);
                        entries.add(ModItems.SOUL_CONTAINER);
                        entries.add(ModItems.SOUL_CONTAINER_REGENERATION);
                        entries.add(ModItems.SOUL_CONTAINER_FIRE_RESISTANCE);
                        entries.add(ModItems.SOUL_CONTAINER_JUMP_BOOST);
                        entries.add(ModItems.SOUL_CONTAINER_DOLPHIN_GRACE);
                        entries.add(ModItems.SOUL_CONTAINER_NIGHT_VISION);
                        entries.add(ModItems.SOUL_CONTAINER_RESISTANCE);
                        entries.add(ModItems.SOUL_CONTAINER_HASTE);
                        entries.add(ModItems.SOUL_CONTAINER_SLOW_FALLING);
                        entries.add(ModItems.SOUL_CONTAINER_SATURATION);

                        entries.add(ModItems.AMETHYST_MINION_SPAWN_EGG);
                        entries.add(ModItems.TREPASSEUR_SPAWN_EGG);
                        entries.add(ModItems.TICKELER_SPAWN_EGG);
                        entries.add(ModItems.CRAWLER_SPAWN_EGG);
                        entries.add(ModItems.TOOKI_SPAWN_EGG);
                        entries.add(ModItems.COWSMIC_SPAWN_EGG);
                        entries.add(ModItems.BREEDY_SPAWN_EGG);


                    }).build());



    public static final ItemGroup FOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheLongStory.MOD_ID, "foodgroup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.foodgroup"))
                    .icon(() -> new ItemStack(ModItems.REDSTONE_APPLE)).entries((displayContext, entries) -> {

                        entries.add(ModItems.VITALY_SEEDS);
                        entries.add(ModItems.VITALY_FRUIT);
                        entries.add(ModItems.SWEET_PEAR_SEEDS);
                        entries.add(ModItems.SWEET_PEAR);
                        entries.add(ModItems.TORN_CARROT);

                        entries.add(ModItems.EMERALD_APPLE);
                        entries.add(ModItems.IRON_APPLE);
                        entries.add(ModItems.DIAMOND_APPLE);
                        entries.add(ModItems.LAPIS_APPLE);
                        entries.add(ModItems.REDSTONE_APPLE);
                        entries.add(ModItems.AMETHYST_APPLE);
                        entries.add(ModItems.BREEDY_FLESH);
                        entries.add(ModItems.TOOKI_MEAT);
                        entries.add(ModItems.COOKED_TOOKI_MEAT);


                    }).build());

    public static void registerItemGroups(){
        TheLongStory.LOGGER.info("Registering Item Groups for " + TheLongStory.MOD_ID);
    }

}