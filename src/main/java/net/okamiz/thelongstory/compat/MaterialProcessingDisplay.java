package net.okamiz.thelongstory.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.okamiz.thelongstory.recipe.MaterialProcessingRecipe;
import net.okamiz.thelongstory.screen.MaterialProcessorScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaterialProcessingDisplay extends BasicDisplay {
    public MaterialProcessingDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public MaterialProcessingDisplay(MaterialProcessingRecipe recipe) {
        super(getInputList(recipe), List.of(EntryIngredient.of(EntryStacks.of(recipe.getOutput(null)))));
    }

    private static List<EntryIngredient> getInputList(MaterialProcessingRecipe recipe) {
        if(recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(0)));
        return list;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MaterialProcessingCategory.MATERIAL_PROCESSING;
    }
}
