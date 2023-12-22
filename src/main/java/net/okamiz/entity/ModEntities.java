package net.okamiz.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.tick.Tick;
import net.okamiz.entity.custom.TickelerEntity;
import net.okamiz.entity.custom.TrepasseurEntity;
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

}
