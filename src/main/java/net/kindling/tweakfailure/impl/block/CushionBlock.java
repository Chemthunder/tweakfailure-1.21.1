package net.kindling.tweakfailure.impl.block;

import net.kindling.tweakfailure.impl.entity.SeatEntity;
import net.kindling.tweakfailure.impl.index.TweakfailureEntities;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CushionBlock extends Block {
    public static final VoxelShape OUTLINE = Block.createCuboidShape(0, 0, 0, 16, 8, 16);

    public CushionBlock(Settings settings) {
        super(settings);
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.hasVehicle()) {
            if (player.getMainHandStack().isEmpty()) {
                if (!player.isSneaking()) {
                    SeatEntity seat = new SeatEntity(TweakfailureEntities.SEAT, world);

                    seat.setPos(pos.getX() + 0.5f, pos.getY() - 0.5f, pos.getZ() + 0.5f);
                    player.startRiding(seat);

                    world.spawnEntity(seat);
                    player.swingHand(Hand.MAIN_HAND);
                }
            }
        }
        return super.onUse(state, world, pos, player, hit);
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE;
    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0f, world.getDamageSources().fall());
        }
    }
}
