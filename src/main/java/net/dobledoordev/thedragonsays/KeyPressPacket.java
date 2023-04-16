package net.dobledoordev.thedragonsays;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class KeyPressPacket {
    float pitch;
    float volume;
    float pitchOffset;
    boolean usePlayerLookPitch;
    int soundToPlay;

    public KeyPressPacket(FriendlyByteBuf buffer) {
        soundToPlay = buffer.readInt();
        pitch = buffer.readFloat();
        volume = buffer.readFloat();
        pitchOffset = buffer.readFloat();
        usePlayerLookPitch = buffer.readBoolean();
    }

    public KeyPressPacket(int soundToPlay, float pitch, float volume, float pitchOffset, boolean usePlayerLookPitch) {
        this.soundToPlay = soundToPlay;
        this.pitch = pitch;
        this.volume = volume;
        this.pitchOffset = pitchOffset;
        this.usePlayerLookPitch = usePlayerLookPitch;
    }

    void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(soundToPlay);
        buffer.writeFloat(pitch);
        buffer.writeFloat(volume);
        buffer.writeFloat(pitchOffset);
        buffer.writeBoolean(usePlayerLookPitch);
    }

    void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        ServerPlayer player = context.getSender();

        if (player != null) {
            Level level = context.getSender().level;
            if (!level.isClientSide) {
                float maxHealth = player.getMaxHealth();
                float playerLookPitch = 0.8f + (float) (player.getLookAngle().y / 2);
                float healthVolume = maxHealth * volume + 2;
//                TheDragonSays.LOGGER.log(Level.ERROR, "Look Pitch: " +playerLookPitch);
//                TheDragonSays.LOGGER.log(Level.ERROR, "Max Health: " + maxHealth);
//                TheDragonSays.LOGGER.log(Level.ERROR, "Pitch: " + pitch);
//                TheDragonSays.LOGGER.log(Level.ERROR, "Health Pitch: " + (pitch * maxHealth + pitchOffset));
//                player.getAttribute(Attributes.MAX_HEALTH).removeModifier(UUID.fromString("03574e62-f9e4-4f1b-85ad-fde00915e446"));
//                player.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(new AttributeModifier(UUID.fromString("03574e62-f9e4-4f1b-85ad-fde00915e446"), "testbuff", 20, AttributeModifier.Operation.ADDITION));
                switch (soundToPlay) {
                    // roar
                    case 1 ->
                        // player, pos, sound, category, volume, pitch
                            level.playSound(null, player.blockPosition(), TheDragonSays.ROAR_SOUND, SoundSource.PLAYERS, healthVolume - 3.5f, usePlayerLookPitch ? playerLookPitch : pitch * maxHealth + pitchOffset);
                    case 2 ->
                        // player, pos, sound, category, volume, pitch
                            level.playSound(null, player.blockPosition(), TheDragonSays.PURR_SOUND, SoundSource.PLAYERS, healthVolume + 4, usePlayerLookPitch ? playerLookPitch : pitch * maxHealth + pitchOffset);
                    case 3 ->
                        // player, pos, sound, category, volume, pitch
                            level.playSound(null, player.blockPosition(), TheDragonSays.GROWL_SOUND, SoundSource.PLAYERS, healthVolume, usePlayerLookPitch ? playerLookPitch : pitch * maxHealth + pitchOffset);
                    case 4 ->
                        // player, pos, sound, category, volume, pitch
                            level.playSound(null, player.blockPosition(), TheDragonSays.HISS_SOUND, SoundSource.PLAYERS, healthVolume, usePlayerLookPitch ? playerLookPitch : pitch * maxHealth + pitchOffset);
                }
            }
        }
        contextSupplier.get().setPacketHandled(true);
    }
}
