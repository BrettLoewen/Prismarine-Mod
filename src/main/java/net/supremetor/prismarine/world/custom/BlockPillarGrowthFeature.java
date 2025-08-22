package net.supremetor.prismarine.world.custom;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BlockPillarGrowthFeature extends Feature<BlockPillarGrowthConfig> {
    public BlockPillarGrowthFeature(Codec<BlockPillarGrowthConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<BlockPillarGrowthConfig> context) {
        BlockPillarGrowthConfig config = context.getConfig();
        BlockPos origin = context.getOrigin();
        WorldAccess world = context.getWorld();
        Random random = context.getRandom();

        // Ensure the pillar is placed in the replacedBlock
        if (!world.getBlockState(origin).isOf(config.replacedBlock().get(random, origin).getBlock())) return false;

        int height = config.height().get(random);

        // For each block in the pillar
        for (int i = 0; i < height; i++) {
//            BlockPos innerPos = origin.up(i).offset(Direction.values()[UniformIntProvider.create(2, 5).get(random)]);

            BlockPos pos = origin.up(i);

            // Place the inside of the pillar
            world.setBlockState(pos, config.innerBlock().get(random, pos), 3);

            // Place a full shell around the new inner block
            for (Direction dir : Direction.values()) {
                BlockPos side = pos.offset(dir);
                if (world.getBlockState(side).isReplaceable()) {
                    world.setBlockState(side, config.shellBlock().get(random, side), 3);
                }
            }
        }

        return true;
    }
}
