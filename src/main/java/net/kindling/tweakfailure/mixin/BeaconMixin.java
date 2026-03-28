package net.kindling.tweakfailure.mixin;

import net.kindling.tweakfailure.impl.index.TweakfailureTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BeaconBlockEntity.class)
public class BeaconMixin {
    @Redirect(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
            )
    )
    private static boolean redirectIsOfBedrock(BlockState state, Block block) {
        return state.isIn(TweakfailureTags.BEACON_TRANSPARENT);
    }
}
