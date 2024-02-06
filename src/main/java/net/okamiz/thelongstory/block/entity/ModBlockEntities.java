package net.okamiz.thelongstory.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.block.entity.custom.GreffedCommandSystemBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<GreffedCommandSystemBlockEntity> GREFFED_COMMAND_SYSTEM_BLOCK_ENTITY_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(TheLongStory.MOD_ID, "greffed_command_system_be"),
                    FabricBlockEntityTypeBuilder.create(GreffedCommandSystemBlockEntity::new,
                            ModBlocks.GREFFED_COMMAND_SYSTEM).build());

    public static final BlockEntityType<MaterialProcessorBlockEntity> MATERIAL_PROCESSOR_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(TheLongStory.MOD_ID, "material_processor_be"),
                    FabricBlockEntityTypeBuilder.create(MaterialProcessorBlockEntity::new,
                            ModBlocks.MATERIAL_PROCESSOR).build());

    public static void registerBlockEntities(){
        TheLongStory.LOGGER.info("Registering BlockEntities for " + TheLongStory.MOD_ID);
    }
}
