package net.kindling.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.kindling.impl.tweakfailure.index.TweakfailureItems;
import net.kindling.impl.tweakfailure.item.CleaverItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

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
        LivingEntity goober = (LivingEntity) (Object) this;

        if (livingEntity != null) {
            if (livingEntity.getMainHandStack().getItem() instanceof CleaverItem) {
                for (int i = 0; i < 2; i++) {
                    instance.generateLoot(parameters, seed, this::dropStack);
                }
            } else {
                original.call(instance, parameters, seed, lootConsumer);
            }


            if (livingEntity.getMainHandStack().getItem() instanceof CleaverItem) {
                if ((goober instanceof PigEntity) || (goober instanceof PiglinEntity)) {
                    original.call(instance, parameters, seed, lootConsumer);

                    goober.dropStack(TweakfailureItems.LARD.getDefaultStack());
                }
            }
        }
    }
}



