package net.dobledoordev.thedragonsays;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.PacketDistributor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("thedragonsays")
public class TheDragonSays {
    public static final String MODID = "thedragonsays";

    public static final SoundEvent ROAR_SOUND = new SoundEvent(new ResourceLocation(TheDragonSays.MODID, "dragon_roar")).setRegistryName(TheDragonSays.MODID, "dragon_roar");
    public static final SoundEvent PURR_SOUND = new SoundEvent(new ResourceLocation(TheDragonSays.MODID, "dragon_purr")).setRegistryName(TheDragonSays.MODID, "dragon_purr");
    public static final SoundEvent GROWL_SOUND = new SoundEvent(new ResourceLocation(TheDragonSays.MODID, "dragon_growl")).setRegistryName(TheDragonSays.MODID, "dragon_growl");
    public static final SoundEvent HISS_SOUND = new SoundEvent(new ResourceLocation(TheDragonSays.MODID, "dragon_hiss")).setRegistryName(TheDragonSays.MODID, "dragon_hiss");

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public TheDragonSays() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().register(RegisterSounds.class);

        // Register config.
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, TheDragonSaysConfig.spec);

        PacketHandler.init();
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
        // This is needed to reload the config?
        if (configEvent.getConfig().getSpec() == TheDragonSaysConfig.spec) {
            LOGGER.info("Reloaded The Dragon Says Config!");
            TheDragonSaysConfig.spec.afterReload();
        }
    }

    @SubscribeEvent
    public void onKeyEvent(TickEvent.ClientTickEvent event) {//lol this bad.
        if (ClientCrap.DRAGON_ROAR.isDown()) {
            TheDragonSaysConfig.spec.afterReload();
            PacketHandler.send(PacketDistributor.SERVER.noArg(),
                    new KeyPressPacket(1, TheDragonSaysConfig.GENERAL.roarPitchDecayRate.get().floatValue(),
                            TheDragonSaysConfig.GENERAL.roarVolumeMultiplier.get().floatValue(), TheDragonSaysConfig.GENERAL.roarPitchOffset.get().floatValue(), TheDragonSaysConfig.GENERAL.usePlayerPitchForRoarPitch.get()));
        }

        if (ClientCrap.DRAGON_PURR.consumeClick()) {
            PacketHandler.send(PacketDistributor.SERVER.noArg(),
                    new KeyPressPacket(2, TheDragonSaysConfig.GENERAL.purrPitchDecayRate.get().floatValue(),
                            TheDragonSaysConfig.GENERAL.purrVolumeMultiplier.get().floatValue(), TheDragonSaysConfig.GENERAL.purrPitchOffset.get().floatValue(), TheDragonSaysConfig.GENERAL.usePlayerPitchForPurrPitch.get()));
        }

        if (ClientCrap.DRAGON_GROWL.consumeClick()) {
            PacketHandler.send(PacketDistributor.SERVER.noArg(),
                    new KeyPressPacket(3, TheDragonSaysConfig.GENERAL.growlPitchDecayRate.get().floatValue(),
                            TheDragonSaysConfig.GENERAL.growlVolumeMultiplier.get().floatValue(), TheDragonSaysConfig.GENERAL.growlPitchOffset.get().floatValue(), TheDragonSaysConfig.GENERAL.usePlayerPitchForGrowlPitch.get()));
        }

        if (ClientCrap.DRAGON_HISS.consumeClick()) {
            PacketHandler.send(PacketDistributor.SERVER.noArg(),
                    new KeyPressPacket(4, TheDragonSaysConfig.GENERAL.hissPitchDecayRate.get().floatValue(),
                            TheDragonSaysConfig.GENERAL.hissVolumeMultiplier.get().floatValue(), TheDragonSaysConfig.GENERAL.hissPitchOffset.get().floatValue(), TheDragonSaysConfig.GENERAL.usePlayerPitchForHissPitch.get()));
        }
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(ClientCrap.DRAGON_ROAR);
        ClientRegistry.registerKeyBinding(ClientCrap.DRAGON_PURR);
        ClientRegistry.registerKeyBinding(ClientCrap.DRAGON_GROWL);
        ClientRegistry.registerKeyBinding(ClientCrap.DRAGON_HISS);
    }
}
