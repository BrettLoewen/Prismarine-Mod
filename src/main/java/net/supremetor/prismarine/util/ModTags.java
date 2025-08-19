package net.supremetor.prismarine.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.supremetor.prismarine.Prismarine;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> PRISMARINE_REPAIR = createTag("prismarine_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Prismarine.MOD_ID, name));
        }
    }
}
