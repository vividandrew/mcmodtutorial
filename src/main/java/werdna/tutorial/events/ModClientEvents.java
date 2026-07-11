package werdna.tutorial.events;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import werdna.tutorial.Tutorial;
import werdna.tutorial.attachments.ModAttachmentTypes;
import werdna.tutorial.data.ModDataComponent;
import werdna.tutorial.keybinds.ModKeyMapping;
import werdna.tutorial.networking.packet.ModManaPayloadS2C;
import werdna.tutorial.networking.packet.ModTestPayloadC2S;

public class ModClientEvents {
    public static void onEndTick(Minecraft cl)
    {
        while(ModKeyMapping.K_KEYBIND.consumeClick())
        {
            //cl.player.sendSystemMessage(Component.literal("K key has been pressed {Default:K}"));
            ClientPlayNetworking.send(new ModTestPayloadC2S("Chicken joe ", 620));
        }
    }

    public static void addHudElement(GuiGraphicsExtractor gge, DeltaTracker delta)
    {
        int x = gge.guiWidth() /2;
        int y = gge.guiHeight();

        if(!Minecraft.getInstance().player.isCreative() && !Minecraft.getInstance().player.isSpectator()
                && Minecraft.getInstance().player.hasAttached(ModAttachmentTypes.MANA))
        {
            for(int i = 0; i < 5; i++)
            {
                gge.blitSprite(RenderPipelines.GUI_OPAQUE_TEXTURED_BACKGROUND, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "mana_icon_bg"),
                        16,16, 0, 0, x -95 + i * 18, y - 55, 16,16);
            }
            for(int i = 0; i < Minecraft.getInstance().player.getAttached(ModAttachmentTypes.MANA); i++)
            {
                gge.blitSprite(RenderPipelines.GUI_OPAQUE_TEXTURED_BACKGROUND, Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "mana_icon"),
                        16,16, 0, 0, x -95 + i * 18, y - 55, 16,16);
            }
        }
    }
}
