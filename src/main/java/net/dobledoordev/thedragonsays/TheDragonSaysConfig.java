package net.dobledoordev.thedragonsays;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class TheDragonSaysConfig {
    public static final TheDragonSaysConfig.General GENERAL;
    static final ForgeConfigSpec spec;

    static {
        final Pair<General, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(TheDragonSaysConfig.General::new);
        spec = specPair.getRight();
        GENERAL = specPair.getLeft();
    }

    public static class General {
        public ForgeConfigSpec.DoubleValue roarVolumeMultiplier;
        public ForgeConfigSpec.DoubleValue roarPitchDecayRate;
        public ForgeConfigSpec.DoubleValue roarPitchOffset;
        public ForgeConfigSpec.DoubleValue purrVolumeMultiplier;
        public ForgeConfigSpec.DoubleValue purrPitchDecayRate;
        public ForgeConfigSpec.DoubleValue purrPitchOffset;
        public ForgeConfigSpec.DoubleValue growlVolumeMultiplier;
        public ForgeConfigSpec.DoubleValue growlPitchDecayRate;
        public ForgeConfigSpec.DoubleValue growlPitchOffset;
        public ForgeConfigSpec.DoubleValue hissVolumeMultiplier;
        public ForgeConfigSpec.DoubleValue hissPitchDecayRate;
        public ForgeConfigSpec.DoubleValue hissPitchOffset;

        public ForgeConfigSpec.BooleanValue usePlayerPitchForRoarPitch;
        public ForgeConfigSpec.BooleanValue usePlayerPitchForPurrPitch;
        public ForgeConfigSpec.BooleanValue usePlayerPitchForGrowlPitch;
        public ForgeConfigSpec.BooleanValue usePlayerPitchForHissPitch;

        General(ForgeConfigSpec.Builder builder) {
            {

                builder.comment("Roar Settings")
                        .push("Roar");

                roarVolumeMultiplier = builder
                        .comment("This number multiplied by current max health = how loud the sound should be.")
                        .defineInRange("roarVolumeMultiplier", 0.11f, 0, 1);

                roarPitchDecayRate = builder
                        .comment("The pitch decay rate based off health. More negative = faster decay, refer to this graph for an example: https://www.desmos.com/calculator/wouvnxpihn O = Offset D = Decay Rate, Y = Output Pitch")
                        .defineInRange("roarPitchDecayRate", -0.055f, -1, 1);

                roarPitchOffset = builder
                        .comment("The pitch decay rate based off health. More negative = faster decay, refer to this graph for an example: https://www.desmos.com/calculator/wouvnxpihn O = Offset D = Decay Rate, Y = Output Pitch")
                        .defineInRange("roarPitchOffset", 2.8f, -5, 5);

                usePlayerPitchForRoarPitch = builder
                        .comment("Makes the current look pitch (looking up/down) change the pitch of the sound made before being made.")
                        .define("usePlayerPitchForRoarPitch", false);

                builder.pop();

                builder.comment("Purr Settings")
                        .push("Purr");

                purrVolumeMultiplier = builder
                        .comment("This number multiplied by current max health = how loud the sound should be.")
                        .defineInRange("purrVolumeMultiplier", 0.125f, 0, 1);

                purrPitchDecayRate = builder
                        .comment("The pitch decay rate based off health. More negative = faster decay, refer to this graph for an example: https://www.desmos.com/calculator/wouvnxpihn O = Offset D = Decay Rate, Y = Output Pitch")
                        .defineInRange("purrPitchDecayRate", -0.055f, -1, 1);

                purrPitchOffset = builder
                        .comment("The pitch decay rate based off health. More negative = faster decay, refer to this graph for an example: https://www.desmos.com/calculator/wouvnxpihn O = Offset D = Decay Rate, Y = Output Pitch")
                        .defineInRange("purrPitchOffset", 2.8f, -5, 5);

                usePlayerPitchForPurrPitch = builder
                        .comment("Makes the current look pitch (looking up/down) change the pitch of the sound made before being made.")
                        .define("usePlayerPitchForPurrPitch", false);

                builder.pop();

                builder.comment("Growl Settings")
                        .push("Growl");

                growlVolumeMultiplier = builder
                        .comment("This number multiplied by current max health = how loud the sound should be.")
                        .defineInRange("growlVolumeMultiplier", 0.125f, 0, 1);

                growlPitchDecayRate = builder
                        .comment("The pitch decay rate based off health. More negative = faster decay, refer to this graph for an example: https://www.desmos.com/calculator/wouvnxpihn O = Offset D = Decay Rate, Y = Output Pitch")
                        .defineInRange("growlPitchDecayRate", -0.055f, -1, 1);

                growlPitchOffset = builder
                        .comment("The pitch decay rate based off health. More negative = faster decay, refer to this graph for an example: https://www.desmos.com/calculator/wouvnxpihn O = Offset D = Decay Rate, Y = Output Pitch")
                        .defineInRange("growlPitchOffset", 2.8f, -5, 5);

                usePlayerPitchForGrowlPitch = builder
                        .comment("Makes the current look pitch (looking up/down) change the pitch of the sound made before being made.")
                        .define("usePlayerPitchForGrowlPitch", false);

                builder.pop();

                builder.comment("Hiss Settings")
                        .push("Hiss");

                hissVolumeMultiplier = builder
                        .comment("This number multiplied by current max health = how loud the sound should be.")
                        .defineInRange("hissVolumeMultiplier", 0.125f, 0, 1);

                hissPitchDecayRate = builder
                        .comment("The pitch decay rate based off health. More negative = faster decay, refer to this graph for an example: https://www.desmos.com/calculator/wouvnxpihn O = Offset D = Decay Rate, Y = Output Pitch")
                        .defineInRange("hissPitchDecayRate", -0.055f, -1, 1);

                hissPitchOffset = builder
                        .comment("The pitch decay rate based off health. More negative = faster decay, refer to this graph for an example: https://www.desmos.com/calculator/wouvnxpihn O = Offset D = Decay Rate, Y = Output Pitch")
                        .defineInRange("hissPitchOffset", 2.8f, -5, 5);

                usePlayerPitchForHissPitch = builder
                        .comment("Makes the current look pitch (looking up/down) change the pitch of the sound made before being made.")
                        .define("usePlayerPitchForHissPitch", false);

                builder.pop();
            }
        }
    }
}
