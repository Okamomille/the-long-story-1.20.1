package net.okamiz.thelongstory.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;

public class ModModelLayers {
    public static final EntityModelLayer TREPASSEUR =
            new EntityModelLayer(new Identifier(TheLongStory.MOD_ID, "trepasseur"), "main");

    public static final EntityModelLayer TICKELER =
            new EntityModelLayer(new Identifier(TheLongStory.MOD_ID, "tickeler"), "main");

    public static final EntityModelLayer CRAWLER =
            new EntityModelLayer(new Identifier(TheLongStory.MOD_ID, "crawler"), "main");

    public static final EntityModelLayer TOOKI =
            new EntityModelLayer(new Identifier(TheLongStory.MOD_ID, "tooki"), "main");

    public static final EntityModelLayer COWSMIC =
            new EntityModelLayer(new Identifier(TheLongStory.MOD_ID, "cowsmic"), "main");
}
