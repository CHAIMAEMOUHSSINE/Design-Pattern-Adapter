package net.chaimae;

import net.chaimae.Computer.Ecran;
import net.chaimae.Computer.Tv;
import net.chaimae.Computer.UniteCentral;
import net.chaimae.Computer.VideoProjecteur;
import net.chaimae.adapter.HdmiVgaAdaptateur;

public class Main {
    public static void main(String[] args) {
        UniteCentral uniteCentral = new UniteCentral();
        uniteCentral.setVga(new Ecran());
        uniteCentral.print("Hello World");
        uniteCentral.setVga(new VideoProjecteur());
        uniteCentral.print("Hello ");

        HdmiVgaAdaptateur hdmiVgaAdaptateur = new HdmiVgaAdaptateur();
        hdmiVgaAdaptateur.setHdmi(new Tv());
        uniteCentral.setVga(hdmiVgaAdaptateur);
        hdmiVgaAdaptateur.print("chaimae Lghzala");
    }}