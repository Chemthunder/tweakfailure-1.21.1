package net.kindling.tweakfailure.impl.index;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kindling.tweakfailure.impl.entity.SeatEntity;
import net.kindling.tweakfailure.impl.Tweakfailure;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface TweakfailureEntities {
    EntityType<SeatEntity> SEAT = create("seat", EntityType.Builder.create(
            SeatEntity::new,
            SpawnGroup.MISC
    ).dimensions(0.5F, 1.0F));

    private static <T extends Entity> EntityType<T> create(String name, EntityType.Builder<T> builder) {
        return Registry.register(Registries.ENTITY_TYPE, Tweakfailure.id(name), builder.build());
    }

    static void init() {
        //
    }

    static void clientInit() {
        EntityRendererRegistry.register(SEAT, EmptyEntityRenderer::new);
    }
}
