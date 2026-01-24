package net.kindling.impl.tweakfailure.effect;

import net.kindling.api.effect.StatusEffectBackground;
import net.kindling.impl.tweakfailure.Tweakfailure;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

public class SillyEffect extends StatusEffect implements StatusEffectBackground {
    public SillyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public Identifier smallInventorySprite() {
        return Tweakfailure.id("container/inventory/silly_small");
    }

    @Override
    public Identifier largeInventorySprite() {
        return Tweakfailure.id("container/inventory/silly_large");
    }

    @Override
    public Identifier hudSprite() {
        return Tweakfailure.id("hud/silly_bg");
    }
}
