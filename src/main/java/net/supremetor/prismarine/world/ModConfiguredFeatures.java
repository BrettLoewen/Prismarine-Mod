package net.supremetor.prismarine.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.supremetor.prismarine.Prismarine;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PRISMARINE_ORE_KEY = registerKey("prismarine_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest gravelReplaceables = new BlockMatchRuleTest(Blocks.GRAVEL);

//        List<OreFeatureConfig.Target> overworldPinkGarnetOres =
//                List.of(OreFeatureConfig.createTarget(gravelReplaceables, Blocks.PRISMARINE.getDefaultState()));

        register(context, PRISMARINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(gravelReplaceables, Blocks.DARK_PRISMARINE.getDefaultState(), 4));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Prismarine.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
