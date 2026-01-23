package net.kindling.tweakfailure.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class AllayPendantItem extends Item {
    public AllayPendantItem(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getBlockPos();

        if (player != null && !player.getItemCooldownManager().isCoolingDown(this)) {
            if (context.getWorld() instanceof ServerWorld serverWorld) {
                AllayEntity allay = new AllayEntity(EntityType.ALLAY, serverWorld);
                allay.setPos(pos.getX() + 0.5f, pos.getY() + 1.0f, pos.getZ() + 0.5f);
                serverWorld.spawnEntity(allay);
            }

            if (!player.isInCreativeMode()) {
                player.getItemCooldownManager().set(this, 280);
            }

            player.playSound(SoundEvents.ENTITY_ALLAY_ITEM_TAKEN);
            player.swingHand(player.getActiveHand() );
        }
        return super.useOnBlock(context);
    }
}
