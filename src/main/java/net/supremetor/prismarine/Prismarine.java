package net.supremetor.prismarine;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.supremetor.prismarine.block.ModBlocks;
import net.supremetor.prismarine.item.ModItemGroups;
import net.supremetor.prismarine.item.ModItems;
import net.supremetor.prismarine.util.ModLootTableModifiers;
import net.supremetor.prismarine.world.custom.BlockPillarGrowthConfig;
import net.supremetor.prismarine.world.custom.BlockPillarGrowthFeature;
import net.supremetor.prismarine.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prismarine implements ModInitializer {
	public static final String MOD_ID = "prismarine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Feature<BlockPillarGrowthConfig> BLOCK_PILLAR_GROWTH =
            Registry.register(Registries.FEATURE,
                    Identifier.of(Prismarine.MOD_ID, "block_pillar_growth"),
                    new BlockPillarGrowthFeature(BlockPillarGrowthConfig.CODEC));

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModLootTableModifiers.modifyLootTables();
        ModWorldGeneration.generateModWorldGen();
	}

    // Example of sending a message through chat using a player entity
    // player.sendMessage(Text.literal("Hello World!"), false);
}