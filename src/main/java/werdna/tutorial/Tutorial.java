package werdna.tutorial;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;

import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import werdna.tutorial.attachments.ModAttachmentTypes;
import werdna.tutorial.blocks.ModBlocks;
import werdna.tutorial.data.ModDataComponent;
import werdna.tutorial.effects.ModConsumeEffects;
import werdna.tutorial.events.ModServerEvents;
import werdna.tutorial.items.ModItems;
import werdna.tutorial.items.ModItemsGroup;
import werdna.tutorial.loot.ModLootTableModifiers;
import werdna.tutorial.networking.ModPackets;
import werdna.tutorial.registries.ModFuel;

public class Tutorial implements ModInitializer {
	public static final String MOD_ID = "tutorial";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//LOGGER.info("Hello Fabric world!");
		ModItems.registerItems();
		ModBlocks.registerBlocks();

		ModAttachmentTypes.registerModAttachmentTypes();

		ModItemsGroup.registerCreativeModeTab();

		ModFuel.registerModFuels();
		ModDataComponent.registerDataComponent();
		ModConsumeEffects.registerModConsumeEffects();

		//networking
		ModPackets.registerPackets();
		ServerPlayerEvents.JOIN.register(ModServerEvents::onPlayerJoin);
		ServerPlayerEvents.COPY_FROM.register(ModServerEvents::onPlayerCopyFrom);
		ServerPlayerEvents.AFTER_RESPAWN.register(ModServerEvents::onPlayerafterRespawn);

		LootTableEvents.MODIFY.register(ModLootTableModifiers::modifyLoottables);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
