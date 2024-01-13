package net.okamiz.thelongstory.world.biome;

import net.okamiz.thelongstory.TheLongStory;
import net.okamiz.thelongstory.world.biome.surface.ModMaterialRules;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, TheLongStory.MOD_ID, ModMaterialRules.makeRules());
    }
}
