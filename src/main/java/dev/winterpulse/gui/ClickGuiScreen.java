package dev.winterpulse.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public final class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Winter Pulse Visuals")); }
    @Override public void render(DrawContext c,int mouseX,int mouseY,float delta) {
        c.fill(0,0,width,height,0x880B0E16);
        int left=width/2-180, top=height/2-120;
        c.fill(left,top,left+360,top+240,0xEE171B26);
        c.drawText(textRenderer,"Winter Pulse",left+20,top+18,0xFFEAF2FF,true);
        c.drawText(textRenderer,"Visuals",left+20,top+55,0xFF9EDCFF,false);
        c.drawText(textRenderer,"China Hat     ON",left+28,top+82,0xFFD8E1F0,false);
        c.drawText(textRenderer,"Hit Particles  ON",left+28,top+104,0xFFD8E1F0,false);
        c.drawText(textRenderer,"Jump Circles   ON",left+28,top+126,0xFFD8E1F0,false);
        c.drawText(textRenderer,"Right Shift — close",left+20,top+210,0xFF8793A8,false);
        super.render(c,mouseX,mouseY,delta);
    }
}
