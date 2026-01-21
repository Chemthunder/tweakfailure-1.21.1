package net.kindling.tweakfailure;

import net.fabricmc.api.ModInitializer;
import net.kindling.tweakfailure.index.TweakfailureItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tweakfailure implements ModInitializer {
	public static final String MOD_ID = "tweakfailure";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        TweakfailureItems.index();

		LOGGER.info("Hello Fabric world!");
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}