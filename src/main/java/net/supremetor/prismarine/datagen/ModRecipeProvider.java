package net.supremetor.prismarine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
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
                offerSmithingTemplateCopyingRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.PRISMARINE);

                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_HELMET, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.COMBAT, ModItems.PRISMARINE_HELMET, "prismarine_upgrade_helmet");
                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_CHESTPLATE, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.COMBAT, ModItems.PRISMARINE_CHESTPLATE, "prismarine_upgrade_chestplate");
                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_LEGGINGS, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.COMBAT, ModItems.PRISMARINE_LEGGINGS, "prismarine_upgrade_leggings");
                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_BOOTS, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.COMBAT, ModItems.PRISMARINE_BOOTS, "prismarine_upgrade_boots");

                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_SWORD, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.COMBAT, ModItems.PRISMARINE_SWORD, "prismarine_upgrade_sword");
                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_PICKAXE, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.TOOLS, ModItems.PRISMARINE_PICKAXE, "prismarine_upgrade_pickaxe");
                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_AXE, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.COMBAT, ModItems.PRISMARINE_AXE, "prismarine_upgrade_axe");
                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_SHOVEL, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.TOOLS, ModItems.PRISMARINE_SHOVEL, "prismarine_upgrade_shovel");
                generateSmithingTransformRecipe(ModItems.PRISMARINE_UPGRADE_SMITHING_TEMPLATE, Items.DIAMOND_HOE, ModItems.PRISMARINE_INGOT,
                        RecipeCategory.TOOLS, ModItems.PRISMARINE_HOE, "prismarine_upgrade_hoe");
            }

            private void generateSmithingTransformRecipe(Item template, Item appliesTo, Item ingredient, RecipeCategory recipeCategory,
                                                         Item output, String recipeId) {
                SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(template),
                        Ingredient.ofItems(appliesTo),
                        Ingredient.ofItems(ingredient),
                                recipeCategory, output
                )
                        .criterion(hasItem(template), conditionsFromItem(template))
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .criterion(hasItem(appliesTo), conditionsFromItem(appliesTo))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Prismarine.MOD_ID, recipeId)));
            }
        };
    }

    @Override
    public String getName() {
        return "Prismarine Recipes";
    }
}
