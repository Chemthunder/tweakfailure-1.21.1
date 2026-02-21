package net.kindling.tweakfailure.impl.index;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kindling.tweakfailure.impl.Tweakfailure;
import net.kindling.tweakfailure.impl.item.AllayPendantItem;
import net.kindling.tweakfailure.impl.item.CleaverItem;
import net.kindling.tweakfailure.impl.item.CushionBlockItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public interface TweakfailureItems {
    Item ALLAY_PENDANT = create("allay_pendant", AllayPendantItem::new, new Item.Settings().maxCount(1));
    Item LARD = create("lard", HoneycombItem::new, new Item.Settings());
    Item TALIONIUM = create("talionium", Item::new, new Item.Settings().jukeboxPlayable(TweakfailureSounds.TALIONIUM_MUSIC).rarity(Rarity.RARE).maxCount(1));

    // cleavers
    Item FLINT_CLEAVER = create("flint_cleaver", settings -> new CleaverItem(ToolMaterials.WOOD, settings), new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.6f)));
    Item IRON_CLEAVER = create("iron_cleaver", settings -> new CleaverItem(ToolMaterials.IRON, settings),  new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.6f)));
    Item GOLD_CLEAVER = create("gold_cleaver", settings -> new CleaverItem(ToolMaterials.GOLD, settings), new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2.6f)));
    Item DIAMOND_CLEAVER = create("diamond_cleaver", settings -> new CleaverItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2.6f)));
    Item NETHERITE_CLEAVER = create("netherite_cleaver", settings -> new CleaverItem(ToolMaterials.NETHERITE, settings), new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.6f)));

    // cushions
    Item WHITE_CUSHION_ITEM = create("white_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.WHITE_CUSHION, settings), new Item.Settings());
    Item RED_CUSHION_ITEM = create("red_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.RED_CUSHION, settings), new Item.Settings());
    Item BLACK_CUSHION_ITEM = create("black_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.BLACK_CUSHION, settings), new Item.Settings());
    Item LIME_CUSHION_ITEM = create("lime_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.LIME_CUSHION, settings), new Item.Settings());
    Item PURPLE_CUSHION_ITEM = create("purple_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.PURPLE_CUSHION, settings), new Item.Settings());
    Item MAGENTA_CUSHION_ITEM = create("magenta_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.MAGENTA_CUSHION, settings), new Item.Settings());
    Item PINK_CUSHION_ITEM = create("pink_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.PINK_CUSHION, settings), new Item.Settings());
    Item ORANGE_CUSHION_ITEM = create("orange_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.ORANGE_CUSHION, settings), new Item.Settings());
    Item BLUE_CUSHION_ITEM = create("blue_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.BLUE_CUSHION, settings), new Item.Settings());
    Item LIGHT_BLUE_CUSHION_ITEM = create("light_blue_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.LIGHT_BLUE_CUSHION, settings), new Item.Settings());
    Item LIGHT_GRAY_CUSHION_ITEM = create("light_gray_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.LIGHT_GRAY_CUSHION, settings), new Item.Settings());
    Item GRAY_CUSHION_ITEM = create("gray_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.GRAY_CUSHION, settings), new Item.Settings());
    Item GREEN_CUSHION_ITEM = create("green_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.GREEN_CUSHION, settings), new Item.Settings());
    Item BROWN_CUSHION_ITEM = create("brown_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.BROWN_CUSHION, settings), new Item.Settings());
    Item YELLOW_CUSHION_ITEM = create("yellow_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.YELLOW_CUSHION, settings), new Item.Settings());
    Item CYAN_CUSHION_ITEM = create("cyan_cushion", settings -> new CushionBlockItem(TweakfailureBlocks.CYAN_CUSHION, settings), new Item.Settings());


    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings);
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, Tweakfailure.id(name), item);
    }

    static void index() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(TweakfailureItems::addToolsEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(TweakfailureItems::addIngredientEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(TweakfailureItems::addFunctionalEntries);
    }

    private static void addToolsEntries(FabricItemGroupEntries entries) {
        entries.addAfter(Items.STONE_HOE, FLINT_CLEAVER);
        entries.addAfter(Items.IRON_HOE, IRON_CLEAVER);
        entries.addAfter(Items.GOLDEN_HOE, GOLD_CLEAVER);
        entries.addAfter(Items.DIAMOND_HOE, DIAMOND_CLEAVER);
        entries.addAfter(Items.NETHERITE_HOE, NETHERITE_CLEAVER);
        entries.addAfter(Items.SPYGLASS, ALLAY_PENDANT);
        entries.addAfter(Items.MUSIC_DISC_PIGSTEP, TALIONIUM);
    }

    private static void addIngredientEntries(FabricItemGroupEntries entries) {
        entries.addAfter(Items.BONE_MEAL, LARD);
    }

    private static void addFunctionalEntries(FabricItemGroupEntries entries) {
        entries.addAfter(Items.PINK_BED, WHITE_CUSHION_ITEM);
        entries.addAfter(WHITE_CUSHION_ITEM, RED_CUSHION_ITEM);
        entries.addAfter(RED_CUSHION_ITEM, LIME_CUSHION_ITEM);
        entries.addAfter(LIME_CUSHION_ITEM, MAGENTA_CUSHION_ITEM);
        entries.addAfter(MAGENTA_CUSHION_ITEM, BLACK_CUSHION_ITEM);
        entries.addAfter(BLACK_CUSHION_ITEM, PURPLE_CUSHION_ITEM);
        entries.addAfter(PURPLE_CUSHION_ITEM, PINK_CUSHION_ITEM);
        entries.addAfter(PINK_CUSHION_ITEM, LIGHT_BLUE_CUSHION_ITEM);
        entries.addAfter(LIGHT_BLUE_CUSHION_ITEM, BLUE_CUSHION_ITEM);
        entries.addAfter(BLUE_CUSHION_ITEM, ORANGE_CUSHION_ITEM);
        entries.addAfter(ORANGE_CUSHION_ITEM, YELLOW_CUSHION_ITEM);
        entries.addAfter(YELLOW_CUSHION_ITEM, GREEN_CUSHION_ITEM);
        entries.addAfter(GREEN_CUSHION_ITEM, LIGHT_GRAY_CUSHION_ITEM);
        entries.addAfter(LIGHT_GRAY_CUSHION_ITEM, GRAY_CUSHION_ITEM);
        entries.addAfter(GRAY_CUSHION_ITEM, BROWN_CUSHION_ITEM);
        entries.addAfter(BROWN_CUSHION_ITEM, CYAN_CUSHION_ITEM);
    }
}
