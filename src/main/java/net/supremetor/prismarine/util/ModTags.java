package net.supremetor.prismarine.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.supremetor.prismarine.Prismarine;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PRISMARINE_TOOL = createTag("needs_prismarine_tool");
        public static final TagKey<Block> INCORRECT_FOR_PRISMARINE_TOOL = createTag("incorrect_for_prismarine_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Prismarine.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PRISMARINE_REPAIR = createTag("prismarine_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Prismarine.MOD_ID, name));
        }
    }
}
