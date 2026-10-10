package net.chaimae.Computer;

public class Ecran implements Vga{
    @Override
    public void print(String message) {
        System.out.println("Ecran: " + message);
    }
}
