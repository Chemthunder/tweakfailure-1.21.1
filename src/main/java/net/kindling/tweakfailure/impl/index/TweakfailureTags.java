package net.kindling.tweakfailure.impl.index;

import net.kindling.tweakfailure.impl.Tweakfailure;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public interface TweakfailureTags {
    TagKey<Item> CLEAVERS = TagKey.of(RegistryKeys.ITEM, Tweakfailure.id("cleavers"));
    TagKey<Item> MUSIC_DISCS = TagKey.of(RegistryKeys.ITEM, Tweakfailure.id("music_discs"));

    static void index() {}
}
