package net.supremetor.prismarine.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.supremetor.prismarine.Prismarine;
import net.supremetor.prismarine.world.custom.BlockPillarGrowthConfig;
import net.supremetor.prismarine.world.custom.BlockPillarGrowthFeature;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PRISMARINE_PILLAR_KEY = registerKey("prismarine_pillar");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PRISMARINE_DARK_PILLAR_KEY = registerKey("prismarine_dark_pillar");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, PRISMARINE_PILLAR_KEY, Prismarine.BLOCK_PILLAR_GROWTH, new BlockPillarGrowthConfig(
                BlockStateProvider.of(Blocks.PRISMARINE),
                BlockStateProvider.of(Blocks.TUFF),
                BlockStateProvider.of(Blocks.GRAVEL),
                UniformIntProvider.create(2, 5)
        ));

        register(context, PRISMARINE_DARK_PILLAR_KEY, Prismarine.BLOCK_PILLAR_GROWTH, new BlockPillarGrowthConfig(
                BlockStateProvider.of(Blocks.DARK_PRISMARINE),
                BlockStateProvider.of(Blocks.TUFF),
                BlockStateProvider.of(Blocks.GRAVEL),
                UniformIntProvider.create(2, 5)
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Prismarine.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
