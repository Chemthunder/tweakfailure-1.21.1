package net.kindling.tweakfailure.impl;

import net.fabricmc.api.ModInitializer;
import net.kindling.tweakfailure.impl.index.*;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tweakfailure implements ModInitializer {
	public static final String MOD_ID = "tweakfailure";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
        TweakfailureItems.index();
        TweakfailureEffects.index();
        TweakfailurePotions.index();
        TweakfailureTags.index();
        TweakfailureSounds.index();
        TweakfailureBlocks.init();
        TweakfailureEntities.init();

		LOGGER.info(MOD_ID + " is initialized");
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}