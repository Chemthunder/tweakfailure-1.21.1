package net.kindling.impl.tweakfailure.index;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kindling.impl.tweakfailure.Tweakfailure;
import net.kindling.impl.tweakfailure.item.AllayPendantItem;
import net.kindling.impl.tweakfailure.item.CleaverItem;
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
    Item FLINT_CLEAVER = create("flint_cleaver", settings -> new CleaverItem(ToolMaterials.WOOD, settings), new Item.Settings().maxCount(1)
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.5f)));

    Item IRON_CLEAVER = create("iron_cleaver", settings -> new CleaverItem(ToolMaterials.IRON, settings),  new Item.Settings().maxCount(1)
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.5f)));

    Item GOLD_CLEAVER = create("gold_cleaver", settings -> new CleaverItem(ToolMaterials.GOLD, settings), new Item.Settings().maxCount(1)
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2.5f)));

    Item DIAMOND_CLEAVER = create("diamond_cleaver", settings -> new CleaverItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1)
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2.5f)));

    Item NETHERITE_CLEAVER = create("netherite_cleaver", settings -> new CleaverItem(ToolMaterials.NETHERITE, settings), new Item.Settings().maxCount(1)
            .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.5f)));


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
}
