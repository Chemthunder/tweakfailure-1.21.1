package net.kindling.tweakfailure.impl;

import net.fabricmc.api.ClientModInitializer;
import net.kindling.tweakfailure.impl.index.TweakfailureBlocks;
import net.kindling.tweakfailure.impl.index.TweakfailureEntities;

public class TweakfailureClient implements ClientModInitializer {

    public void onInitializeClient() {
        TweakfailureEntities.clientInit();
        TweakfailureBlocks.clientInit();
    }
}
