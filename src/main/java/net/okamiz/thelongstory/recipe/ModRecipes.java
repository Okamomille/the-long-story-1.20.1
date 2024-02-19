package net.okamiz.thelongstory.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TheLongStory.MOD_ID, MaterialProcessingRecipe.Serializer.ID),
                MaterialProcessingRecipe.Serializer.INSTANCE);

        Registry.register(Registries.RECIPE_TYPE, new Identifier(TheLongStory.MOD_ID, MaterialProcessingRecipe.Type.ID),
                MaterialProcessingRecipe.Type.INSTANCE);


    }
}
