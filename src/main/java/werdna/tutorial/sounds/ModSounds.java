package werdna.tutorial.sounds;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import werdna.tutorial.Tutorial;

import java.util.function.Function;

public class ModSounds {

    public static final SoundEvent CHISEL_USE = register("chisel_use");

    public static final SoundEvent MAGIC_BLOCK_BREAK = register("magic_block_break");
    public static final SoundEvent MAGIC_BLOCK_FALL = register("magic_block_fall");
    public static final SoundEvent MAGIC_BLOCK_HIT = register("magic_block_hit");
    public static final SoundEvent MAGIC_BLOCK_PLACE = register("magic_block_place");
    public static final SoundEvent MAGIC_BLOCK_STEP = register("magic_block_step");

    public static final SoundType MAGIC_BLOCK_SOUNDS = new SoundType(1f,1f,
            MAGIC_BLOCK_BREAK,MAGIC_BLOCK_STEP,MAGIC_BLOCK_PLACE,MAGIC_BLOCK_HIT,MAGIC_BLOCK_FALL);

    public static final Holder.Reference<SoundEvent> BAR_BRAWL = registerJukeBoxSong("bar_brawl");

    private static Holder.Reference<SoundEvent> registerJukeBoxSong(String name)
    {
        Identifier id = Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT,id, SoundEvent.createVariableRangeEvent(id));
    }
    private static SoundEvent register(String name)
    {
        Identifier id = Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id,
                SoundEvent.createVariableRangeEvent(id));
    }
    public static void registerSounds()
    {
        Tutorial.LOGGER.info("Registering Sounds for " + Tutorial.MOD_ID);
    }
}
