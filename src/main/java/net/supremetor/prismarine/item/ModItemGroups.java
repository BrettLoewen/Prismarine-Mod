package net.supremetor.prismarine.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.supremetor.prismarine.Prismarine;

public class ModItemGroups {
    public static final ItemGroup PRISMARINE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prismarine.MOD_ID, "prismarine_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.PRISMARINE_SHARD))
                    .displayName(Text.translatable("itemgroup.prismarine.prismarine_items"))
                    .entries((displayContext, entries) -> {
//                        entries.add(ModItems.PRISMARINE_SWORD);
//                        entries.add(ModItems.PRISMARINE_PICKAXE);
//                        entries.add(ModItems.PRISMARINE_SHOVEL);
//                        entries.add(ModItems.PRISMARINE_AXE);
//                        entries.add(ModItems.PRISMARINE_HOE);

                        entries.add(ModItems.PRISMARINE_HELMET);
                        entries.add(ModItems.PRISMARINE_CHESTPLATE);
                        entries.add(ModItems.PRISMARINE_LEGGINGS);
                        entries.add(ModItems.PRISMARINE_BOOTS);

                        entries.add(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE);
                    }).build());

    public static void registerItemGroups() {
    }
}
