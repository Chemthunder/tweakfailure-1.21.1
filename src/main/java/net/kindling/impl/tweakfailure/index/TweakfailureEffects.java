package net.kindling.impl.tweakfailure.index;

import net.kindling.impl.tweakfailure.Tweakfailure;
import net.kindling.impl.tweakfailure.effect.SillyEffect;
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
