package werdna.tutorial.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;
import werdna.tutorial.Tutorial;
import werdna.tutorial.sounds.ModSounds;

public class ModJukeboxSongs {
    public static final ResourceKey<JukeboxSong> BAR_BRAWL_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            Identifier.fromNamespaceAndPath(Tutorial.MOD_ID, "bar_brawl"));

    public static void bootstrap(BootstrapContext<JukeboxSong> context)
    {
        registerJukebox(context, BAR_BRAWL_KEY, ModSounds.BAR_BRAWL, 162, 15);
    }

    private static void registerJukebox(BootstrapContext<JukeboxSong>context, ResourceKey<JukeboxSong> key,
                                        final Holder.Reference<SoundEvent> soundEvent, int length, int comparitor)
    {
        context.register(key, new JukeboxSong(soundEvent,
                Component.translatable(Util.makeDescriptionId("juke_song",key.identifier())), length, comparitor));
    }
    {

    }
}
