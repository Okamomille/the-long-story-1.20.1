package net.okamiz.thelongstory.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.entity.custom.*;

public class ModEntitiesAttributes {

    public static void registerEntitiesAttributes(){
        TheLongStory.LOGGER.info("Registering Entities Attributes for " + TheLongStory.MOD_ID);

        FabricDefaultAttributeRegistry.register(ModEntities.TREPASSEUR, TrepasseurEntity.createTrepasseurAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TICKELER, TickelerEntity.createTickelerAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER, CrawlerEntity.createCrawlerAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TOOKI, TookiEntity.createTookiAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BUMBO, BumboEntity.createBumboAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.COWSMIC, CowsmicEntity.createCowsmicAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BREEDY, BreedyEntity.createBreedyAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.AMETHYST_GOLEM, AmethystGolemEntity.createAmethystGolemAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.AMETHYST_MINION, AmethystMinionEntity.createAmethystMinionAttributes());
    }
}
