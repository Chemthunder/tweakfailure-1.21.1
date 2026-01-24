package net.kindling.data.resources;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.kindling.impl.tweakfailure.index.TweakfailureItems.*;

public class TweakLangGen extends FabricLanguageProvider {
    public TweakLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder builder) {

        // items
        builder.add(FLINT_CLEAVER, "Flint Cleaver");
        builder.add(IRON_CLEAVER, "Iron Cleaver");
        builder.add(GOLD_CLEAVER, "Gold Cleaver");
        builder.add(DIAMOND_CLEAVER, "Diamond Cleaver");
        builder.add(NETHERITE_CLEAVER, "Netherite Cleaver");

        builder.add(ALLAY_PENDANT, "Allay Pendant");
        builder.add(LARD, "Lard");

//        builder.add(BOOMCAN, "Boomcan");
//        builder.add("tooltip.pipebomb", "Legally distinct from Pipe Bombs");

        builder.add("effect.tweakfailure.silly", "Silly");
        builder.add("item.minecraft.splash_potion.effect.silly", "Splash Potion of Silliness");
        builder.add("item.minecraft.potion.effect.silly", "Potion of Silliness");
        builder.add("item.minecraft.lingering_potion.effect.silly", "Lingering Potion of Silliness");
        builder.add("item.minecraft.tipped_arrow.effect.silly", "Tipped Arrow of Silliness");
    }
}
