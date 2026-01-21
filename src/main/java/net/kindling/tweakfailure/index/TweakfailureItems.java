package net.kindling.tweakfailure.index;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kindling.tweakfailure.Tweakfailure;
import net.kindling.tweakfailure.item.AllayPendantItem;
import net.kindling.tweakfailure.item.BoomcanItem;
import net.kindling.tweakfailure.item.CleaverItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.Function;

public interface TweakfailureItems {

    Item ALLAY_PENDANT = create("allay_pendant", AllayPendantItem::new, new Item.Settings()
            .maxCount(1)
    );

    Item LARD = create("lard", Item::new, new Item.Settings());

    Item CANDY = create("candy", Item::new, new Item.Settings()
            .maxCount(16)
    );

    Item BOOMCAN = create("boomcan", BoomcanItem::new, new Item.Settings()
            .maxCount(5)
    );




    // cleavers
    Item FLINT_CLEAVER = create("flint_cleaver", CleaverItem::new, new Item.Settings().maxCount(1)
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.5f)));

    Item STONE_CLEAVER = create("stone_cleaver", CleaverItem::new, new Item.Settings().maxCount(1)
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 2, -2.5f)));

    Item IRON_CLEAVER = create("iron_cleaver", CleaverItem::new,  new Item.Settings().maxCount(1)
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.5f)));

    Item GOLD_CLEAVER = create("gold_cleaver", CleaverItem::new, new Item.Settings().maxCount(1)
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2.5f)));

    Item DIAMOND_CLEAVER = create("diamond_cleaver", CleaverItem::new, new Item.Settings().maxCount(1)
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2.5f)));

    Item NETHERITE_CLEAVER = create("netherite_cleaver", CleaverItem::new, new Item.Settings().maxCount(1)
            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.5f)));


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
        entries.addAfter(Items.NETHERITE_HOE, FLINT_CLEAVER);
        entries.addAfter(FLINT_CLEAVER, STONE_CLEAVER);
        entries.addAfter(STONE_CLEAVER, IRON_CLEAVER);
        entries.addAfter(IRON_CLEAVER, GOLD_CLEAVER);
        entries.addAfter(GOLD_CLEAVER, DIAMOND_CLEAVER);
        entries.addAfter(DIAMOND_CLEAVER, NETHERITE_CLEAVER);

        entries.addAfter(Items.SPYGLASS, ALLAY_PENDANT);
    }

    private static void addIngredientEntries(FabricItemGroupEntries entries) {
        entries.addAfter(Items.BONE_MEAL, LARD);
    }
}
