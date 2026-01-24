package net.kindling.impl.tweakfailure.index;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.kindling.impl.tweakfailure.Tweakfailure;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface TweakfailurePotions {
    Potion SILLY_POTION = Registry.register(Registries.POTION, Tweakfailure.id("silly"), new Potion(new StatusEffectInstance(
            TweakfailureEffects.SILLY,
            3600,
            0
    )));

    static void index() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.WATER, // Base ingredient
                    TweakfailureItems.LARD, // Input Ingredient
                    Registries.POTION.getEntry(SILLY_POTION) // output
            );
        });
    }
}
