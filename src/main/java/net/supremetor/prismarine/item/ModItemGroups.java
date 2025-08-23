package net.supremetor.prismarine.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.supremetor.prismarine.Prismarine;
import net.supremetor.prismarine.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup PRISMARINE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prismarine.MOD_ID, "prismarine_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PRISMARINE_INGOT))
                    .displayName(Text.translatable("itemgroup.prismarine.prismarine_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PRISMATIC_DEBRIS);
                        entries.add(ModItems.PRISMARINE_SCRAP);
                        entries.add(ModItems.PRISMARINE_INGOT);
                        entries.add(ModBlocks.PRISMARINE_BLOCK);

                        entries.add(ModItems.PRISMARINE_SWORD);
                        entries.add(ModItems.PRISMARINE_PICKAXE);
                        entries.add(ModItems.PRISMARINE_SHOVEL);
                        entries.add(ModItems.PRISMARINE_AXE);
                        entries.add(ModItems.PRISMARINE_HOE);

                        entries.add(ModItems.PRISMARINE_HELMET);
                        entries.add(ModItems.PRISMARINE_CHESTPLATE);
                        entries.add(ModItems.PRISMARINE_LEGGINGS);
                        entries.add(ModItems.PRISMARINE_BOOTS);

                        entries.add(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE);

                        entries.add(ModBlocks.PRISMARINE_CRYSTAL);

                        entries.add(Items.PRISMARINE_SHARD);
                        entries.add(Items.PRISMARINE_CRYSTALS);
                        entries.add(Blocks.PRISMARINE);
                        entries.add(Blocks.PRISMARINE_SLAB);
                        entries.add(Blocks.PRISMARINE_STAIRS);
                        entries.add(Blocks.PRISMARINE_WALL);
                        entries.add(Blocks.PRISMARINE_BRICKS);
                        entries.add(Blocks.PRISMARINE_BRICK_SLAB);
                        entries.add(Blocks.PRISMARINE_BRICK_STAIRS);
                        entries.add(Blocks.DARK_PRISMARINE);
                        entries.add(Blocks.DARK_PRISMARINE_SLAB);
                        entries.add(Blocks.DARK_PRISMARINE_STAIRS);
                        entries.add(Items.TRIDENT);
                    }).build());

    public static void registerItemGroups() {
    }
}
