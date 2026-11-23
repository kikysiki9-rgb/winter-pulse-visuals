package dev.winterpulse.util;

public final class AnimationUtils {
    private AnimationUtils() {}
    public static float lerp(float current, float target, float factor) { return current + (target - current) * Math.max(0f, Math.min(1f, factor)); }
    public static float easeOut(float t) { t = Math.max(0f, Math.min(1f, t)); float inv = 1f - t; return 1f - inv * inv * inv; }
}
