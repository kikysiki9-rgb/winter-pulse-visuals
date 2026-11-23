package dev.winterpulse;

import dev.winterpulse.gui.ClickGuiScreen;
import dev.winterpulse.module.ChinaHatModule;
import dev.winterpulse.module.CustomParticlesModule;
import dev.winterpulse.module.JumpCirclesModule;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class WinterPulseClient implements ClientModInitializer {
    public static final ChinaHatModule CHINA_HAT = new ChinaHatModule();
    public static final CustomParticlesModule PARTICLES = new CustomParticlesModule();
    public static final JumpCirclesModule JUMP_CIRCLES = new JumpCirclesModule();
    private static KeyBinding guiKey;

    @Override public void onInitializeClient() {
        guiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.winterpulse.gui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "category.winterpulse"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (guiKey.wasPressed()) client.setScreen(new ClickGuiScreen());
            CHINA_HAT.tick(client); PARTICLES.tick(client); JUMP_CIRCLES.tick(client);
        });
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> { });
    }
}
