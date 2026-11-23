package dev.winterpulse.module;

import net.minecraft.client.MinecraftClient;

public final class JumpCirclesModule {
    private int age;
    private boolean wasGrounded;
    public float radius() { return Math.min(1f, age / 18f) * .8f; }
    public float alpha() { return Math.max(0f, 1f - age / 18f); }
    public void tick(MinecraftClient client) {
        if (client.player == null) return;
        boolean grounded = client.player.isOnGround();
        if (wasGrounded && !grounded) age = 0;
        if (age < 18) age++;
        wasGrounded = grounded;
    }
}
