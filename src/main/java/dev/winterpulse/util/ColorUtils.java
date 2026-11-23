package dev.winterpulse.util;

public final class ColorUtils {
    private ColorUtils() {}
    public static int argb(int a, int r, int g, int b) { return (a << 24) | (r << 16) | (g << 8) | b; }
    public static int rainbow(long time, float speed) {
        int rgb = java.awt.Color.HSBtoRGB((time % 10000L) / 10000f * speed, .75f, 1f);
        return 0xFF000000 | (rgb & 0xFFFFFF);
    }
}
