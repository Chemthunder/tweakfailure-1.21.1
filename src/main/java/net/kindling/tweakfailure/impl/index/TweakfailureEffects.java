package net.kindling.tweakfailure.impl.index;

import net.kindling.tweakfailure.impl.Tweakfailure;
import net.kindling.tweakfailure.impl.effect.SillyEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public interface TweakfailureEffects {
    RegistryEntry<StatusEffect> SILLY = create("silly", new SillyEffect(StatusEffectCategory.BENEFICIAL, 0xaf00b8));

    private static RegistryEntry<StatusEffect> create(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Tweakfailure.id(name), effect);
    }

    static void index() {
        //
    }
}
