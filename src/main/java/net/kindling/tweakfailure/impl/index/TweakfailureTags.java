package net.kindling.tweakfailure.impl.index;

import net.kindling.tweakfailure.impl.Tweakfailure;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public interface TweakfailureTags {
    TagKey<Item> CLEAVERS = TagKey.of(RegistryKeys.ITEM, Tweakfailure.id("cleavers"));
    TagKey<Item> MUSIC_DISCS = TagKey.of(RegistryKeys.ITEM, Tweakfailure.id("music_discs"));

    TagKey<Block> BEACON_TRANSPARENT = TagKey.of(RegistryKeys.BLOCK, Tweakfailure.id("beacon_transparent"));

    static void index() {}
}
