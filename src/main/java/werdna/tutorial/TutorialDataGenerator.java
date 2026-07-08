package werdna.tutorial;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.client.data.models.ModelProvider;
import werdna.tutorial.datagen.ModBlockLoottableProvider;
import werdna.tutorial.datagen.ModBlockTagProvider;
import werdna.tutorial.datagen.ModModelProvider;
import werdna.tutorial.datagen.ModRecipeProvider;

public class TutorialDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockLoottableProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
