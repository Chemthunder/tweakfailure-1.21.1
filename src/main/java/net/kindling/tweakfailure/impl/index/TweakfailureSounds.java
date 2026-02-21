package net.kindling.tweakfailure.impl.index;

import net.kindling.tweakfailure.impl.Tweakfailure;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface TweakfailureSounds {
    Map<SoundEvent, Identifier> SOUNDS = new LinkedHashMap<>();

    SoundEvent TALIONIUM = create("talionium");
    RegistryKey<JukeboxSong> TALIONIUM_MUSIC = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Tweakfailure.id("talionium"));


    private static SoundEvent create(String name) {
        SoundEvent soundEvent = SoundEvent.of(Tweakfailure.id(name));
        SOUNDS.put(soundEvent, Tweakfailure.id(name));
        return soundEvent;
    }

    static void index() {
        SOUNDS.keySet().forEach(soundEvent -> {
            Registry.register(Registries.SOUND_EVENT, SOUNDS.get(soundEvent), soundEvent);
        });
    }
}
