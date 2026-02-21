package net.kindling.tweakfailure.data.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static net.kindling.tweakfailure.impl.index.TweakfailureItems.*;
import static net.kindling.tweakfailure.impl.index.TweakfailureTags.CLEAVERS;
import static net.kindling.tweakfailure.impl.index.TweakfailureTags.MUSIC_DISCS;

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

        getOrCreateTagBuilder(MUSIC_DISCS)
                .add(Items.MUSIC_DISC_5)
                .add(Items.MUSIC_DISC_11)
                .add(Items.MUSIC_DISC_13)
                .add(Items.MUSIC_DISC_CAT)
                .add(Items.MUSIC_DISC_BLOCKS)
                .add(Items.MUSIC_DISC_CHIRP)
                .add(Items.MUSIC_DISC_CREATOR)
                .add(Items.MUSIC_DISC_CREATOR_MUSIC_BOX)
                .add(Items.MUSIC_DISC_FAR)
                .add(Items.MUSIC_DISC_MALL)
                .add(Items.MUSIC_DISC_MELLOHI)
                .add(Items.MUSIC_DISC_OTHERSIDE)
                .add(Items.MUSIC_DISC_PIGSTEP)
                .add(Items.MUSIC_DISC_PRECIPICE)
                .add(Items.MUSIC_DISC_RELIC)
                .add(Items.MUSIC_DISC_STAL)
                .add(Items.MUSIC_DISC_STRAD)
                .add(Items.MUSIC_DISC_WAIT)
                .add(Items.MUSIC_DISC_WARD)
                .add(TALIONIUM)
                .setReplace(false);
    }
}
