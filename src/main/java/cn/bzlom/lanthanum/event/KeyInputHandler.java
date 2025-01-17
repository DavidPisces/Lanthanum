package cn.bzlom.lanthanum.event;

import cn.bzlom.lanthanum.networking.ModMessage;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;


public class KeyInputHandler {
    public static final String KEY_CATEGORY_LANTHANUM = "key.category.lanthanum.lanthanum";
    public static final String KEY_DRINK_WATER = "key.lanthanum.drink_water";

    public static KeyBinding drinkingKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (drinkingKey.wasPressed()) {
                ClientPlayNetworking.send(ModMessage.DRINKING_ID, PacketByteBufs.create());
            }
        });
    }

    public static void register() {
        drinkingKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_DRINK_WATER, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O, KEY_CATEGORY_LANTHANUM));

        registerKeyInputs();
    }
}