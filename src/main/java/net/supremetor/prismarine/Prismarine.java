package net.supremetor.prismarine;

import net.fabricmc.api.ModInitializer;

import net.supremetor.prismarine.item.ModItemGroups;
import net.supremetor.prismarine.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prismarine implements ModInitializer {
	public static final String MOD_ID = "prismarine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
	}

    // Example of sending a message through chat using a player entity
    // player.sendMessage(Text.literal("Hello World!"), false);
}