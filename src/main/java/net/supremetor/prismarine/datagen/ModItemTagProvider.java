package net.supremetor.prismarine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.supremetor.prismarine.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        valueLookupBuilder(ModTags.Items.PINK_GARNET_REPAIR)
//                .add(ModItems.PINK_GARNET);

//        valueLookupBuilder(ItemTags.SWORDS)
//                .add(ModItems.PINK_GARNET_SWORD);
//        valueLookupBuilder(ItemTags.PICKAXES)
//                .add(ModItems.PINK_GARNET_PICKAXE);
//        valueLookupBuilder(ItemTags.SHOVELS)
//                .add(ModItems.PINK_GARNET_SHOVEL);
//        valueLookupBuilder(ItemTags.AXES)
//                .add(ModItems.PINK_GARNET_AXE);
//        valueLookupBuilder(ItemTags.HOES)
//                .add(ModItems.PINK_GARNET_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PRISMARINE_HELMET)
                .add(ModItems.PRISMARINE_CHESTPLATE)
                .add(ModItems.PRISMARINE_LEGGINGS)
                .add(ModItems.PRISMARINE_BOOTS);
    }
}
