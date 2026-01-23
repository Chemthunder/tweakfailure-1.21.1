package net.kindling.data.resources;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import static net.kindling.tweakfailure.index.TweakfailureItems.*;

public class TweakModelGen extends FabricModelProvider {
    public TweakModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(ALLAY_PENDANT, Models.GENERATED);
        generator.register(LARD, Models.GENERATED);

        generator.register(FLINT_CLEAVER, Models.HANDHELD);
        generator.register(IRON_CLEAVER, Models.HANDHELD);
        generator.register(GOLD_CLEAVER, Models.HANDHELD);
        generator.register(DIAMOND_CLEAVER, Models.HANDHELD);
        generator.register(NETHERITE_CLEAVER, Models.HANDHELD);
    }
}
