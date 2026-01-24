package net.kindling.mixin.client;

import net.kindling.api.effect.StatusEffectBackground;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
    Mixin by n1tr0nr on GitHub
    from Nitrogen
    I DO NOT OWN THIS CODE
 */

@Mixin(AbstractInventoryScreen.class)
public abstract class AbstractInventoryScreenMixin<T extends ScreenHandler> extends HandledScreen<T> {
    @Shadow
    @Final
    private static Identifier EFFECT_BACKGROUND_LARGE_TEXTURE;

    @Shadow @Final private static Identifier EFFECT_BACKGROUND_SMALL_TEXTURE;

    public AbstractInventoryScreenMixin(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Inject(method = "drawStatusEffectBackgrounds", at = @At("HEAD"), cancellable = true)
    private void nitrogen$drawStatusEffectBackgrounds(DrawContext context, int x, int height, Iterable<StatusEffectInstance> statusEffects, boolean wide, CallbackInfo ci){
        int i = this.y;

        for(StatusEffectInstance statusEffectInstance : statusEffects) {
            if (statusEffectInstance.getEffectType().value() instanceof StatusEffectBackground background){
                if (wide) {
                    context.drawGuiTexture(background.largeInventorySprite(), x, i, 120, 32);
                } else {
                    context.drawGuiTexture(background.smallInventorySprite(), x, i, 32, 32);
                }
            } else {
                if (wide) {
                    context.drawGuiTexture(EFFECT_BACKGROUND_LARGE_TEXTURE, x, i, 120, 32);
                } else {
                    context.drawGuiTexture(EFFECT_BACKGROUND_SMALL_TEXTURE, x, i, 32, 32);
                }
            }

            i += height;
        }
        ci.cancel();
    }
}