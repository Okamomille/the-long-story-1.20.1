package net.okamiz.thelongstory.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.okamiz.thelongstory.entity.custom.CrawlerEntity;
import net.okamiz.thelongstory.entity.custom.TickelerEntity;
import net.okamiz.thelongstory.entity.custom.TrepasseurEntity;

public class ModEntitiesAttributes {

    public static void registerEntitiesAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.TREPASSEUR, TrepasseurEntity.createTrepasseurAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TICKELER, TickelerEntity.createTickelerAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER, CrawlerEntity.createCrawlerAttributes());
    }
}
