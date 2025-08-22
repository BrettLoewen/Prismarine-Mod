package net.supremetor.prismarine.world.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record BlockPillarGrowthConfig(BlockStateProvider innerBlock,
                                      BlockStateProvider shellBlock,
                                      BlockStateProvider replacedBlock,
                                      IntProvider height) implements FeatureConfig {
    public static final Codec<BlockPillarGrowthConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.TYPE_CODEC.fieldOf("inner_block").forGetter(BlockPillarGrowthConfig::innerBlock),
            BlockStateProvider.TYPE_CODEC.fieldOf("shell_block").forGetter(BlockPillarGrowthConfig::shellBlock),
            BlockStateProvider.TYPE_CODEC.fieldOf("replaced_block").forGetter(BlockPillarGrowthConfig::replacedBlock),
            IntProvider.VALUE_CODEC.fieldOf("height").forGetter(BlockPillarGrowthConfig::height)
    ).apply(instance, BlockPillarGrowthConfig::new));
}
