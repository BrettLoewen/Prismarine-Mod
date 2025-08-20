package net.supremetor.prismarine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.supremetor.prismarine.Prismarine;
import net.supremetor.prismarine.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                // Temp recipe for upgrade template
//                createShaped(RecipeCategory.MISC, ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE)
//                        .pattern("RRR")
//                        .pattern("RDR")
//                        .pattern("RRR")
//                        .input('R', Items.PRISMARINE_SHARD)
//                        .input('D', Items.DIAMOND)
//                        .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
//                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
//                        .offerTo(exporter);

                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(Items.PRISMARINE_SHARD),
                        RecipeCategory.COMBAT,
                        ModItems.PRISMARINE_CHESTPLATE
                )
                        .criterion(hasItem(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE))
                        .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                        .criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Prismarine.MOD_ID, "prismarine_upgrade_chestplate")));
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
