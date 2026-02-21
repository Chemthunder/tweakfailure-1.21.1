package net.kindling.tweakfailure.data.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.kindling.tweakfailure.impl.index.TweakfailureBlocks.*;

public class TweakBlockLootTableGen extends FabricBlockLootTableProvider {
    public TweakBlockLootTableGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generate() {
        addDrop(WHITE_CUSHION);
        addDrop(BLACK_CUSHION);
        addDrop(GRAY_CUSHION);
        addDrop(LIGHT_GRAY_CUSHION);
        addDrop(BLUE_CUSHION);
        addDrop(BROWN_CUSHION);
        addDrop(CYAN_CUSHION);
        addDrop(PINK_CUSHION);
        addDrop(LIME_CUSHION);
        addDrop(ORANGE_CUSHION);
        addDrop(LIGHT_BLUE_CUSHION);
        addDrop(RED_CUSHION);
        addDrop(PURPLE_CUSHION);
        addDrop(MAGENTA_CUSHION);
        addDrop(YELLOW_CUSHION);
    }
}
