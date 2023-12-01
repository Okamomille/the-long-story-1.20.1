package net.okamiz.thelongstory.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> THESTONE_SMELTABLES = List.of(ModBlocks.THESTONE_ORE,ModBlocks.DEEPSLATE_THESTONE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, THESTONE_SMELTABLES, RecipeCategory.MISC, ModItems.THESTONE_DUST,
                0.7f,200,"thestone_dust");
        offerBlasting(exporter, THESTONE_SMELTABLES, RecipeCategory.MISC, ModItems.THESTONE_DUST,
                0.7f,200,"thestone_dust");

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.EGRORIC_BUTTON, 4).input(ModBlocks.EGRORIC_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.EGRORIC_BUTTON),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EGRORIC_BUTTON))
                .offerTo(exporter, new Identifier("egroric_button"));


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


        createStairsRecipe(ModBlocks.EGRORIC_STAIRS, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_STAIRS)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EGRORIC_STAIRS, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_SLAB)));

        createFenceGateRecipe(ModBlocks.EGRORIC_STAIRS, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_FENCE_GATE)));

        createFenceRecipe(ModBlocks.EGRORIC_STAIRS, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_FENCE)));

        createDoorRecipe(ModBlocks.EGRORIC_DOOR, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_DOOR)));

        createTrapdoorRecipe(ModBlocks.EGRORIC_TRAPDOOR, Ingredient.ofItems(ModBlocks.EGRORIC_PLANKS))
                .criterion(hasItem(ModBlocks.EGRORIC_PLANKS),conditionsFromItem(ModBlocks.EGRORIC_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EGRORIC_TRAPDOOR)));

    }
}
