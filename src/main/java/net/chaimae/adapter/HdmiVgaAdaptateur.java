package net.chaimae.adapter;

import net.chaimae.Computer.Hdmi;
import net.chaimae.Computer.Tv;
import net.chaimae.Computer.Vga;

public class HdmiVgaAdaptateur implements Vga {
    private Hdmi hdmi;
    @Override
    public void print(String message) {
        hdmi.view(message.getBytes());
    }

    public void setHdmi(Tv tv) {
        this.hdmi = tv;
    }
}
