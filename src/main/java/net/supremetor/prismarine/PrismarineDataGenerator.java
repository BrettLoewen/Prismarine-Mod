package net.supremetor.prismarine;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.supremetor.prismarine.datagen.ModItemTagProvider;
import net.supremetor.prismarine.datagen.ModModelProvider;

public class PrismarineDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModItemTagProvider::new);
	}

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
    }
}
