package werdna.tutorial;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.resources.Identifier;
import werdna.tutorial.events.ModClientEvents;
import werdna.tutorial.keybinds.ModKeyMapping;

public class TutorialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModKeyMapping.registerKeys();

        ClientTickEvents.END_CLIENT_TICK.register(ModClientEvents::onEndTick);
        HudElementRegistry.addFirst(Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "mana_display"), ModClientEvents::addHudElement);
    }
}
