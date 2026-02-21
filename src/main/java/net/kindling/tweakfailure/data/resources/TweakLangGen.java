package net.kindling.tweakfailure.data.resources;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.kindling.tweakfailure.impl.index.TweakfailureItems.*;

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
        builder.add(TALIONIUM, "Music Disc");
        builder.add("item.tweakfailure.talionium.desc", "4kio - TALIONIUM");

        builder.add(WHITE_CUSHION_ITEM, "White Cushion");
        builder.add(RED_CUSHION_ITEM, "Red Cushion");
        builder.add(PURPLE_CUSHION_ITEM, "Purple Cushion");
        builder.add(MAGENTA_CUSHION_ITEM, "Magenta Cushion");
        builder.add(GREEN_CUSHION_ITEM, "Green Cushion");
        builder.add(BLACK_CUSHION_ITEM, "Black Cushion");
        builder.add(PINK_CUSHION_ITEM, "Pink Cushion");
        builder.add(CYAN_CUSHION_ITEM, "Cyan Cushion");
        builder.add(BLUE_CUSHION_ITEM, "Blue Cushion");
        builder.add(ORANGE_CUSHION_ITEM, "Orange Cushion");
        builder.add(LIGHT_BLUE_CUSHION_ITEM, "Light Blue Cushion");
        builder.add(LIME_CUSHION_ITEM, "Lime Cushion");
        builder.add(LIGHT_GRAY_CUSHION_ITEM, "Light Gray Cushion");
        builder.add(GRAY_CUSHION_ITEM, "Gray Cushion");
        builder.add(BROWN_CUSHION_ITEM, "Brown Cushion");
        builder.add(YELLOW_CUSHION_ITEM, "Yellow Cushion");

        // misc
        builder.add("effect.tweakfailure.silly", "Silly");

        builder.add("item.minecraft.splash_potion.effect.silly", "Splash Potion of Silliness");
        builder.add("item.minecraft.potion.effect.silly", "Potion of Silliness");
        builder.add("item.minecraft.lingering_potion.effect.silly", "Lingering Potion of Silliness");
        builder.add("item.minecraft.tipped_arrow.effect.silly", "Tipped Arrow of Silliness");
    }
}
