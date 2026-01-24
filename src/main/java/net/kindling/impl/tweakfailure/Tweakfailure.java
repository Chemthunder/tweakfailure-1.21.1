package net.kindling.impl.tweakfailure;

import net.fabricmc.api.ModInitializer;
import net.kindling.impl.tweakfailure.index.TweakfailureEffects;
import net.kindling.impl.tweakfailure.index.TweakfailureItems;
import net.kindling.impl.tweakfailure.index.TweakfailurePotions;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tweakfailure implements ModInitializer {
	public static final String MOD_ID = "tweakfailure";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        TweakfailureItems.index();
        TweakfailureEffects.index();

        TweakfailurePotions.index();

		LOGGER.info("Hello Fabric world!");
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}