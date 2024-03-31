package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.datagen.recipe.MaterialProcessingRecipeBuilder;
import net.okamiz.thelongstory.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> THESTONE_SMELTABLES = List.of(ModBlocks.THESTONE_ORE,ModBlocks.DEEPSLATE_THESTONE_ORE,
            ModBlocks.RED_SANDSTONE_THESTONE_ORE,ModBlocks.TORCH_STONE_THESTONE_ORE);
    private static final List<ItemConvertible> IMPURE_ZAROSITE_SMELTABLES = List.of(ModBlocks.IMPURE_ZAROSITE_ORE,ModBlocks.DEEPSLATE_IMPURE_ZAROSITE_ORE,
            ModItems.RAW_IMPURE_ZAROSITE);
    private static final List<ItemConvertible> PANDAZITE_SMELTABLES = List.of(ModBlocks.PANDAZITE_ORE,ModBlocks.DEEPSLATE_PANDAZITE_ORE,
            ModItems.RAW_PANDAZITE, ModBlocks.TORCH_STONE_PANDAZITE_ORE,ModBlocks.RED_SANDSTONE_PANDAZITE_ORE);

    private static final List<ItemConvertible> ODMENTIUM_SMELTABLES = List.of(ModBlocks.ODMENTIUM_ORE,ModBlocks.RED_SANDSTONE_ODMENTIUM_ORE,
            ModItems.RAW_ODMENTIUM);
    private static final List<ItemConvertible> ZAROSITE_SMELTABLES = List.of(ModBlocks.DEEP_ICE_ZAROSITE_ORE);
    private static final List<ItemConvertible> FLUORITE_SMELTABLES = List.of(ModBlocks.DEEP_ICE_FLUORITE_ORE);
    private static final List<ItemConvertible> ICED_STONE = List.of(ModBlocks.ICED_STONE);
    private static final List<ItemConvertible> ICED_COBBLESTONE = List.of(ModBlocks.ICED_COBBLESTONE);
    private static final List<ItemConvertible> ICED_CRACKED_STONE_BRICKS = List.of(ModBlocks.ICED_CRACKED_STONE_BRICKS);
    private static final List<ItemConvertible> ICED_CHISELED_STONE_BRICKS = List.of(ModBlocks.ICED_CHISELED_STONE_BRICKS);
    private static final List<ItemConvertible> ICED_STONE_BRICKS = List.of(ModBlocks.ICED_STONE_BRICKS);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, THESTONE_SMELTABLES, RecipeCategory.MISC, ModItems.THESTONE_DUST,
                0.7f,200,"thestone_dust");
        offerBlasting(exporter, THESTONE_SMELTABLES, RecipeCategory.MISC, ModItems.THESTONE_DUST,
                0.7f,100,"thestone_dust");

        offerSmelting(exporter, IMPURE_ZAROSITE_SMELTABLES, RecipeCategory.MISC, ModItems.IMPURE_ZAROSITE_INGOT,
                0.7f,200,"impure_zarosite_ingot");
        offerBlasting(exporter, IMPURE_ZAROSITE_SMELTABLES, RecipeCategory.MISC, ModItems.IMPURE_ZAROSITE_INGOT,
                0.7f,100,"impure_zarosite_ingot");

        offerSmelting(exporter, PANDAZITE_SMELTABLES, RecipeCategory.MISC, ModItems.PANDAZITE_INGOT,
                0.7f,200,"pandazite_ingot");
        offerBlasting(exporter, PANDAZITE_SMELTABLES, RecipeCategory.MISC, ModItems.PANDAZITE_INGOT,
                0.7f,100,"pandazite_ingot");

        offerSmelting(exporter, ODMENTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ODMENTIUM_INGOT,
                0.7f,200,"odmentium_ingot");
        offerBlasting(exporter, ODMENTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ODMENTIUM_INGOT,
                0.7f,100,"odmentium_ingot");

        offerSmelting(exporter, ZAROSITE_SMELTABLES, RecipeCategory.MISC, ModItems.ZAROSITE_GEMSTONE,
                0.7f,200,"zarosite_gemstone");
        offerBlasting(exporter, ZAROSITE_SMELTABLES, RecipeCategory.MISC, ModItems.ZAROSITE_GEMSTONE,
                0.7f,100,"zarosite_gemstone");

        offerSmelting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLUORITE,
                0.7f,200,"zarosite_gemstone");
        offerBlasting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLUORITE,
                0.7f,100,"zarosite_gemstone");


        offerSmelting(exporter, ICED_STONE, RecipeCategory.MISC, Blocks.STONE,
                0.7f,200,"zarosite_gemstone");
        offerSmelting(exporter, ICED_STONE_BRICKS, RecipeCategory.MISC, Blocks.STONE_BRICKS,
                0.7f,200,"zarosite_gemstone");
        offerSmelting(exporter, ICED_CHISELED_STONE_BRICKS, RecipeCategory.MISC, Blocks.CHISELED_STONE_BRICKS,
                0.7f,200,"zarosite_gemstone");
        offerSmelting(exporter, ICED_CRACKED_STONE_BRICKS, RecipeCategory.MISC, Blocks.CRACKED_STONE_BRICKS,
                0.7f,200,"zarosite_gemstone");
        offerSmelting(exporter, ICED_COBBLESTONE, RecipeCategory.MISC, Blocks.COBBLESTONE,
                0.7f,200,"zarosite_gemstone");



        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.IMPURE_ZAROSITE_INGOT, RecipeCategory.MISC,
                ModBlocks.IMPURE_ZAROSITE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PANDAZITE_NUGGET, RecipeCategory.MISC,
                ModItems.PANDAZITE_INGOT);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ZAROSITE_GEMSTONE, RecipeCategory.MISC,
                ModBlocks.ZAROSITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DRONIUM_INGOT, RecipeCategory.MISC,
                ModBlocks.DRONIUM_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RED_COAL, RecipeCategory.MISC,
                ModBlocks.RED_COAL_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SPIDER_SILK, RecipeCategory.MISC,
                ModBlocks.SPIDER_SILK_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.THESTONE_NUGGET, RecipeCategory.MISC,
                ModItems.THESTONE_INGOT);







        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRUSHED_BONES).input(ModItems.BONE_FRAGMENTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BONE_FRAGMENTS),
                FabricRecipeProvider.conditionsFromItem(ModItems.BONE_FRAGMENTS)).criterion(FabricRecipeProvider.hasItem(ModItems.CRUSHED_BONES),
                FabricRecipeProvider.conditionsFromItem(ModItems.CRUSHED_BONES)).offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRUSHED_BONES, 4).input(ModBlocks.CRUSHED_BONES_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CRUSHED_BONES_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.CRUSHED_BONES_BLOCK)).criterion(FabricRecipeProvider.hasItem(ModItems.CRUSHED_BONES),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CRUSHED_BONES))
                            .offerTo(exporter, new Identifier("crushed_bones_from_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DRONIUM_POWDER, 4).input(ModItems.DRONIUM_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CRUSHED_BONES_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DRONIUM_INGOT)).criterion(FabricRecipeProvider.hasItem(ModItems.DRONIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DRONIUM_POWDER))
                .offerTo(exporter, new Identifier("dronium_powder_from_ingot"));




        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PANDAZITE_INGOT, 9).input(ModBlocks.PANDAZITE_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PANDAZITE_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.PANDAZITE_BLOCK)).criterion(FabricRecipeProvider.hasItem(ModItems.PANDAZITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PANDAZITE_INGOT))
                .offerTo(exporter, new Identifier("pandazite_ingot_from_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PANDAZITE_BLOCK).input(ModItems.PANDAZITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PANDAZITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.PANDAZITE_INGOT)).criterion(FabricRecipeProvider.hasItem(ModBlocks.PANDAZITE_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.PANDAZITE_BLOCK)).offerTo(exporter);




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.THESTONE_INGOT, 1)
                .pattern("DDD")
                .pattern("DII")
                .pattern("II ")
                .input('D', ModItems.THESTONE_DUST)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.THESTONE_DUST),conditionsFromItem(ModItems.THESTONE_DUST))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_DUST)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.RED_COAL, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('X', ModItems.BLOOD_BOTTLE)
                .input('O', Items.COAL)
                .criterion(hasItem(ModItems.BLOOD_BOTTLE),conditionsFromItem(ModItems.BLOOD_BOTTLE))
                .offerTo(exporter, new Identifier("red_coal_craft"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GREEN_SHARD, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('X', ModItems.THESTONE_DUST)
                .input('O', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.THESTONE_DUST),conditionsFromItem(ModItems.THESTONE_DUST))
                .criterion(hasItem(Items.AMETHYST_SHARD),conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier("green_shard_craft"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DRONIUM_INGOT, 1)
                .pattern("XX")
                .pattern("XX")
                .input('X', ModItems.DRONIUM_POWDER)
                .criterion(hasItem(ModItems.DRONIUM_POWDER),conditionsFromItem(ModItems.DRONIUM_POWDER))
                .offerTo(exporter, new Identifier("dronium_ingot_from_powder"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.CRUSHED_BONES_BLOCK, 1)
                .pattern("XX")
                .pattern("XX")
                .input('X', ModItems.CRUSHED_BONES)
                .criterion(hasItem(ModItems.CRUSHED_BONES),conditionsFromItem(ModItems.CRUSHED_BONES))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CRUSHED_BONES_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.EGRORIC_PRESSURE_PLATE, 1)
                .pattern("XX")
                .input('X', ModBlocks.EGRORIC_PLANKS)
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_PRESSURE_PLATE)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ZAROSITE_GEMSTONE, 1)
                .pattern("XX")
                .pattern("XX")
                .input('X', ModItems.ZAROSITE_SHARD)
                .criterion(hasItem(ModItems.ZAROSITE_SHARD),conditionsFromItem(ModItems.ZAROSITE_SHARD))
                .offerTo(exporter, new Identifier("zarosite_gemstone_from_shards"));




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.SIMULATION_TELEPORTER, 1)
                .pattern("XO")
                .input('X', ModBlocks.BROKEN_SIMULATION_TELEPORTER)
                .input('O', ModItems.COMMAND_SYSTEM)
                .criterion(hasItem(ModBlocks.BROKEN_SIMULATION_TELEPORTER),conditionsFromItem(ModBlocks.BROKEN_SIMULATION_TELEPORTER))
                .offerTo(exporter, new Identifier("simulation_teleporter_repair_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.GREFFED_COMMAND_SYSTEM, 1)
                .pattern("XO")
                .input('X', ModBlocks.BROKEN_GREFFED_COMMAND_SYSTEM)
                .input('O', ModItems.COMMAND_SYSTEM)
                .criterion(hasItem(ModBlocks.BROKEN_GREFFED_COMMAND_SYSTEM),conditionsFromItem(ModBlocks.BROKEN_GREFFED_COMMAND_SYSTEM))
                .offerTo(exporter, new Identifier("greffed_command_system_repair_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.TELEPORTATION_REMOTE, 1)
                .pattern("XO")
                .input('X', ModItems.BROKEN_TELEPORTATION_REMOTE)
                .input('O', ModItems.TELEPORTATION_MODULE)
                .criterion(hasItem(ModItems.BROKEN_TELEPORTATION_REMOTE),conditionsFromItem(ModItems.BROKEN_TELEPORTATION_REMOTE))
                .offerTo(exporter, new Identifier("teleportation_remote_repair_craft"));



        // ARMORS


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.THESTONE_BOOTS, 1)
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.THESTONE_INGOT)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.THESTONE_LEGGINGS, 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.THESTONE_INGOT)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.THESTONE_CHESTPLATE, 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModItems.THESTONE_INGOT)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.THESTONE_HELMET, 1)
                .pattern("XXX")
                .pattern("X X")
                .input('X', ModItems.THESTONE_INGOT)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_HELMET)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GREEN_SHARD_BOOTS, 1)
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.GREEN_SHARD)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GREEN_SHARD_LEGGINGS, 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.GREEN_SHARD)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GREEN_SHARD_CHESTPLATE, 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModItems.GREEN_SHARD)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GREEN_SHARD_HELMET, 1)
                .pattern("XXX")
                .pattern("X X")
                .input('X', ModItems.GREEN_SHARD)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_HELMET)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.IMPURE_ZAROSITE_BOOTS, 1)
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.IMPURE_ZAROSITE_HELMET, 1)
                .pattern("XXX")
                .pattern("X X")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.IMPURE_ZAROSITE_LEGGINGS, 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.IMPURE_ZAROSITE_CHESTPLATE, 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_CHESTPLATE)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.ZAROSITE_BOOTS, 1)
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.ZAROSITE_HELMET, 1)
                .pattern("XXX")
                .pattern("X X")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.ZAROSITE_LEGGINGS, 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.ZAROSITE_CHESTPLATE, 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_CHESTPLATE)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.DRONIUM_BOOTS, 1)
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.DRONIUM_INGOT)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.DRONIUM_HELMET, 1)
                .pattern("XXX")
                .pattern("X X")
                .input('X', ModItems.DRONIUM_INGOT)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.DRONIUM_LEGGINGS, 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.DRONIUM_INGOT)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.DRONIUM_CHESTPLATE, 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModItems.DRONIUM_INGOT)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_CHESTPLATE)));
        //-------------------

        // TOOLS

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.THESTONE_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.THESTONE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.THESTONE_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModItems.THESTONE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.THESTONE_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModItems.THESTONE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier("thestone_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.THESTONE_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.THESTONE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.THESTONE_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.THESTONE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier("thestone_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.THESTONE_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.THESTONE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.THESTONE_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModItems.THESTONE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.THESTONE_INGOT),conditionsFromItem(ModItems.THESTONE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THESTONE_SWORD)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GREEN_SHARD_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.GREEN_SHARD)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GREEN_SHARD_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModItems.GREEN_SHARD)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GREEN_SHARD_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModItems.GREEN_SHARD)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier("green_shard_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GREEN_SHARD_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.GREEN_SHARD)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GREEN_SHARD_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.GREEN_SHARD)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier("green_shard_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GREEN_SHARD_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.GREEN_SHARD)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GREEN_SHARD_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModItems.GREEN_SHARD)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.GREEN_SHARD),conditionsFromItem(ModItems.GREEN_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_SHARD_SWORD)));

        // IMPURE_ZAROSITE

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier("impure_zarosite_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier("impure_zarosite_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_BOW, 1)
                .pattern(" OS")
                .pattern("X S")
                .pattern(" OS")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .input('S', Items.STRING)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IMPURE_ZAROSITE_BOW)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.IMPURE_ZAROSITE_BOW, 1)
                .pattern("SO ")
                .pattern("S X")
                .pattern("SO ")
                .input('X', ModItems.IMPURE_ZAROSITE_INGOT)
                .input('O', Items.STICK)
                .input('S', Items.STRING)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT),conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter, new Identifier("impure_zarosite_bow_reverse"));


        // PANDAZITE

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PANDAZITE_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.PANDAZITE_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.PANDAZITE_INGOT),conditionsFromItem(ModItems.PANDAZITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PANDAZITE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PANDAZITE_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModItems.PANDAZITE_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.PANDAZITE_INGOT),conditionsFromItem(ModItems.PANDAZITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PANDAZITE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PANDAZITE_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModItems.PANDAZITE_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.PANDAZITE_INGOT),conditionsFromItem(ModItems.PANDAZITE_INGOT))
                .offerTo(exporter, new Identifier("pandazite_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PANDAZITE_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.PANDAZITE_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.PANDAZITE_INGOT),conditionsFromItem(ModItems.PANDAZITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PANDAZITE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PANDAZITE_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.PANDAZITE_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.PANDAZITE_INGOT),conditionsFromItem(ModItems.PANDAZITE_INGOT))
                .offerTo(exporter, new Identifier("pandazite_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PANDAZITE_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.PANDAZITE_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.PANDAZITE_INGOT),conditionsFromItem(ModItems.PANDAZITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PANDAZITE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PANDAZITE_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModItems.PANDAZITE_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.PANDAZITE_INGOT),conditionsFromItem(ModItems.PANDAZITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PANDAZITE_SWORD)));

// ODMENTIUM

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ODMENTIUM_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.ODMENTIUM_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ODMENTIUM_INGOT),conditionsFromItem(ModItems.ODMENTIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ODMENTIUM_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ODMENTIUM_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModItems.ODMENTIUM_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ODMENTIUM_INGOT),conditionsFromItem(ModItems.ODMENTIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ODMENTIUM_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ODMENTIUM_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModItems.ODMENTIUM_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ODMENTIUM_INGOT),conditionsFromItem(ModItems.ODMENTIUM_INGOT))
                .offerTo(exporter, new Identifier("odmentium_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ODMENTIUM_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.ODMENTIUM_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ODMENTIUM_INGOT),conditionsFromItem(ModItems.ODMENTIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ODMENTIUM_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ODMENTIUM_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.ODMENTIUM_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ODMENTIUM_INGOT),conditionsFromItem(ModItems.ODMENTIUM_INGOT))
                .offerTo(exporter, new Identifier("odmentium_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ODMENTIUM_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.ODMENTIUM_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ODMENTIUM_INGOT),conditionsFromItem(ModItems.ODMENTIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ODMENTIUM_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ODMENTIUM_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModItems.ODMENTIUM_INGOT)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ODMENTIUM_INGOT),conditionsFromItem(ModItems.ODMENTIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ODMENTIUM_SWORD)));



        // FADED_CACTUS

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.FADED_CACTUS_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModBlocks.FADED_CACTUS_PLANKS)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModItems.ODMENTIUM_INGOT),conditionsFromItem(ModItems.ODMENTIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FADED_CACTUS_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.FADED_CACTUS_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModBlocks.FADED_CACTUS_PLANKS)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FADED_CACTUS_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.FADED_CACTUS_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModBlocks.FADED_CACTUS_PLANKS)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier("faded_cactus_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.FADED_CACTUS_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModBlocks.FADED_CACTUS_PLANKS)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FADED_CACTUS_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.FADED_CACTUS_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModBlocks.FADED_CACTUS_PLANKS)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier("faded_cactus_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.FADED_CACTUS_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModBlocks.FADED_CACTUS_PLANKS)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FADED_CACTUS_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.FADED_CACTUS_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModBlocks.FADED_CACTUS_PLANKS)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FADED_CACTUS_SWORD)));


        // TORCH_STONE

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,Items.STONE_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModBlocks.TORCH_STONE)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,Items.STONE_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModBlocks.TORCH_STONE)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,Items.STONE_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModBlocks.TORCH_STONE)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier("stone_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,Items.STONE_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModBlocks.TORCH_STONE)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,Items.STONE_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModBlocks.TORCH_STONE)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier("stone_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,Items.STONE_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModBlocks.TORCH_STONE)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,Items.STONE_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModBlocks.TORCH_STONE)
                .input('O', ModItems.FADED_CACTUS_STICK)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_SWORD)));


        // ZAROSITE

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ZAROSITE_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ZAROSITE_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ZAROSITE_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier("zarosite_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ZAROSITE_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ZAROSITE_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier("zarosite_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ZAROSITE_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ZAROSITE_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModItems.ZAROSITE_GEMSTONE)
                .input('O', Items.STICK)
                .criterion(hasItem(ModItems.ZAROSITE_GEMSTONE),conditionsFromItem(ModItems.ZAROSITE_GEMSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ZAROSITE_SWORD)));


        // DRONIUM

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.DRONIUM_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.DRONIUM_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.DRONIUM_AXE, 1)
                .pattern(" XX")
                .pattern(" OX")
                .pattern(" O ")
                .input('X', ModItems.DRONIUM_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.DRONIUM_AXE, 1)
                .pattern("XX ")
                .pattern("XO ")
                .pattern(" O ")
                .input('X', ModItems.DRONIUM_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier("dronium_axe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.DRONIUM_HOE, 1)
                .pattern(" XX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.DRONIUM_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.DRONIUM_HOE, 1)
                .pattern("XX ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.DRONIUM_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier("dronium_hoe_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.DRONIUM_SHOVEL, 1)
                .pattern(" X ")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.DRONIUM_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.DRONIUM_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModItems.DRONIUM_INGOT)
                .input('O', ModItems.CARBON_STICK)
                .criterion(hasItem(ModItems.DRONIUM_INGOT),conditionsFromItem(ModItems.DRONIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DRONIUM_SWORD)));



        // PURE AMETHYST

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PURE_AMETHYST_SWORD, 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" O ")
                .input('X', ModItems.PURE_AMETHYST_SHARD)
                .input('O', ModItems.PURE_AMETHYST_STICK)
                .criterion(hasItem(ModItems.PURE_AMETHYST_SHARD),conditionsFromItem(ModItems.PURE_AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PURE_AMETHYST_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PURE_AMETHYST_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" O ")
                .pattern(" O ")
                .input('X', ModItems.PURE_AMETHYST_SHARD)
                .input('O', ModItems.PURE_AMETHYST_STICK)
                .criterion(hasItem(ModItems.PURE_AMETHYST_SHARD),conditionsFromItem(ModItems.PURE_AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PURE_AMETHYST_PICKAXE)));


        // -------------------

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_STONE, 4)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', Items.ICE)
                .input('O', Items.STONE)
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier("iced_stone_recipe"));

        createStairsRecipe(ModBlocks.ICED_STONE_STAIRS, Ingredient.ofItems(ModBlocks.ICED_STONE))
                .criterion(hasItem(ModBlocks.ICED_STONE),conditionsFromItem(ModBlocks.ICED_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_STONE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICED_STONE_SLAB, Ingredient.ofItems(ModBlocks.ICED_STONE))
                .criterion(hasItem(ModBlocks.ICED_STONE),conditionsFromItem(ModBlocks.ICED_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_STONE_SLAB)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_STONE_WALL, 4)

                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.ICED_STONE)
                .criterion(hasItem(ModBlocks.ICED_STONE),conditionsFromItem(ModBlocks.ICED_STONE))
                .offerTo(exporter, new Identifier("iced_stone_wall_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_COBBLESTONE, 4)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', Items.ICE)
                .input('O', Items.COBBLESTONE)
                .criterion(hasItem(Items.COBBLESTONE),conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter, new Identifier("iced_cobblestone_recipe"));
        createStairsRecipe(ModBlocks.ICED_COBBLESTONE_STAIRS, Ingredient.ofItems(ModBlocks.ICED_COBBLESTONE))
                .criterion(hasItem(ModBlocks.ICED_COBBLESTONE),conditionsFromItem(ModBlocks.ICED_COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_COBBLESTONE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICED_COBBLESTONE_SLAB, Ingredient.ofItems(ModBlocks.ICED_COBBLESTONE))
                .criterion(hasItem(ModBlocks.ICED_COBBLESTONE),conditionsFromItem(ModBlocks.ICED_COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_COBBLESTONE_SLAB)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_COBBLESTONE_WALL, 4)

                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.ICED_COBBLESTONE)
                .criterion(hasItem(ModBlocks.ICED_COBBLESTONE),conditionsFromItem(ModBlocks.ICED_COBBLESTONE))
                .offerTo(exporter, new Identifier("iced_cobblestone_wall_recipe"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.FADED_CACTUS_STICK, 4)
                .pattern("O")
                .pattern("O")
                .input('O', ModBlocks.FADED_CACTUS_PLANKS)
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier("faded_cactus_stick_recipe"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.FADED_CACTUS_PLANKS, 2)
                .pattern("OO")
                .pattern("OO")
                .input('O', ModBlocks.FADED_CACTUS)
                .criterion(hasItem(ModBlocks.FADED_CACTUS),conditionsFromItem(ModBlocks.FADED_CACTUS))
                .offerTo(exporter, new Identifier("faded_cactus_planks_recipe"));

        createStairsRecipe(ModBlocks.FADED_CACTUS_STAIRS, Ingredient.ofItems(ModBlocks.FADED_CACTUS_PLANKS))
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FADED_CACTUS_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.FADED_CACTUS_SLAB, Ingredient.ofItems(ModBlocks.FADED_CACTUS_PLANKS))
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FADED_CACTUS_SLAB)));

        createDoorRecipe(ModBlocks.FADED_CACTUS_DOOR, Ingredient.ofItems(ModBlocks.FADED_CACTUS_PLANKS))
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FADED_CACTUS_DOOR)));

        createTrapdoorRecipe(ModBlocks.FADED_CACTUS_TRAPDOOR, Ingredient.ofItems(ModBlocks.FADED_CACTUS_PLANKS))
                .criterion(hasItem(ModBlocks.FADED_CACTUS_PLANKS),conditionsFromItem(ModBlocks.FADED_CACTUS_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FADED_CACTUS_TRAPDOOR)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_STONE_BRICKS, 4)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', Items.ICE)
                .input('O', Items.STONE_BRICKS)
                .criterion(hasItem(Items.STONE_BRICKS),conditionsFromItem(Items.STONE_BRICKS))
                .offerTo(exporter, new Identifier("iced_stone_bricks_recipe"));

        createStairsRecipe(ModBlocks.ICED_STONE_BRICKS_STAIRS, Ingredient.ofItems(ModBlocks.ICED_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.ICED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_STONE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_STONE_BRICKS_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICED_STONE_BRICKS_SLAB, Ingredient.ofItems(ModBlocks.ICED_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.ICED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_STONE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_STONE_BRICKS_SLAB)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_STONE_BRICKS_WALL, 4)

                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.ICED_STONE_BRICKS)
                .criterion(hasItem(ModBlocks.ICED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_STONE_BRICKS))
                .offerTo(exporter, new Identifier("iced_stone_bricks_wall_recipe"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_CRACKED_STONE_BRICKS, 4)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', Items.ICE)
                .input('O', Items.CRACKED_STONE_BRICKS)
                .criterion(hasItem(Items.CRACKED_STONE_BRICKS),conditionsFromItem(Items.CRACKED_STONE_BRICKS))
                .offerTo(exporter, new Identifier("iced_cracked_stone_bricks_recipe"));

        createStairsRecipe(ModBlocks.ICED_CRACKED_STONE_BRICKS_STAIRS, Ingredient.ofItems(ModBlocks.ICED_CRACKED_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.ICED_CRACKED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_CRACKED_STONE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_CRACKED_STONE_BRICKS_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICED_CRACKED_STONE_BRICKS_SLAB, Ingredient.ofItems(ModBlocks.ICED_CRACKED_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.ICED_CRACKED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_CRACKED_STONE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_CRACKED_STONE_BRICKS_SLAB)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_CRACKED_STONE_BRICKS_WALL, 4)

                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.ICED_CRACKED_STONE_BRICKS)
                .criterion(hasItem(ModBlocks.ICED_CRACKED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_CRACKED_STONE_BRICKS))
                .offerTo(exporter, new Identifier("iced_cracked_stone_bricks_wall_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_CHISELED_STONE_BRICKS, 4)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', Items.ICE)
                .input('O', Items.CHISELED_STONE_BRICKS)
                .criterion(hasItem(Items.CHISELED_STONE_BRICKS),conditionsFromItem(Items.CHISELED_STONE_BRICKS))
                .offerTo(exporter, new Identifier("iced_chiseled_stone_bricks_recipe"));

        createStairsRecipe(ModBlocks.ICED_CHISELED_STONE_BRICKS_STAIRS, Ingredient.ofItems(ModBlocks.ICED_CHISELED_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.ICED_CHISELED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_CHISELED_STONE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_CHISELED_STONE_BRICKS_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.ICED_CHISELED_STONE_BRICKS_SLAB, Ingredient.ofItems(ModBlocks.ICED_CHISELED_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.ICED_CHISELED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_CHISELED_STONE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ICED_CHISELED_STONE_BRICKS_SLAB)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ICED_CHISELED_STONE_BRICKS_WALL, 4)

                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.ICED_CHISELED_STONE_BRICKS)
                .criterion(hasItem(ModBlocks.ICED_CHISELED_STONE_BRICKS),conditionsFromItem(ModBlocks.ICED_CHISELED_STONE_BRICKS))
                .offerTo(exporter, new Identifier("iced_chiseled_stone_bricks_wall_recipe"));




        createStairsRecipe(ModBlocks.TORCH_STONE_STAIRS, Ingredient.ofItems(ModBlocks.TORCH_STONE))
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TORCH_STONE_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.TORCH_STONE_SLAB, Ingredient.ofItems(ModBlocks.TORCH_STONE))
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TORCH_STONE_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.TORCH_STONE_WALL, 4)
                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.TORCH_STONE)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier("torch_stone_wall_recipe"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.TORCH_STONE_BRICKS, 4)
                .pattern("OO")
                .pattern("OO")
                .input('O', ModBlocks.TORCH_STONE)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier("torch_stone_bricks_recipe"));

        createStairsRecipe(ModBlocks.TORCH_STONE_BRICKS_STAIRS, Ingredient.ofItems(ModBlocks.TORCH_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.TORCH_STONE_BRICKS),conditionsFromItem(ModBlocks.TORCH_STONE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TORCH_STONE_BRICKS_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.TORCH_STONE_BRICKS_SLAB, Ingredient.ofItems(ModBlocks.TORCH_STONE_BRICKS))
                .criterion(hasItem(ModBlocks.TORCH_STONE_BRICKS),conditionsFromItem(ModBlocks.TORCH_STONE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TORCH_STONE_BRICKS_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.TORCH_STONE_BRICKS_WALL, 4)
                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.TORCH_STONE_BRICKS)
                .criterion(hasItem(ModBlocks.TORCH_STONE_BRICKS),conditionsFromItem(ModBlocks.TORCH_STONE_BRICKS))
                .offerTo(exporter, new Identifier("torch_stone_bricks_wall_recipe"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.TORCH_BRICKS, 4)
                .pattern("OO")
                .pattern("OO")
                .input('O', ModBlocks.TORCH_STONE_BRICKS)
                .criterion(hasItem(ModBlocks.TORCH_STONE_BRICKS),conditionsFromItem(ModBlocks.TORCH_STONE_BRICKS))
                .offerTo(exporter, new Identifier("torch_bricks_recipe"));

        createStairsRecipe(ModBlocks.TORCH_BRICKS_STAIRS, Ingredient.ofItems(ModBlocks.TORCH_BRICKS))
                .criterion(hasItem(ModBlocks.TORCH_BRICKS),conditionsFromItem(ModBlocks.TORCH_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TORCH_BRICKS_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.TORCH_BRICKS_SLAB, Ingredient.ofItems(ModBlocks.TORCH_BRICKS))
                .criterion(hasItem(ModBlocks.TORCH_BRICKS),conditionsFromItem(ModBlocks.TORCH_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TORCH_BRICKS_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.TORCH_BRICKS_WALL, 4)
                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.TORCH_BRICKS)
                .criterion(hasItem(ModBlocks.TORCH_BRICKS),conditionsFromItem(ModBlocks.TORCH_BRICKS))
                .offerTo(exporter, new Identifier("torch_bricks_wall_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.TORCH_STONE_PILLAR, 3)
                .pattern("O")
                .pattern("O")
                .pattern("O")
                .input('O', ModBlocks.TORCH_STONE)
                .criterion(hasItem(ModBlocks.TORCH_STONE),conditionsFromItem(ModBlocks.TORCH_STONE))
                .offerTo(exporter, new Identifier("torch_pillar_recipe"));






        createStairsRecipe(ModBlocks.FLUORITE_BLOCK_STAIRS, Ingredient.ofItems(ModBlocks.FLUORITE_BLOCK))
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK),conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLUORITE_BLOCK_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.FLUORITE_BLOCK_SLAB, Ingredient.ofItems(ModBlocks.FLUORITE_BLOCK))
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK),conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLUORITE_BLOCK_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.FLUORITE_BLOCK_WALL, 4)
                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK),conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter, new Identifier("fluorite_block_wall_recipe"));

        createStairsRecipe(ModBlocks.CHISELED_FLUORITE_BLOCK_STAIRS, Ingredient.ofItems(ModBlocks.CHISELED_FLUORITE_BLOCK))
                .criterion(hasItem(ModBlocks.CHISELED_FLUORITE_BLOCK),conditionsFromItem(ModBlocks.CHISELED_FLUORITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CHISELED_FLUORITE_BLOCK_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.CHISELED_FLUORITE_BLOCK_SLAB, Ingredient.ofItems(ModBlocks.CHISELED_FLUORITE_BLOCK))
                .criterion(hasItem(ModBlocks.CHISELED_FLUORITE_BLOCK),conditionsFromItem(ModBlocks.CHISELED_FLUORITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CHISELED_FLUORITE_BLOCK_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.CHISELED_FLUORITE_BLOCK_WALL, 4)
                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.CHISELED_FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.CHISELED_FLUORITE_BLOCK),conditionsFromItem(ModBlocks.CHISELED_FLUORITE_BLOCK))
                .offerTo(exporter, new Identifier("chiseled_fluorite_block_wall_recipe"));

        createStairsRecipe(ModBlocks.FLUORITE_BRICKS_STAIRS, Ingredient.ofItems(ModBlocks.FLUORITE_BRICKS))
                .criterion(hasItem(ModBlocks.FLUORITE_BRICKS),conditionsFromItem(ModBlocks.FLUORITE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLUORITE_BRICKS_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.FLUORITE_BRICKS_SLAB, Ingredient.ofItems(ModBlocks.FLUORITE_BRICKS))
                .criterion(hasItem(ModBlocks.FLUORITE_BRICKS),conditionsFromItem(ModBlocks.FLUORITE_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLUORITE_BRICKS_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.FLUORITE_BRICKS_WALL, 4)
                .pattern("OOO")
                .pattern("OOO")
                .input('O', ModBlocks.FLUORITE_BRICKS)
                .criterion(hasItem(ModBlocks.FLUORITE_BRICKS),conditionsFromItem(ModBlocks.FLUORITE_BRICKS))
                .offerTo(exporter, new Identifier("fluorite_bricks_wall_recipe"));




        // APPLES



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.EMERALD_APPLE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('O', Items.APPLE)
                .input('X', Items.EMERALD)
                .criterion(hasItem(Items.APPLE),conditionsFromItem(Items.APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_APPLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.IRON_APPLE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('O', Items.APPLE)
                .input('X', Items.IRON_INGOT)
                .criterion(hasItem(Items.APPLE),conditionsFromItem(Items.APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IRON_APPLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIAMOND_APPLE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('O', Items.APPLE)
                .input('X', Items.DIAMOND)
                .criterion(hasItem(Items.APPLE),conditionsFromItem(Items.APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DIAMOND_APPLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.LAPIS_APPLE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('O', Items.APPLE)
                .input('X', Items.LAPIS_LAZULI)
                .criterion(hasItem(Items.APPLE),conditionsFromItem(Items.APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_APPLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.REDSTONE_APPLE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('O', Items.APPLE)
                .input('X', Items.REDSTONE)
                .criterion(hasItem(Items.APPLE),conditionsFromItem(Items.APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_APPLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.AMETHYST_APPLE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('O', Items.APPLE)
                .input('X', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.APPLE),conditionsFromItem(Items.APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.AMETHYST_APPLE)));



        // -------------------------



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.EMPTY_CORE, 1)
                .pattern("XAX")
                .pattern("AOA")
                .pattern("XAX")
                .input('O', Items.DIAMOND)
                .input('X', Items.IRON_INGOT)
                .input('A', ModItems.THESTONE_DUST)
                .criterion(hasItem(Items.DIAMOND),conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier("empty_core_craft"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.FLAMING_SHARD, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('X', ModItems.PURE_AMETHYST_SHARD)
                .input('O', Items.BLAZE_POWDER)
                .criterion(hasItem(ModItems.FLAMING_SHARD),conditionsFromItem(ModItems.FLAMING_SHARD))
                .offerTo(exporter, new Identifier("flaming_shard_craft"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.AMETHYST_CORE, 2)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XAX")
                .input('X', Items.AMETHYST_SHARD)
                .input('O', ModItems.EMPTY_CORE)
                .input('A', ModItems.AMETHYST_CORE)
                .criterion(hasItem(Items.AMETHYST_SHARD),conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(ModItems.EMPTY_CORE),conditionsFromItem(ModItems.EMPTY_CORE))
                .offerTo(exporter, new Identifier("amethyst_core_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.FLAMING_CORE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', ModItems.FLAMING_SHARD)
                .input('O', ModItems.AMETHYST_CORE)
                .criterion(hasItem(ModItems.FLAMING_SHARD),conditionsFromItem(ModItems.FLAMING_SHARD))
                .criterion(hasItem(ModItems.AMETHYST_CORE),conditionsFromItem(ModItems.AMETHYST_CORE))
                .offerTo(exporter, new Identifier("flaming_core_craft"));






// KEYS

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.AMETHYST_KEY, 1)
                .pattern("  X")
                .pattern("XX ")
                .pattern(" X ")
                .input('X', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.AMETHYST_SHARD),conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier("amethyst_key_craft"));




// TECH BLOCKS

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.MATERIAL_PROCESSOR, 1)
                .pattern("XXX")
                .pattern("NON")
                .pattern("XXX")
                .input('X', ModItems.IRON_PLATE)
                .input('O', Items.REDSTONE)
                .input('N', Items.COBBLED_DEEPSLATE)
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier("material_processor_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.AMETHYST_PROCESSOR, 1)
                .pattern("AXA")
                .pattern("XOX")
                .pattern("AXA")
                .input('X', ModItems.IRON_PLATE)
                .input('O', ModItems.AMETHYST_CORE)
                .input('A', ModItems.DRONIUM_POWDER)
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier("amethyst_processor_craft"));





        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CARBON_INGOT, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('X', Items.COAL)
                .input('O', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier("carbon_ingot_craft"));




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.WOODEN_PLATE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', Items.STICK)
                .input('O', Items.OAK_PLANKS)
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier("wooden_plate_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.IRON_PLATE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', Items.IRON_NUGGET)
                .input('O', ModItems.WOODEN_PLATE)
                .criterion(hasItem(ModItems.WOODEN_PLATE),conditionsFromItem(ModItems.WOODEN_PLATE))
                .offerTo(exporter, new Identifier("iron_plate_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIAMOND_PLATE, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('X', Items.DIAMOND)
                .input('O', ModItems.IRON_PLATE)
                .criterion(hasItem(ModItems.IRON_PLATE),conditionsFromItem(ModItems.IRON_PLATE))
                .offerTo(exporter, new Identifier("diamond_plate_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.EMERALD_PLATE, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('X', Items.EMERALD)
                .input('O', ModItems.DIAMOND_PLATE)
                .criterion(hasItem(ModItems.DIAMOND_PLATE),conditionsFromItem(ModItems.DIAMOND_PLATE))
                .offerTo(exporter, new Identifier("emerald_plate_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CARBON_PLATE, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('X', ModItems.CARBON_INGOT)
                .input('O', ModItems.EMERALD_PLATE)
                .criterion(hasItem(ModItems.EMERALD_PLATE),conditionsFromItem(ModItems.EMERALD_PLATE))
                .offerTo(exporter, new Identifier("carbon_plate_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.NETHERITE_PLATE, 1)
                .pattern("OX")
                .input('X', Items.NETHERITE_INGOT)
                .input('O', ModItems.CARBON_PLATE)
                .criterion(hasItem(ModItems.CARBON_PLATE),conditionsFromItem(ModItems.CARBON_PLATE))
                .offerTo(exporter, new Identifier("netherite_plate_craft"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.POWER_STAR, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('O', Items.NETHER_STAR)
                .input('X', Items.END_CRYSTAL)
                .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POWER_STAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.COMMAND_SYSTEM, 1)
                .pattern("RXR")
                .pattern("XOX")
                .pattern("RXR")
                .input('O', ModItems.POWER_STAR)
                .input('X', ModItems.IRON_PLATE)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(ModItems.POWER_STAR),conditionsFromItem(ModItems.POWER_STAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COMMAND_SYSTEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,Items.EXPERIENCE_BOTTLE, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('O', Items.GLASS_BOTTLE)
                .input('X', ModItems.THESTONE_DUST)
                .criterion(hasItem(ModItems.THESTONE_DUST),conditionsFromItem(ModItems.THESTONE_DUST))
                .offerTo(exporter, new Identifier(getRecipeName(Items.EXPERIENCE_BOTTLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.POTION_RECEPTACLE, 1)
                .pattern(" X ")
                .pattern("XOX")
                .pattern(" X ")
                .input('O', Items.EXPERIENCE_BOTTLE)
                .input('X', Items.GLASS)
                .criterion(hasItem(Items.EXPERIENCE_BOTTLE),conditionsFromItem(Items.EXPERIENCE_BOTTLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POTION_RECEPTACLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.SOUL_CONTAINER, 1)
                .pattern("BXB")
                .pattern("XOX")
                .pattern("BXB")
                .input('O', Items.TOTEM_OF_UNDYING)
                .input('X', ModItems.IRON_PLATE)
                .input('B', ModItems.THESTONE_DUST)
                .criterion(hasItem(ModItems.THESTONE_DUST),conditionsFromItem(ModItems.THESTONE_DUST))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOUL_CONTAINER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.POTION_CORE, 1)
                .pattern("ABC")
                .pattern("HOD")
                .pattern("GFE")
                .input('O', ModItems.POTION_RECEPTACLE)
                .input('A', Items.GLISTERING_MELON_SLICE)
                .input('B', Items.FERMENTED_SPIDER_EYE)
                .input('C', Items.GHAST_TEAR)
                .input('D', Items.RABBIT_FOOT)
                .input('E', Items.GOLDEN_CARROT)
                .input('F', Items.PHANTOM_MEMBRANE)
                .input('G', Items.MAGMA_CREAM)
                .input('H', Items.NETHER_WART)
                .criterion(hasItem(ModItems.POTION_RECEPTACLE),conditionsFromItem(ModItems.POTION_RECEPTACLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POTION_CORE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.PURE_AMETHYST_STICK, 1)
                .pattern("OX")
                .input('X', Items.STICK)
                .input('O', ModItems.PURE_AMETHYST_SHARD)
                .criterion(hasItem(ModItems.PURE_AMETHYST_SHARD),conditionsFromItem(ModItems.PURE_AMETHYST_SHARD))
                .offerTo(exporter, new Identifier("pure_amethyst_stick_craft"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.PURE_AMETHYST_STICK, 1)
                .pattern("XO")
                .input('X', Items.STICK)
                .input('O', ModItems.PURE_AMETHYST_SHARD)
                .criterion(hasItem(ModItems.PURE_AMETHYST_SHARD),conditionsFromItem(ModItems.PURE_AMETHYST_SHARD))
                .offerTo(exporter, new Identifier("pure_amethyst_stick_craft_reverse"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.FLAMING_STICK, 1)
                .pattern("OX")
                .input('X', Items.STICK)
                .input('O', ModItems.FLAMING_SHARD)
                .criterion(hasItem(ModItems.FLAMING_SHARD),conditionsFromItem(ModItems.FLAMING_SHARD))
                .offerTo(exporter, new Identifier("flaming_stick_craft"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.FLAMING_STICK, 1)
                .pattern("XO")
                .input('X', Items.STICK)
                .input('O', ModItems.FLAMING_SHARD)
                .criterion(hasItem(ModItems.FLAMING_SHARD),conditionsFromItem(ModItems.FLAMING_SHARD))
                .offerTo(exporter, new Identifier("flaming_stick_craft_reverse"));


        // -------- GREFFED SYSTEMS

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.GREFFED_COMMAND_SYSTEM, 1)
                .pattern("BXB")
                .pattern("XOX")
                .pattern("BAB")
                .input('O', ModItems.COMMAND_SYSTEM)
                .input('X', ModItems.IRON_PLATE)
                .input('A', ModItems.POTION_CORE)
                .input('B', ModItems.EMERALD_PLATE)
                .criterion(hasItem(ModItems.COMMAND_SYSTEM),conditionsFromItem(ModItems.COMMAND_SYSTEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GREFFED_COMMAND_SYSTEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.SIMULATION_TELEPORTER, 1)
                .pattern("BCB")
                .pattern("XOX")
                .pattern("BAB")
                .input('O', ModItems.COMMAND_SYSTEM)
                .input('X', ModItems.POWER_MODULE)
                .input('A', ModItems.TELEPORTATION_MODULE)
                .input('B', ModItems.CARBON_PLATE)
                .input('C', ModItems.DIMENSION_PATTERN)
                .criterion(hasItem(ModItems.COMMAND_SYSTEM),conditionsFromItem(ModItems.COMMAND_SYSTEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SIMULATION_TELEPORTER)));

        // MATERIALS

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.POWER_MODULE, 1)
                .pattern("XAX")
                .pattern("XBX")
                .pattern("XAX")
                .input('X', ModItems.IRON_PLATE)
                .input('A', Items.REDSTONE_TORCH)
                .input('B', Items.REPEATER)
                .criterion(hasItem(Items.REDSTONE),conditionsFromItem(ModItems.IRON_PLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POWER_MODULE)));

        // MATERIALS

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.TELEPORTATION_MODULE, 1)
                .pattern("XAX")
                .pattern("CBC")
                .pattern("XAX")
                .input('X', ModItems.CARBON_PLATE)
                .input('C', ModItems.POWER_MODULE)
                .input('B', ModItems.THESTONE_INGOT)
                .input('A', Items.ENDER_EYE)
                .criterion(hasItem(Items.ENDER_EYE),conditionsFromItem(ModItems.CARBON_PLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TELEPORTATION_MODULE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.TELEPORTATION_REMOTE, 1)
                .pattern("XAX")
                .pattern("XBX")
                .pattern("XAX")
                .input('X', ModItems.IRON_PLATE)
                .input('B', ModItems.THESTONE_INGOT)
                .input('A', ModItems.TELEPORTATION_MODULE)
                .criterion(hasItem(Items.ENDER_EYE),conditionsFromItem(ModItems.CARBON_PLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TELEPORTATION_REMOTE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.MOB_CAPSULE, 1)
                .pattern(" A ")
                .pattern("XBX")
                .pattern(" A ")
                .input('X', ModItems.DIAMOND_PLATE)
                .input('B', ModItems.TELEPORTATION_MODULE)
                .input('A', Items.LAPIS_LAZULI)
                .criterion(hasItem(Items.LAPIS_LAZULI),conditionsFromItem(ModItems.DIAMOND_PLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MOB_CAPSULE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIMENSION_PATTERN, 1)
                .pattern(" C ")
                .pattern("BXA")
                .input('X', Items.PAPER)
                .input('A', Items.GRASS_BLOCK)
                .input('B', Items.END_STONE)
                .input('C', Items.NETHERRACK)
                .criterion(hasItem(Items.GRASS_BLOCK),conditionsFromItem(ModItems.DIMENSION_PATTERN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DIMENSION_PATTERN)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.CARBON_STICK, 4)
                .pattern("X")
                .pattern("X")
                .input('X', ModItems.CARBON_INGOT)
                .criterion(hasItem(ModItems.CARBON_INGOT),conditionsFromItem(ModItems.CARBON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CARBON_STICK)));





        // ----------------

        //EGRORIC RECIPES --------------------------

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.EGRORIC_BUTTON, 1).input(ModBlocks.EGRORIC_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_BUTTON),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_BUTTON))
                .offerTo(exporter, new Identifier("egroric_button"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EGRORIC_PLANKS, 4).input(ModBlocks.EGRORIC_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_LOG)).criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier("egroric_planks_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EGRORIC_PLANKS, 4).input(ModBlocks.EGRORIC_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_WOOD)).criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier("egroric_planks_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EGRORIC_PLANKS, 4).input(ModBlocks.STRIPPED_EGRORIC_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_EGRORIC_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_EGRORIC_LOG)).criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier("egroric_planks_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EGRORIC_PLANKS, 4).input(ModBlocks.STRIPPED_EGRORIC_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_EGRORIC_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_EGRORIC_WOOD)).criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier("egroric_planks_from_stripped_wood"));


        createStairsRecipe(ModBlocks.EGRORIC_STAIRS, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EGRORIC_SLAB, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_SLAB)));

        createFenceGateRecipe(ModBlocks.EGRORIC_FENCE_GATE, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_FENCE_GATE)));

        createFenceRecipe(ModBlocks.EGRORIC_FENCE, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_FENCE)));

        createDoorRecipe(ModBlocks.EGRORIC_DOOR, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_DOOR)));

        createTrapdoorRecipe(ModBlocks.EGRORIC_TRAPDOOR, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_TRAPDOOR)));


        //OAST RECIPES --------------------------

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.OAST_BUTTON, 1).input(ModBlocks.OAST_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OAST_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.OAST_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.OAST_BUTTON),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.OAST_BUTTON))
                .offerTo(exporter, new Identifier("oast_button"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAST_PLANKS, 4).input(ModBlocks.OAST_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OAST_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.OAST_LOG)).criterion(FabricRecipeProvider.hasItem(ModBlocks.OAST_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier("oast_planks_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAST_PLANKS, 4).input(ModBlocks.OAST_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OAST_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.OAST_WOOD)).criterion(FabricRecipeProvider.hasItem(ModBlocks.OAST_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier("oast_planks_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAST_PLANKS, 4).input(ModBlocks.STRIPPED_OAST_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_OAST_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_OAST_LOG)).criterion(FabricRecipeProvider.hasItem(ModBlocks.OAST_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier("oast_planks_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAST_PLANKS, 4).input(ModBlocks.STRIPPED_OAST_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_OAST_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_OAST_WOOD)).criterion(FabricRecipeProvider.hasItem(ModBlocks.OAST_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier("oast_planks_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.OAST_PRESSURE_PLATE, 1)
                .pattern("XX")
                .input('X', ModBlocks.OAST_PLANKS)
                .criterion(hasItem(ModBlocks.OAST_PLANKS),conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OAST_PRESSURE_PLATE)));


        createStairsRecipe(ModBlocks.OAST_STAIRS, Ingredient.ofItems(ModBlocks.OAST_PLANKS))
                .criterion(hasItem(ModBlocks.OAST_PLANKS),conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OAST_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.OAST_SLAB, Ingredient.ofItems(ModBlocks.OAST_PLANKS))
                .criterion(hasItem(ModBlocks.OAST_PLANKS),conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OAST_SLAB)));

        createFenceGateRecipe(ModBlocks.OAST_FENCE_GATE, Ingredient.ofItems(ModBlocks.OAST_PLANKS))
                .criterion(hasItem(ModBlocks.OAST_PLANKS),conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OAST_FENCE_GATE)));

        createFenceRecipe(ModBlocks.OAST_FENCE, Ingredient.ofItems(ModBlocks.OAST_PLANKS))
                .criterion(hasItem(ModBlocks.OAST_PLANKS),conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OAST_FENCE)));

        createDoorRecipe(ModBlocks.OAST_DOOR, Ingredient.ofItems(ModBlocks.OAST_PLANKS))
                .criterion(hasItem(ModBlocks.OAST_PLANKS),conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OAST_DOOR)));

        createTrapdoorRecipe(ModBlocks.OAST_TRAPDOOR, Ingredient.ofItems(ModBlocks.OAST_PLANKS))
                .criterion(hasItem(ModBlocks.OAST_PLANKS),conditionsFromItem(ModBlocks.OAST_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OAST_TRAPDOOR)));


        //SEPHIN RECIPES -------------------------

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SEPHIN_BUTTON, 1).input(ModBlocks.SEPHIN_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SEPHIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SEPHIN_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.SEPHIN_BUTTON),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SEPHIN_BUTTON))
                .offerTo(exporter, new Identifier("sephin_button"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEPHIN_PLANKS, 4).input(ModBlocks.SEPHIN_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SEPHIN_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SEPHIN_LOG)).criterion(FabricRecipeProvider.hasItem(ModBlocks.SEPHIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier("sephin_planks_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEPHIN_PLANKS, 4).input(ModBlocks.SEPHIN_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SEPHIN_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SEPHIN_WOOD)).criterion(FabricRecipeProvider.hasItem(ModBlocks.SEPHIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier("sephin_planks_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEPHIN_PLANKS, 4).input(ModBlocks.STRIPPED_SEPHIN_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_SEPHIN_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_SEPHIN_LOG)).criterion(FabricRecipeProvider.hasItem(ModBlocks.SEPHIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier("sephin_planks_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEPHIN_PLANKS, 4).input(ModBlocks.STRIPPED_SEPHIN_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_SEPHIN_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_SEPHIN_WOOD)).criterion(FabricRecipeProvider.hasItem(ModBlocks.SEPHIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier("sephin_planks_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.SEPHIN_PRESSURE_PLATE, 1)
                .pattern("XX")
                .input('X', ModBlocks.SEPHIN_PLANKS)
                .criterion(hasItem(ModBlocks.SEPHIN_PLANKS),conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEPHIN_PRESSURE_PLATE)));


        createStairsRecipe(ModBlocks.SEPHIN_STAIRS, Ingredient.ofItems(ModBlocks.SEPHIN_PLANKS))
                .criterion(hasItem(ModBlocks.SEPHIN_PLANKS),conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEPHIN_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SEPHIN_SLAB, Ingredient.ofItems(ModBlocks.SEPHIN_PLANKS))
                .criterion(hasItem(ModBlocks.SEPHIN_PLANKS),conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEPHIN_SLAB)));

        createFenceGateRecipe(ModBlocks.SEPHIN_FENCE_GATE, Ingredient.ofItems(ModBlocks.SEPHIN_PLANKS))
                .criterion(hasItem(ModBlocks.SEPHIN_PLANKS),conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEPHIN_FENCE_GATE)));

        createFenceRecipe(ModBlocks.SEPHIN_FENCE, Ingredient.ofItems(ModBlocks.SEPHIN_PLANKS))
                .criterion(hasItem(ModBlocks.SEPHIN_PLANKS),conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEPHIN_FENCE)));

        createDoorRecipe(ModBlocks.SEPHIN_DOOR, Ingredient.ofItems(ModBlocks.SEPHIN_PLANKS))
                .criterion(hasItem(ModBlocks.SEPHIN_PLANKS),conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEPHIN_DOOR)));

        createTrapdoorRecipe(ModBlocks.SEPHIN_TRAPDOOR, Ingredient.ofItems(ModBlocks.SEPHIN_PLANKS))
                .criterion(hasItem(ModBlocks.SEPHIN_PLANKS),conditionsFromItem(ModBlocks.SEPHIN_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEPHIN_TRAPDOOR)));


        //KIWI RECIPES -------------------------

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.KIWI_BUTTON, 1).input(ModBlocks.KIWI_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.KIWI_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.KIWI_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.KIWI_BUTTON),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.KIWI_BUTTON))
                .offerTo(exporter, new Identifier("kiwi_button"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KIWI_PLANKS, 4).input(ModBlocks.KIWI_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.KIWI_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.KIWI_LOG)).criterion(FabricRecipeProvider.hasItem(ModBlocks.KIWI_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier("kiwi_planks_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KIWI_PLANKS, 4).input(ModBlocks.KIWI_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.KIWI_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.KIWI_WOOD)).criterion(FabricRecipeProvider.hasItem(ModBlocks.KIWI_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier("kiwi_planks_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KIWI_PLANKS, 4).input(ModBlocks.STRIPPED_KIWI_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_KIWI_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_KIWI_LOG)).criterion(FabricRecipeProvider.hasItem(ModBlocks.KIWI_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier("kiwi_planks_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KIWI_PLANKS, 4).input(ModBlocks.STRIPPED_KIWI_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_KIWI_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_KIWI_WOOD)).criterion(FabricRecipeProvider.hasItem(ModBlocks.KIWI_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier("kiwi_planks_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.KIWI_PRESSURE_PLATE, 1)
                .pattern("XX")
                .input('X', ModBlocks.KIWI_PLANKS)
                .criterion(hasItem(ModBlocks.KIWI_PLANKS),conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KIWI_PRESSURE_PLATE)));


        createStairsRecipe(ModBlocks.KIWI_STAIRS, Ingredient.ofItems(ModBlocks.KIWI_PLANKS))
                .criterion(hasItem(ModBlocks.KIWI_PLANKS),conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KIWI_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.KIWI_SLAB, Ingredient.ofItems(ModBlocks.KIWI_PLANKS))
                .criterion(hasItem(ModBlocks.KIWI_PLANKS),conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KIWI_SLAB)));

        createFenceGateRecipe(ModBlocks.KIWI_FENCE_GATE, Ingredient.ofItems(ModBlocks.KIWI_PLANKS))
                .criterion(hasItem(ModBlocks.KIWI_PLANKS),conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KIWI_FENCE_GATE)));

        createFenceRecipe(ModBlocks.KIWI_FENCE, Ingredient.ofItems(ModBlocks.KIWI_PLANKS))
                .criterion(hasItem(ModBlocks.KIWI_PLANKS),conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KIWI_FENCE)));

        createDoorRecipe(ModBlocks.KIWI_DOOR, Ingredient.ofItems(ModBlocks.KIWI_PLANKS))
                .criterion(hasItem(ModBlocks.KIWI_PLANKS),conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KIWI_DOOR)));

        createTrapdoorRecipe(ModBlocks.KIWI_TRAPDOOR, Ingredient.ofItems(ModBlocks.KIWI_PLANKS))
                .criterion(hasItem(ModBlocks.KIWI_PLANKS),conditionsFromItem(ModBlocks.KIWI_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KIWI_TRAPDOOR)));








        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RED_DYE, 1).input(ModBlocks.RED_OSPET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.RED_OSPET),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.RED_OSPET)).criterion(FabricRecipeProvider.hasItem(Items.RED_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.RED_DYE))
                .offerTo(exporter, new Identifier("red_dye_from_red_ospet"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BLUE_DYE, 1).input(ModBlocks.BLUE_OSPET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_OSPET),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_OSPET)).criterion(FabricRecipeProvider.hasItem(Items.BLUE_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.BLUE_DYE))
                .offerTo(exporter, new Identifier("blue_dye_from_blue_ospet"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GREEN_DYE, 1).input(ModBlocks.GREEN_OSPET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GREEN_OSPET),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GREEN_OSPET)).criterion(FabricRecipeProvider.hasItem(Items.GREEN_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.GREEN_DYE))
                .offerTo(exporter, new Identifier("green_dye_from_green_ospet"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1).input(ModBlocks.YELLOW_OSPET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.YELLOW_OSPET),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.YELLOW_OSPET)).criterion(FabricRecipeProvider.hasItem(Items.YELLOW_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.YELLOW_DYE))
                .offerTo(exporter, new Identifier("yellow_dye_from_yellow_ospet"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1).input(ModBlocks.YELLOW_PHYGELUS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.YELLOW_PHYGELUS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.YELLOW_PHYGELUS)).criterion(FabricRecipeProvider.hasItem(Items.YELLOW_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.YELLOW_DYE))
                .offerTo(exporter, new Identifier("yellow_dye_from_yellow_phygelus"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PINK_DYE, 1).input(ModBlocks.PINK_PHYGELUS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PINK_PHYGELUS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.PINK_PHYGELUS)).criterion(FabricRecipeProvider.hasItem(Items.PINK_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.PINK_DYE))
                .offerTo(exporter, new Identifier("pink_dye_from_pink_phygelus"));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1).input(ModBlocks.TORN_FLOWER)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TORN_FLOWER),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.TORN_FLOWER)).criterion(FabricRecipeProvider.hasItem(Items.YELLOW_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.YELLOW_DYE))
                .offerTo(exporter, new Identifier("yellow_dye_from_torn_flower"));


            new MaterialProcessingRecipeBuilder(Items.COAL, ModItems.RED_COAL, 1)
                    .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                    .offerTo(exporter);

        new MaterialProcessingRecipeBuilder(ModItems.IMPURE_ZAROSITE_INGOT, ModItems.DRONIUM_INGOT, 1)
                .criterion(hasItem(ModItems.IMPURE_ZAROSITE_INGOT), conditionsFromItem(ModItems.IMPURE_ZAROSITE_INGOT))
                .offerTo(exporter);

        new MaterialProcessingRecipeBuilder(ModItems.THESTONE_DUST, ModItems.DRONIUM_POWDER, 1)
                .criterion(hasItem(ModItems.THESTONE_DUST), conditionsFromItem(ModItems.THESTONE_DUST))
                .offerTo(exporter);


    }
}
