package net.okamiz.thelongstory.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.recipe.MaterialProcessingRecipe;
import net.okamiz.thelongstory.screen.MaterialProcessorScreen;

public class TheLongStoryREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new MaterialProcessingCategory());

        registry.addWorkstations(MaterialProcessingCategory.MATERIAL_PROCESSING, EntryStacks.of(ModBlocks.MATERIAL_PROCESSOR));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(MaterialProcessingRecipe.class, MaterialProcessingRecipe.Type.INSTANCE,
                MaterialProcessingDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25),
                MaterialProcessorScreen.class,
                MaterialProcessingCategory.MATERIAL_PROCESSING);
    }
}
