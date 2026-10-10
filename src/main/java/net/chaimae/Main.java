package net.chaimae;

import net.chaimae.Computer.*;
import net.chaimae.adapter.HdmiVgaAdaptateur;

public class Main {
    public static void main(String[] args) {
        UniteCentral uniteCentral = new UniteCentral();
        uniteCentral.setVga(new Ecran());
        uniteCentral.print("Hello World");
        uniteCentral.setVga(new VideoProjecteur());
        uniteCentral.print("Hello ");

        HdmiVgaAdaptateur hdmiVgaAdaptateur = new HdmiVgaAdaptateur(new Tv());
        uniteCentral.setVga(hdmiVgaAdaptateur);
        hdmiVgaAdaptateur.print("chaimae Lghzala");

        uniteCentral.setVga(new SuperVp());
        uniteCentral.print("chaimae Lfenna");

        HdmiVgaAdaptateur hdmiVgaAdapter1 = new HdmiVgaAdaptateur(new Tv());
        hdmiVgaAdapter1.setHdmi(new SuperVp());
        uniteCentral.print("chaimae Lghzala");


    }}