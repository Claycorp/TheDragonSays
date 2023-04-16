package net.dobledoordev.thedragonsays;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static net.dobledoordev.thedragonsays.TheDragonSays.*;

public class RegisterSounds {
    @SubscribeEvent
    public static void soundRegistry(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(GROWL_SOUND);
        event.getRegistry().register(HISS_SOUND);
        event.getRegistry().register(ROAR_SOUND);
        event.getRegistry().register(PURR_SOUND);
    }

}
