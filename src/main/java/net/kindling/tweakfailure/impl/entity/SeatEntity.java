package net.kindling.tweakfailure.impl.entity;

import net.kindling.tweakfailure.impl.Tweakfailure;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class SeatEntity extends Entity {
    public SeatEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    protected void initDataTracker(DataTracker.Builder builder) {}
    protected void readCustomDataFromNbt(NbtCompound nbt) {}
    protected void writeCustomDataToNbt(NbtCompound nbt) {}

    public void dismount(LivingEntity living) {
        living.setPosition(this.getX(), this.getY() + 2.0f, this.getZ());

        this.discard();
        Tweakfailure.LOGGER.info("Seat discarded successfully");
    }
}
