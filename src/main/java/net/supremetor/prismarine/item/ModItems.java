package net.supremetor.prismarine.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.supremetor.prismarine.Prismarine;
import net.supremetor.prismarine.item.custom.ModArmorItem;

import java.util.function.Function;

public class ModItems {
    public static final Item PRISMARINE_HELMET = registerItem("prismarine_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item PRISMARINE_CHESTPLATE = registerItem("prismarine_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item PRISMARINE_LEGGINGS = registerItem("prismarine_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item PRISMARINE_BOOTS = registerItem("prismarine_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

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
    }
}
