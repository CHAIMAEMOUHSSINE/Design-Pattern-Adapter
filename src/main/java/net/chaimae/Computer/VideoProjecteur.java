package net.chaimae.Computer;

public class VideoProjecteur implements Vga{
    @Override
    public void print(String message) {
        System.out.println("VideoProjecteur: " + message);
    }
}
