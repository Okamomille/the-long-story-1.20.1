package net.okamiz.thelongstory.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.entity.custom.CrawlerEntity;
import net.okamiz.thelongstory.entity.custom.TickelerEntity;
import net.okamiz.thelongstory.entity.custom.TookiEntity;
import net.okamiz.thelongstory.entity.custom.TrepasseurEntity;
import net.okamiz.thelongstory.TheLongStory;

public class ModEntities {
    public static void registerModEntities() {
        TheLongStory.LOGGER.info("Registering Entities for " + TheLongStory.MOD_ID);
    }

    public static final EntityType<TrepasseurEntity> TREPASSEUR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TheLongStory.MOD_ID, "trepasseur"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,TrepasseurEntity::new)
                    .dimensions(EntityDimensions.fixed(0.65f,2f)).build());

    public static final EntityType<TickelerEntity> TICKELER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TheLongStory.MOD_ID, "tickeler"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TickelerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f,2f)).build());

    public static final EntityType<CrawlerEntity> CRAWLER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TheLongStory.MOD_ID, "crawler"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CrawlerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f,0.8f)).build());

    public static final EntityType<TookiEntity> TOOKI = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TheLongStory.MOD_ID, "tooki"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,TookiEntity::new)
                    .dimensions(EntityDimensions.fixed(0.55f,0.5f)).build());

}
