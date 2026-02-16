package net.kindling.data.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static net.kindling.impl.tweakfailure.index.TweakfailureItems.*;
import static net.kindling.impl.tweakfailure.index.TweakfailureTags.CLEAVERS;

public class TweakItemTagGen extends FabricTagProvider.ItemTagProvider {
    public TweakItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(CLEAVERS)
                .add(FLINT_CLEAVER)
                .add(IRON_CLEAVER)
                .add(GOLD_CLEAVER)
                .add(DIAMOND_CLEAVER)
                .add(NETHERITE_CLEAVER)
                .setReplace(false);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .addTag(CLEAVERS)
                .setReplace(false);

        getOrCreateTagBuilder(ItemTags.AXES)
                .addTag(CLEAVERS)
                .setReplace(false);

        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .addTag(CLEAVERS)
                .setReplace(false);
    }
}
