package net.supremetor.prismarine.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;
import net.supremetor.prismarine.Prismarine;
import net.supremetor.prismarine.item.custom.ModArmorItem;

import java.util.List;
import java.util.function.Function;

public class ModItems {
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;
//    private static final Text PRISMARINE_UPGRADE_APPLIES_TO_TEXT =
//            Text.translatable("smithing_template.prismarine_upgrade.applies_to").formatted(DESCRIPTION_FORMATTING);
//    private static final Text PRISMARINE_UPGRADE_INGREDIENTS_TEXT =
//            Text.translatable("smithing_template.prismarine_upgrade.ingredients").formatted(DESCRIPTION_FORMATTING);
//    private static final Text PRISMARINE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT =
//            Text.translatable("smithing_template.prismarine_upgrade.base_slot_description").formatted(DESCRIPTION_FORMATTING);
//    private static final Text PRISMARINE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT =
//        Text.translatable("smithing_template.prismarine_upgrade.additions_slot_description").formatted(DESCRIPTION_FORMATTING);

    public static final Item PRISMARINE_HELMET = registerItem("prismarine_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item PRISMARINE_CHESTPLATE = registerItem("prismarine_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item PRISMARINE_LEGGINGS = registerItem("prismarine_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item PRISMARINE_BOOTS = registerItem("prismarine_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

//    public static final Item PRISMARINE_UPGRADE_SMITHING_TEMPLATE = registerItem("prismarine_upgrade_smithing_template",
//            setting -> new SmithingTemplateItem(
////                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.prismarine_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING),
//////                    Text.translatable("smithing_template.prismarine_upgrade.applies_to").formatted(DESCRIPTION_FORMATTING),
////                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.prismarine_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING),
////                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.prismarine_upgrade.base_slot_description"))).formatted(DESCRIPTION_FORMATTING),
////                    Text.translatable(Util.createTranslationKey("item", Identifier.of("smithing_template.prismarine_upgrade.additions_slot_description"))).formatted(DESCRIPTION_FORMATTING),
//                    Text.literal(""),
//                    Text.literal(""),
//                    Text.literal(""),
//                    Text.literal(""),
////                    getPrismarineUpgradeEmptyBaseSlotTextures(),
////                    getPrismarineUpgradeEmptyAdditionsSlotTextures(),
//                    List.of(),
//                    List.of(),
//                    new Item.Settings().rarity(Rarity.UNCOMMON)));


//    public static final Item PRISMARINE_UPGRADE_SMITHING_TEMPLATE = registerItem("prismarine_upgrade_smithing_template", Item::new);

    public static final Item PRISMARINE_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "prismarine_upgrade_smithing_template", SmithingTemplateItem::createNetheriteUpgrade);

    // From SmithingTemplateItem.java
//    private static List<Identifier> getPrismarineUpgradeEmptyBaseSlotTextures() {
//        return List.of(
//                Identifier.ofVanilla("container/slot/helmet"),
//                Identifier.ofVanilla("container/slot/chestplate"),
//                Identifier.ofVanilla("container/slot/leggings"),
//                Identifier.ofVanilla("container/slot/boots"),
//                Identifier.ofVanilla("container/slot/sword"),
//                Identifier.ofVanilla("container/slot/pickaxe"),
//                Identifier.ofVanilla("container/slot/axe"),
//                Identifier.ofVanilla("container/slot/hoe"),
//                Identifier.ofVanilla("container/slot/shovel")
//        );
//    }
//
//    // From SmithingTemplateItem.java
//    private static List<Identifier> getPrismarineUpgradeEmptyAdditionsSlotTextures() {
//        return List.of(Identifier.ofVanilla("container/slot/ingot"));
//    }

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Prismarine.MOD_ID, name), function.apply(
                new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Prismarine.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Prismarine.LOGGER.info("Registering Mod Items for " + Prismarine.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(PRISMARINE_HELMET);
            entries.add(PRISMARINE_CHESTPLATE);
            entries.add(PRISMARINE_LEGGINGS);
            entries.add(PRISMARINE_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PRISMARINE_UPGRADE_SMITHING_TEMPLATE);
        });
    }
}
