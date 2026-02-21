package net.kindling.tweakfailure.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.kindling.tweakfailure.impl.Tweakfailure;
import net.kindling.tweakfailure.impl.entity.SeatEntity;
import net.kindling.tweakfailure.impl.index.TweakfailureEntities;
import net.kindling.tweakfailure.impl.index.TweakfailureItems;
import net.kindling.tweakfailure.impl.index.TweakfailureTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow
    @Nullable
    public abstract LivingEntity getAttacker();

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }


    @WrapOperation(method = "dropLoot", at = @At(value = "INVOKE", target = "Lnet/minecraft/loot/LootTable;generateLoot(Lnet/minecraft/loot/context/LootContextParameterSet;JLjava/util/function/Consumer;)V"))
    private void doubleLoot(LootTable instance, LootContextParameterSet parameters, long seed, Consumer<ItemStack> lootConsumer, Operation<Void> original) {
        LivingEntity livingEntity = this.getAttacker();
        LivingEntity target = (LivingEntity) (Object) this;

        if (livingEntity != null) {
            if (livingEntity.getMainHandStack().isIn(TweakfailureTags.CLEAVERS)) {
                for (int i = 0; i < 2; i++) {
                    instance.generateLoot(parameters, seed, this::dropStack);
                }
            } else {
                original.call(instance, parameters, seed, lootConsumer);
            }


            if (livingEntity.getMainHandStack().isIn(TweakfailureTags.CLEAVERS)) {
                if ((target instanceof PigEntity) || (target instanceof PiglinEntity) || (target instanceof ZoglinEntity)) {
                    original.call(instance, parameters, seed, lootConsumer);

                    target.dropStack(new ItemStack(TweakfailureItems.LARD));
                }

                if (target instanceof WitherSkeletonEntity) {
                    original.call(instance, parameters, seed, lootConsumer);

                    int r = this.getWorld().getRandom().nextBetween(0, 140);

                    if (r == 3) {
                        target.dropStack(new ItemStack(TweakfailureItems.TALIONIUM));
                    }
                }
            }
        }
    }

    @Inject(method = "onDismounted", at = @At("HEAD"))
    private void dismountProperly(Entity vehicle, CallbackInfo ci) {
        LivingEntity living = (LivingEntity) (Object) this;

        if (vehicle instanceof SeatEntity seatEntity) {
            seatEntity.dismount(living);
        }
    }

}



