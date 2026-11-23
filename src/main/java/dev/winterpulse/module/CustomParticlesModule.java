package dev.winterpulse.module;

import net.minecraft.client.MinecraftClient;
import java.util.ArrayDeque;

public final class CustomParticlesModule {
    private static final int MAX = 128;
    private final ArrayDeque<Particle> active = new ArrayDeque<>(MAX);
    private final ArrayDeque<Particle> pool = new ArrayDeque<>(MAX);
    public CustomParticlesModule() { for (int i=0;i<MAX;i++) pool.add(new Particle()); }
    public void spawn(double x,double y,double z) { if (pool.isEmpty()) return; Particle p=pool.removeFirst(); p.reset(x,y,z); active.addLast(p); }
    public void tick(MinecraftClient client) { for (var it=active.iterator();it.hasNext();) { Particle p=it.next(); p.age++; p.x+=p.vx; p.y+=p.vy; p.z+=p.vz; p.vy-=.008; p.vx*=.96; p.vz*=.96; if(p.age>30){it.remove();pool.addLast(p);} } }
    private static final class Particle { double x,y,z,vx,vy,vz; int age; void reset(double x,double y,double z){this.x=x;this.y=y;this.z=z;age=0;vx=0;vy=.06;vz=0;} }
}
