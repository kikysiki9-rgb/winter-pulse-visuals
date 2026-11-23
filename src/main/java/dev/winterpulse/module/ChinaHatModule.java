package dev.winterpulse.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

/** State-only module; rendering is intentionally registered centrally to avoid per-frame allocations. */
public final class ChinaHatModule {
    public boolean enabled = true;
    public float radius = .65f, height = .28f, alpha = .65f;
    private float yaw, pitch;
    public void tick(MinecraftClient client) {
        ClientPlayerEntity p = client.player;
        if (p == null) return;
        float d = client.getRenderTickCounter().getTickDelta(false);
        yaw = p.prevYaw + (p.getYaw() - p.prevYaw) * d;
        pitch = p.prevPitch + (p.getPitch() - p.prevPitch) * d;
    }
    public float yaw() { return yaw; }
    public float pitch() { return pitch; }
}
