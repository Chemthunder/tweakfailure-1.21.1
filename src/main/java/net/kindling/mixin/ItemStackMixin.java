package net.kindling.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.kindling.impl.tweakfailure.index.TweakfailureTags;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @ModifyReturnValue(method = "getMaxCount", at = @At("RETURN"))
    private int maxCountReplacer(int original) {
        ItemStack stack = (ItemStack) (Object) this;

        if (stack.isIn(TweakfailureTags.MUSIC_DISCS)) {
            return 16;
        }

        return original;
    }
}
