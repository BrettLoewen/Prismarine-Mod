package net.supremetor.prismarine.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.supremetor.prismarine.Prismarine;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> PRISMARINE_PILLAR_PLACED_KEY = registerKey("prismarine_pillar_placed");
    public static final RegistryKey<PlacedFeature> PRISMARINE_DARK_PILLAR_PLACED_KEY = registerKey("prismarine_dark_pillar_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PRISMARINE_PILLAR_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PRISMARINE_PILLAR_KEY),
                ModOrePlacement.modifiersWithRarity(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(20), YOffset.fixed(50))));

        register(context, PRISMARINE_DARK_PILLAR_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PRISMARINE_DARK_PILLAR_KEY),
                ModOrePlacement.modifiersWithRarity(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(20), YOffset.fixed(50))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Prismarine.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
