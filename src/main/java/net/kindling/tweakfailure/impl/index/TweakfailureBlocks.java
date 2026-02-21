package net.kindling.tweakfailure.impl.index;

import net.kindling.tweakfailure.impl.block.CushionBlock;
import net.kindling.tweakfailure.impl.Tweakfailure;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public interface TweakfailureBlocks {
    Block WHITE_CUSHION = create("white_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL));
    Block BLACK_CUSHION = create("black_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.BLACK_WOOL).sounds(BlockSoundGroup.WOOL));
    Block LIME_CUSHION = create("lime_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.LIME_WOOL).sounds(BlockSoundGroup.WOOL));
    Block PURPLE_CUSHION = create("purple_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL).sounds(BlockSoundGroup.WOOL));
    Block MAGENTA_CUSHION = create("magenta_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL).sounds(BlockSoundGroup.WOOL));
    Block RED_CUSHION = create("red_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.RED_WOOL).sounds(BlockSoundGroup.WOOL));
    Block LIGHT_BLUE_CUSHION = create("light_blue_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL).sounds(BlockSoundGroup.WOOL));
    Block BLUE_CUSHION = create("blue_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).sounds(BlockSoundGroup.WOOL));
    Block ORANGE_CUSHION = create("orange_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL).sounds(BlockSoundGroup.WOOL));
    Block PINK_CUSHION = create("pink_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.PINK_WOOL).sounds(BlockSoundGroup.WOOL));
    Block YELLOW_CUSHION = create("yellow_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL).sounds(BlockSoundGroup.WOOL));
    Block LIGHT_GRAY_CUSHION = create("light_gray_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL).sounds(BlockSoundGroup.WOOL));
    Block GRAY_CUSHION = create("gray_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.GRAY_WOOL).sounds(BlockSoundGroup.WOOL));
    Block BROWN_CUSHION = create("brown_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.WOOL));
    Block GREEN_CUSHION = create("green_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).sounds(BlockSoundGroup.WOOL));
    Block CYAN_CUSHION = create("cyan_cushion", CushionBlock::new, AbstractBlock.Settings.copy(Blocks.CYAN_WOOL).sounds(BlockSoundGroup.WOOL));

    static Block create(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings);
        return Registry.register(Registries.BLOCK, Tweakfailure.id(name), block);
    }

    static void init() {
        //
    }

    static void clientInit() {
        //
    }
}
