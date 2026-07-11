package werdna.tutorial.keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.server.dialog.Input;
import org.lwjgl.glfw.GLFW;
import werdna.tutorial.Tutorial;

public class ModKeyMapping {
    public static final KeyMapping K_KEYBIND = KeyMappingHelper.registerKeyMapping(
        new KeyMapping("key.tutorial.k", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, KeyMapping.Category.MISC)
    );

    public static void registerKeys()
    {
        Tutorial.LOGGER.info("Registering keys for " + Tutorial.MOD_ID);
    }
}
