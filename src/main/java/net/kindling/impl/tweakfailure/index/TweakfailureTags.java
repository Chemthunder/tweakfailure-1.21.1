package net.kindling.impl.tweakfailure.index;

import net.kindling.impl.tweakfailure.Tweakfailure;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public interface TweakfailureTags {
    TagKey<Item> CLEAVERS = TagKey.of(RegistryKeys.ITEM, Tweakfailure.id("cleavers"));

    static void index() {}
}
