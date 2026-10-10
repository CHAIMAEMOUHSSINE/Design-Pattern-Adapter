package net.chaimae.adapter;

import net.chaimae.Computer.Hdmi;
import net.chaimae.Computer.SuperVp;
import net.chaimae.Computer.Tv;
import net.chaimae.Computer.Vga;

public class HdmiVgaAdaptateur implements Vga {
    private Hdmi hdmi;

    public HdmiVgaAdaptateur(Tv tv) {
        this.hdmi = tv;
    }

    @Override
    public void print(String message) {
        hdmi.view(message.getBytes());
    }

    public void setHdmi(SuperVp tv) {
        this.hdmi = tv;
    }
}
