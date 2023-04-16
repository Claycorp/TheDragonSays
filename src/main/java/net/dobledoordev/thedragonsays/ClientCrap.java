package net.dobledoordev.thedragonsays;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class ClientCrap {
    public static final KeyMapping DRAGON_ROAR = new KeyMapping("thedragonsays.key.roar", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_0, "thedragonsays.key.category.dragonnoise");
    public static final KeyMapping DRAGON_PURR = new KeyMapping("thedragonsays.key.purr", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_1, "thedragonsays.key.category.dragonnoise");
    public static final KeyMapping DRAGON_GROWL = new KeyMapping("thedragonsays.key.growl", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_2, "thedragonsays.key.category.dragonnoise");
    public static final KeyMapping DRAGON_HISS = new KeyMapping("thedragonsays.key.hiss", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_KP_3, "thedragonsays.key.category.dragonnoise");
}
